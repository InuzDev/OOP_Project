package Server;

import Logic.BolsaEmpleo;
import Logic.Empresa;
import Logic.Oferta;
import Logic.Persona;
import Logic.Solicitud;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Servidor {

   private final int puerto;
   private final BolsaEmpleo controlador;
   private final ScheduledExecutorService programadorRespaldos =
      Executors.newSingleThreadScheduledExecutor();

   public Servidor(int puerto, BolsaEmpleo controlador) {
      this.puerto = puerto;
      this.controlador = controlador;
   }

   public void iniciarRespaldosAutomaticos(int intervaloMinutos) {
      programadorRespaldos.scheduleAtFixedRate(
         controlador::crearRespaldo,
         0,
         intervaloMinutos,
         TimeUnit.MINUTES
      );
      System.out.println(
         "Respaldo automatico programado cada " +
            intervaloMinutos +
            " minuto(s)."
      );
   }

   public void iniciar() throws IOException {
      try (ServerSocket serverSocket = new ServerSocket(puerto)) {
         System.out.println(
            "Servidor escuchando en el puerto " + puerto + "..."
         );

         while (true) {
            Socket socketCliente = serverSocket.accept();
            System.out.println(
               "Cliente conectado desde " + socketCliente.getInetAddress()
            );

            Thread hilo = new Thread(
               new ManejadorCliente(socketCliente, controlador)
            );
            hilo.start();
         }
      }
   }

   public static void main(String[] args) throws IOException {
      int puerto = 5000;
      int intervaloRespaldoMinutos = 5;

      if (args.length > 0) {
         puerto = Integer.parseInt(args[0]);
      }
      if (args.length > 1) {
         intervaloRespaldoMinutos = Integer.parseInt(args[1]);
      }

      BolsaEmpleo controlador = new BolsaEmpleo();
      Servidor servidor = new Servidor(puerto, controlador);

      servidor.iniciarRespaldosAutomaticos(intervaloRespaldoMinutos);

      Thread hiloServidor = new Thread(() -> {
         try {
            servidor.iniciar();
         } catch (IOException e) {
            System.out.println("El servidor se detuvo: " + e.getMessage());
         }
      });
      hiloServidor.setDaemon(true);
      hiloServidor.start();

      servidor.consolaAdministracion(controlador);
   }

   private void consolaAdministracion(BolsaEmpleo controlador) {
      Scanner lector = new Scanner(System.in);

      System.out.println();
      System.out.println(
         "Consola de administracion: respaldo | listar | restaurar <nombre> | salir"
      );

      while (true) {
         System.out.print("> ");
         String linea = lector.nextLine().trim();

         if (linea.isEmpty()) {
            continue;
         }

         if (linea.equalsIgnoreCase("salir")) {
            System.out.println(
               "Cerrando consola de administracion (el servidor sigue activo)."
            );
            break;
         }

         if (linea.equalsIgnoreCase("respaldo")) {
            controlador.crearRespaldo();
            continue;
         }

         if (linea.equalsIgnoreCase("listar")) {
            List<String> respaldos = controlador.listarRespaldos();
            if (respaldos.isEmpty()) {
               System.out.println("No hay respaldos todavia.");
            } else {
               for (String nombre : respaldos) {
                  System.out.println("  - " + nombre);
               }
            }
            continue;
         }

         if (linea.toLowerCase().startsWith("restaurar ")) {
            String nombre = linea.substring("restaurar ".length()).trim();
            controlador.restaurar(nombre);
            continue;
         }

         System.out.println(
            "Comando desconocido. Use: respaldo | listar | restaurar <nombre> | salir"
         );
      }
   }

   private static class ManejadorCliente implements Runnable {

      private final Socket socket;
      private final BolsaEmpleo controlador;

      ManejadorCliente(Socket socket, BolsaEmpleo controlador) {
         this.socket = socket;
         this.controlador = controlador;
      }

      @Override
      public void run() {
         try (
            ObjectOutputStream salida = new ObjectOutputStream(
               socket.getOutputStream()
            )
         ) {
            salida.flush();

            try (
               ObjectInputStream entrada = new ObjectInputStream(
                  socket.getInputStream()
               )
            ) {
               while (true) {
                  Peticion peticion = (Peticion) entrada.readObject();

                  if (Peticion.DESCONECTAR.equals(peticion.getAccion())) {
                     break;
                  }

                  Respuesta respuesta = despachar(peticion);

                  salida.reset();
                  salida.writeObject(respuesta);
                  salida.flush();
               }
            }
         } catch (EOFException | java.net.SocketException e) {
            System.out.println("Cliente desconectado.");
         } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error con un cliente: " + e.getMessage());
         } finally {
            try {
               socket.close();
            } catch (IOException e) {}
         }
      }

      private Respuesta despachar(Peticion peticion) {
         String accion = peticion.getAccion();
         Object[] p = peticion.getParametros();

         try {
            synchronized (controlador) {
               switch (accion) {
                  case Peticion.LOGIN:
                     return Respuesta.ok(
                        controlador.login((String) p[0], (String) p[1])
                     );
                  case Peticion.REGISTRAR_PERSONAL:
                     controlador.registerPersonal((Persona) p[0]);
                     return Respuesta.ok(null);
                  case Peticion.REMOVER_PERSONAL:
                     return Respuesta.ok(
                        controlador.removePersonal((Integer) p[0])
                     );
                  case Peticion.BUSCAR_PERSONAL_POR_ID:
                     return Respuesta.ok(
                        controlador.searchPersonalById((Integer) p[0])
                     );
                  case Peticion.BUSCAR_PERSONAL_POR_CEDULA:
                     return Respuesta.ok(
                        controlador.searchPersonalByPersonalId((String) p[0])
                     );
                  case Peticion.LISTAR_PERSONAL:
                     return Respuesta.ok(controlador.showListPersonal());
                  case Peticion.LISTAR_TECNICOS:
                     return Respuesta.ok(controlador.showListTecnicians());
                  case Peticion.LISTAR_UNIVERSITARIOS:
                     return Respuesta.ok(controlador.listCollegeStudent());
                  case Peticion.LISTAR_OBREROS:
                     return Respuesta.ok(controlador.listLaborer());
                  case Peticion.REGISTRAR_EMPRESA:
                     controlador.registerEmpresa((Empresa) p[0]);
                     return Respuesta.ok(null);
                  case Peticion.REMOVER_EMPRESA:
                     return Respuesta.ok(
                        controlador.removeEmpresa((String) p[0])
                     );
                  case Peticion.BUSCAR_EMPRESA_POR_RNC:
                     return Respuesta.ok(
                        controlador.searchEmpresaByRNC((String) p[0])
                     );
                  case Peticion.LISTAR_EMPRESAS:
                     return Respuesta.ok(controlador.showListEmpresa());
                  case Peticion.LISTAR_EMPRESAS_POR_TIPO:
                     return Respuesta.ok(
                        controlador.showListEmpresaByType((String) p[0])
                     );
                  case Peticion.CREAR_SOLICITUD:
                     controlador.createRequestPersonal((Solicitud) p[0]);
                     return Respuesta.ok(null);
                  case Peticion.REMOVER_SOLICITUD:
                     return Respuesta.ok(
                        controlador.removeRequest((Solicitud) p[0])
                     );
                  case Peticion.LISTAR_SOLICITUDES:
                     return Respuesta.ok(controlador.showListSolicitudes());
                  case Peticion.LISTAR_SOLICITUDES_POR_PERSONA:
                     return Respuesta.ok(
                        controlador.showListSolicitudesByPersonalId(
                           (Persona) p[0]
                        )
                     );
                  case Peticion.AGREGAR_OFERTA:
                     return Respuesta.ok(
                        controlador.addBusinessJobOffer(
                           (String) p[0],
                           (Oferta) p[1]
                        )
                     );
                  case Peticion.LISTAR_TODAS_OFERTAS:
                     return Respuesta.ok(controlador.showListAllOffers());
                  case Peticion.LISTAR_OFERTAS_ACTIVAS:
                     return Respuesta.ok(controlador.showActiveOffers());
                  case Peticion.CONTRATAR:
                     return Respuesta.ok(
                        controlador.contratar((Solicitud) p[0], (Oferta) p[1])
                     );
                  case Peticion.RENUNCIAR:
                     return Respuesta.ok(controlador.renunciar((Persona) p[0]));
                  case Peticion.TOGGLE_OFERTA_ACTIVA:
                     return Respuesta.ok(
                        controlador.toggleOfertaActiva(
                           (String) p[0],
                           (String) p[1]
                        )
                     );
                  case Peticion.CALCULAR_COINCIDENCIA:
                     return Respuesta.ok(
                        controlador.calcularCoincidencia(
                           (Oferta) p[0],
                           (Solicitud) p[1]
                        )
                     );
                  case Peticion.BUSCAR_MEJORES_CANDIDATOS:
                     return Respuesta.ok(
                        controlador.buscarMejoresCandidatos((Oferta) p[0])
                     );
                  case Peticion.ACTUALIZAR_PERSONAL:
                     return Respuesta.ok(
                        controlador.actualizarPersonal(
                           (Integer) p[0],
                           (String) p[1],
                           (String) p[2],
                           (String) p[3],
                           (String) p[4],
                           (String) p[5],
                           (String) p[6],
                           (Integer) p[7]
                        )
                     );
                  default:
                     return Respuesta.error("Accion desconocida: " + accion);
               }
            }
         } catch (Exception e) {
            return Respuesta.error(
               "Error procesando '" + accion + "': " + e.getMessage()
            );
         }
      }
   }
}
