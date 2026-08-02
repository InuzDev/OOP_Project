/**
 * Prueba automatizada de concurrencia: crea una oferta con UNA sola vacante
 * y lanza N clientes intentando contratar para esa misma oferta al mismo
 * tiempo (usando un CountDownLatch para que arranquen lo mas simultaneo
 * posible). El resultado esperado es EXACTAMENTE 1 contratacion exitosa,
 * sin importar cuantos clientes lo intenten a la vez.
 *
 * Uso: primero correr Servidor, despues:
 *   java Server.PruebaConcurrencia <host> <puerto> <numClientes>
 * Ambos argumentos de host/puerto/numClientes son opcionales
 * (por defecto: localhost, 5000, 5 clientes).
 */

package Server;

import Logic.Empresa;
import Logic.Obrero;
import Logic.Oferta;
import Logic.Persona;
import Logic.Representante;
import Logic.Solicitud;
import Logic.Usuario;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class PruebaConcurrencia {

   public static void main(String[] args) throws Exception {
      String host = args.length > 0 ? args[0] : "localhost";
      int puerto = args.length > 1 ? Integer.parseInt(args[1]) : 5000;
      int numClientes = args.length > 2 ? Integer.parseInt(args[2]) : 5;

      System.out.println(
         "Preparando prueba con " +
            numClientes +
            " clientes contra " +
            host +
            ":" +
            puerto
      );

      // Un cliente "administrador" para crear los datos de prueba.
      BolsaEmpleoRemoto admin = new BolsaEmpleoRemoto(host, puerto);

      Representante representante = new Representante(
         "Representante Prueba",
         "000-0000001",
         "000-0000001",
         "rep.prueba@test.com",
         "Direccion Prueba",
         "Gerente"
      );
      Usuario usuarioEmpresa = new Usuario(
         representante.getIdRepresentante(),
         "empresa.prueba@test.com",
         "clave123",
         "EMPRESA",
         true
      );
      Empresa empresa = new Empresa(
         "999-" + (System.currentTimeMillis() % 1000000) + "-9",
         "Empresa Prueba Concurrencia",
         "Direccion Prueba",
         "Santiago",
         "000-0000000",
         "empresa.prueba@test.com",
         "www.prueba.com",
         "Tecnologia",
         representante,
         usuarioEmpresa
      );
      admin.registerEmpresa(empresa);

      Oferta oferta = new Oferta(
         "TEST-" + System.currentTimeMillis(),
         "Puesto de Prueba",
         1, // <- SOLO UNA VACANTE, a proposito
         "Ambos",
         false,
         false,
         "Obrero",
         20000f,
         40000f,
         "Santiago",
         0,
         "Oferta generada por PruebaConcurrencia"
      );
      admin.addBusinessJobOffer(empresa.getRnc(), oferta);

      System.out.println(
         "Oferta creada: " + oferta.getCodigo() + " (1 vacante)."
      );
      System.out.println();

      CountDownLatch listos = new CountDownLatch(numClientes);
      CountDownLatch salida = new CountDownLatch(1);
      CountDownLatch terminados = new CountDownLatch(numClientes);
      AtomicInteger exitosos = new AtomicInteger(0);

      for (int i = 0; i < numClientes; i++) {
         final int idCliente = i;

         new Thread(() -> {
            try {
               BolsaEmpleoRemoto cliente = new BolsaEmpleoRemoto(host, puerto);

               Persona persona = new Obrero(
                  "Candidato " + idCliente,
                  "000-000" + idCliente,
                  "Masculino",
                  "000-0000000",
                  "candidato" + idCliente + ".prueba@test.com",
                  "Santiago",
                  0,
                  "Habilidades de prueba"
               );
               cliente.registerPersonal(persona);

               Solicitud solicitud = new Solicitud(
                  persona,
                  "Puesto de Prueba",
                  20000f,
                  40000f,
                  false
               );
               cliente.createRequestPersonal(solicitud);

               // Espera aqui hasta que TODOS los clientes esten listos y
               // registrados, para que el intento de contratar() de todos
               // ocurra lo mas cerca posible en el tiempo.
               listos.countDown();
               salida.await();

               boolean contratado = cliente.contratar(solicitud, oferta);
               System.out.println(
                  "Cliente " + idCliente + " -> contratado = " + contratado
               );

               if (contratado) {
                  exitosos.incrementAndGet();
               }

               cliente.desconectar();
            } catch (Exception e) {
               System.out.println(
                  "Cliente " + idCliente + " fallo: " + e.getMessage()
               );
            } finally {
               terminados.countDown();
            }
         }).start();
      }

      listos.await();
      System.out.println(
         "Todos los clientes listos. Disparando contratar() al mismo tiempo..."
      );
      System.out.println();
      salida.countDown();

      terminados.await();

      System.out.println();
      System.out.println("=================================================");
      System.out.println(
         "Resultado: " +
            exitosos.get() +
            " de " +
            numClientes +
            " contrataciones exitosas."
      );
      System.out.println(
         "Esperado:  exactamente 1 (la oferta solo tenia 1 vacante)."
      );
      System.out.println(exitosos.get() == 1 ? "PASO" : "FALLO");
      System.out.println("=================================================");

      admin.desconectar();
   }
}
