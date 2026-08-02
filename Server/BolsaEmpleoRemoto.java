package Server;

import Logic.Empresa;
import Logic.IBolsaEmpleo;
import Logic.Obrero;
import Logic.Oferta;
import Logic.Persona;
import Logic.Solicitud;
import Logic.Tecnico;
import Logic.Universitario;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class BolsaEmpleoRemoto implements IBolsaEmpleo {

   private final Socket socket;
   private final ObjectOutputStream salida;
   private final ObjectInputStream entrada;

   public BolsaEmpleoRemoto(String host, int puerto) throws IOException {
      socket = new Socket(host, puerto);

      salida = new ObjectOutputStream(socket.getOutputStream());
      salida.flush();
      entrada = new ObjectInputStream(socket.getInputStream());
   }

   private synchronized Object enviarPeticion(
      String accion,
      Object... parametros
   ) {
      try {
         Peticion peticion = new Peticion(accion, parametros);

         salida.reset();
         salida.writeObject(peticion);
         salida.flush();

         Respuesta respuesta = (Respuesta) entrada.readObject();

         if (!respuesta.isExito()) {
            throw new RuntimeException(respuesta.getMensajeError());
         }

         return respuesta.getResultado();
      } catch (IOException | ClassNotFoundException e) {
         throw new RuntimeException(
            "Error de comunicacion con el servidor: " + e.getMessage(),
            e
         );
      }
   }

   public void desconectar() {
      try {
         salida.writeObject(new Peticion(Peticion.DESCONECTAR));
         salida.flush();
      } catch (IOException e) {
      } finally {
         try {
            socket.close();
         } catch (IOException e) {
            // idem
         }
      }
   }

   @Override
   public Object login(String username, String password) {
      return enviarPeticion(Peticion.LOGIN, username, password);
   }

   @Override
   public void registerPersonal(Persona persona) {
      enviarPeticion(Peticion.REGISTRAR_PERSONAL, persona);
   }

   @Override
   public boolean removePersonal(int identificador) {
      return (Boolean) enviarPeticion(Peticion.REMOVER_PERSONAL, identificador);
   }

   @Override
   public Persona searchPersonalById(int identificador) {
      return (Persona) enviarPeticion(
         Peticion.BUSCAR_PERSONAL_POR_ID,
         identificador
      );
   }

   @Override
   public Persona searchPersonalByPersonalId(String cedula) {
      return (Persona) enviarPeticion(
         Peticion.BUSCAR_PERSONAL_POR_CEDULA,
         cedula
      );
   }

   @Override
   @SuppressWarnings("unchecked")
   public ArrayList<Persona> showListPersonal() {
      return (ArrayList<Persona>) enviarPeticion(Peticion.LISTAR_PERSONAL);
   }

   @Override
   @SuppressWarnings("unchecked")
   public ArrayList<Tecnico> showListTecnicians() {
      return (ArrayList<Tecnico>) enviarPeticion(Peticion.LISTAR_TECNICOS);
   }

   @Override
   @SuppressWarnings("unchecked")
   public ArrayList<Universitario> listCollegeStudent() {
      return (ArrayList<Universitario>) enviarPeticion(
         Peticion.LISTAR_UNIVERSITARIOS
      );
   }

   @Override
   @SuppressWarnings("unchecked")
   public ArrayList<Obrero> listLaborer() {
      return (ArrayList<Obrero>) enviarPeticion(Peticion.LISTAR_OBREROS);
   }

   @Override
   public void registerEmpresa(Empresa business) {
      enviarPeticion(Peticion.REGISTRAR_EMPRESA, business);
   }

   @Override
   public boolean removeEmpresa(String rnc) {
      return (Boolean) enviarPeticion(Peticion.REMOVER_EMPRESA, rnc);
   }

   @Override
   public Empresa searchEmpresaByRNC(String rnc) {
      return (Empresa) enviarPeticion(Peticion.BUSCAR_EMPRESA_POR_RNC, rnc);
   }

   @Override
   @SuppressWarnings("unchecked")
   public ArrayList<Empresa> showListEmpresa() {
      return (ArrayList<Empresa>) enviarPeticion(Peticion.LISTAR_EMPRESAS);
   }

   @Override
   @SuppressWarnings("unchecked")
   public ArrayList<Empresa> showListEmpresaByType(String type) {
      return (ArrayList<Empresa>) enviarPeticion(
         Peticion.LISTAR_EMPRESAS_POR_TIPO,
         type
      );
   }

   @Override
   public void createRequestPersonal(Solicitud req) {
      enviarPeticion(Peticion.CREAR_SOLICITUD, req);
   }

   @Override
   public boolean removeRequest(Solicitud req) {
      return (Boolean) enviarPeticion(Peticion.REMOVER_SOLICITUD, req);
   }

   @Override
   @SuppressWarnings("unchecked")
   public ArrayList<Solicitud> showListSolicitudes() {
      return (ArrayList<Solicitud>) enviarPeticion(Peticion.LISTAR_SOLICITUDES);
   }

   @Override
   @SuppressWarnings("unchecked")
   public ArrayList<Solicitud> showListSolicitudesByPersonalId(
      Persona persona
   ) {
      return (ArrayList<Solicitud>) enviarPeticion(
         Peticion.LISTAR_SOLICITUDES_POR_PERSONA,
         persona
      );
   }

   @Override
   public boolean addBusinessJobOffer(String businessRNC, Oferta offer) {
      return (Boolean) enviarPeticion(
         Peticion.AGREGAR_OFERTA,
         businessRNC,
         offer
      );
   }

   @Override
   @SuppressWarnings("unchecked")
   public ArrayList<Oferta> showListAllOffers() {
      return (ArrayList<Oferta>) enviarPeticion(Peticion.LISTAR_TODAS_OFERTAS);
   }

   @Override
   @SuppressWarnings("unchecked")
   public ArrayList<Oferta> showActiveOffers() {
      return (ArrayList<Oferta>) enviarPeticion(
         Peticion.LISTAR_OFERTAS_ACTIVAS
      );
   }

   @Override
   public boolean contratar(Solicitud solicitud, Oferta oferta) {
      return (Boolean) enviarPeticion(Peticion.CONTRATAR, solicitud, oferta);
   }

   @Override
   public boolean renunciar(Persona persona) {
      return (Boolean) enviarPeticion(Peticion.RENUNCIAR, persona);
   }

   @Override
   public boolean toggleOfertaActiva(String rncEmpresa, String codigoOferta) {
      return (Boolean) enviarPeticion(
         Peticion.TOGGLE_OFERTA_ACTIVA,
         rncEmpresa,
         codigoOferta
      );
   }

   @Override
   public double calcularCoincidencia(Oferta oferta, Solicitud solicitud) {
      return (Double) enviarPeticion(
         Peticion.CALCULAR_COINCIDENCIA,
         oferta,
         solicitud
      );
   }

   @Override
   @SuppressWarnings("unchecked")
   public ArrayList<Solicitud> buscarMejoresCandidatos(Oferta oferta) {
      return (ArrayList<Solicitud>) enviarPeticion(
         Peticion.BUSCAR_MEJORES_CANDIDATOS,
         oferta
      );
   }
}
