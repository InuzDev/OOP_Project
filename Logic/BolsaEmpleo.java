package Logic;

import java.io.*;
import java.util.ArrayList;

public class BolsaEmpleo implements IBolsaEmpleo {

   private String filePersonal = "Logs/personal.dat";
   private String fileEmpresas = "Logs/centros.dat";
   private String fileSolicitudes = "Logs/solicitudes.dat";

   private ArrayList<Persona> listPersonal;
   private ArrayList<Empresa> listEmpresas;
   private ArrayList<Solicitud> listSolicitudes;

   public BolsaEmpleo() {
      new File("Logs").mkdirs();

      listPersonal = loadList(filePersonal);
      listEmpresas = loadList(fileEmpresas);
      listSolicitudes = loadList(fileSolicitudes);
   }

   @SuppressWarnings("unchecked")
   private <T> ArrayList<T> loadList(String ArchivoDat) {
      File archivo = new File(ArchivoDat);
      if (!archivo.exists()) {
         return new ArrayList<>();
      }

      try (
         ObjectInputStream in = new ObjectInputStream(
            new FileInputStream(archivo)
         )
      ) {
         return (ArrayList<T>) in.readObject();
      } catch (IOException | ClassNotFoundException err) {
         System.out.println(
            "No se pudo cargar " + ArchivoDat + ": " + err.getMessage()
         );
         return new ArrayList<>();
      }
   }

   private <T> void saveList(ArrayList<T> list, String fileName) {
      try (
         ObjectOutputStream out = new ObjectOutputStream(
            new FileOutputStream(fileName)
         )
      ) {
         out.writeObject(list);
      } catch (IOException err) {
         System.out.println(
            "No se pudo guardar " + fileName + ": " + err.getMessage()
         );
      }
   }

   public Object login(String username, String password) {
      for (Persona pers : listPersonal) {
         Usuario user = pers.getUsuarioEmpleado();
         if (
            user != null &&
            user.isActivo() &&
            user.getUsername().equalsIgnoreCase(username) &&
            user.getPassword().equals(password)
         ) {
            return pers;
         }
      }

      for (Empresa business : listEmpresas) {
         Usuario user = business.getUsuario();
         if (
            user != null &&
            user.isActivo() &&
            user.getUsername().equalsIgnoreCase(username) &&
            user.getPassword().equals(password)
         ) {
            return business;
         }
      }

      return null;
   }

   public void registerPersonal(Persona persona) {
      listPersonal.add(persona);
      saveList(listPersonal, filePersonal);
   }

   public boolean removePersonal(int Identificador) {
      Persona found = searchPersonalById(Identificador);
      if (found == null) {
         return false;
      }
      listPersonal.remove(found);
      saveList(listPersonal, filePersonal);

      return true;
   }

   public Persona searchPersonalById(int Identificador) {
      for (Persona pers : listPersonal) {
         if (pers.getNumIdentificador() == Identificador) {
            return pers;
         }
      }
      return null;
   }

   public Persona searchPersonalByPersonalId(String PersonalId) {
      for (Persona pers : listPersonal) {
         if (pers.getCedula().equalsIgnoreCase(PersonalId)) {
            return pers;
         }
      }
      return null;
   }

   public ArrayList<Persona> showListPersonal() {
      return listPersonal;
   }

   public ArrayList<Tecnico> showListTecnicians() {
      ArrayList<Tecnico> resultList = new ArrayList<>();

      for (Persona pers : listPersonal) {
         if (pers instanceof Tecnico) {
            resultList.add((Tecnico) pers);
         }
      }
      return resultList;
   }

   public ArrayList<Universitario> listCollegeStudent() {
      ArrayList<Universitario> resultList = new ArrayList<>();

      for (Persona pers : listPersonal) {
         if (pers instanceof Universitario) {
            resultList.add((Universitario) pers);
         }
      }
      return resultList;
   }

   public ArrayList<Obrero> listLaborer() {
      ArrayList<Obrero> resultList = new ArrayList<>();

      for (Persona pers : listPersonal) {
         if (pers instanceof Obrero) {
            resultList.add((Obrero) pers);
         }
      }
      return resultList;
   }

   public void registerEmpresa(Empresa business) {
      listEmpresas.add(business);
      saveList(listEmpresas, fileEmpresas);
   }

   public boolean removeEmpresa(String rnc) {
      Empresa found = searchEmpresaByRNC(rnc);

      if (found == null) {
         return false;
      }

      listEmpresas.remove(found);
      saveList(listEmpresas, fileEmpresas);

      return true;
   }

   public Empresa searchEmpresaByRNC(String rnc) {
      for (Empresa business : listEmpresas) {
         if (business.getRnc().equalsIgnoreCase(rnc)) {
            return business;
         }
      }

      return null;
   }

   public ArrayList<Empresa> showListEmpresa() {
      return listEmpresas;
   }

   public ArrayList<Empresa> showListEmpresaByType(String type) {
      ArrayList<Empresa> resultList = new ArrayList<>();

      for (Empresa business : listEmpresas) {
         if (business.getTipo().equalsIgnoreCase(type)) {
            resultList.add(business);
         }
      }

      return resultList;
   }

   public void createRequestPersonal(Solicitud req) {
      listSolicitudes.add(req);
      saveList(listSolicitudes, fileSolicitudes);
   }

   public boolean removeRequest(Solicitud req) {
      boolean removed = listSolicitudes.remove(req);

      if (removed) {
         saveList(listSolicitudes, fileSolicitudes);
      }

      return removed;
   }

   public ArrayList<Solicitud> showListSolicitudes() {
      return listSolicitudes;
   }

   public ArrayList<Solicitud> showListSolicitudesByPersonalId(
      Persona persona
   ) {
      ArrayList<Solicitud> resultList = new ArrayList<>();

      for (Solicitud req : listSolicitudes) {
         if (req.getSolicitante().equals(persona)) {
            resultList.add(req);
         }
      }

      return resultList;
   }

   public boolean addBusinessJobOffer(String businessRNC, Oferta offer) {
      Empresa business = searchEmpresaByRNC(businessRNC);

      if (business == null) {
         return false;
      }

      business.agregarOferta(offer);
      saveList(listEmpresas, fileEmpresas);

      return true;
   }

   public ArrayList<Oferta> showListAllOffers() {
      ArrayList<Oferta> resultList = new ArrayList<>();

      for (Empresa business : listEmpresas) {
         resultList.addAll(business.getMisOfertas());
      }

      return resultList;
   }

   public ArrayList<Oferta> showActiveOffers() {
      ArrayList<Oferta> resultList = new ArrayList<>();

      for (Oferta offer : showListAllOffers()) {
         if (offer.isActiva()) {
            resultList.add(offer);
         }
      }

      return resultList;
   }

   public boolean contratar(Solicitud solicitud, Oferta oferta) {
      if (solicitud == null || oferta == null) {
         return false;
      }

      Oferta ofertaReal = buscarOfertaPorCodigo(oferta.getCodigo());
      if (ofertaReal == null) {
         return false;
      }

      int indiceSolicitud = listSolicitudes.indexOf(solicitud);
      if (indiceSolicitud == -1) {
         return false;
      }
      Solicitud solicitudReal = listSolicitudes.get(indiceSolicitud);

      if (!ofertaReal.isActiva() || ofertaReal.getCantidadPuestos() <= 0) {
         return false;
      }

      Persona personaReal = searchPersonalById(
         solicitudReal.getSolicitante().getNumIdentificador()
      );
      if (personaReal == null) {
         return false;
      }

      personaReal.setEmpleada(true);
      saveList(listPersonal, filePersonal);

      ofertaReal.setCantidadPuestos(ofertaReal.getCantidadPuestos() - 1);
      if (ofertaReal.getCantidadPuestos() <= 0) {
         ofertaReal.completarOferta();
      }
      saveList(listEmpresas, fileEmpresas);

      listSolicitudes.remove(indiceSolicitud);
      saveList(listSolicitudes, fileSolicitudes);

      return true;
   }

   private Oferta buscarOfertaPorCodigo(String codigo) {
      for (Empresa business : listEmpresas) {
         Oferta encontrada = business.buscarOferta(codigo);
         if (encontrada != null) {
            return encontrada;
         }
      }
      return null;
   }

   public boolean renunciar(Persona persona) {
      if (persona == null) {
         return false;
      }

      Persona personaReal = searchPersonalById(persona.getNumIdentificador());
      if (personaReal == null || !personaReal.isEmpleada()) {
         return false;
      }

      personaReal.setEmpleada(false);
      saveList(listPersonal, filePersonal);

      return true;
   }

   public boolean toggleOfertaActiva(String rncEmpresa, String codigoOferta) {
      Empresa business = searchEmpresaByRNC(rncEmpresa);
      if (business == null) {
         return false;
      }

      Oferta oferta = business.buscarOferta(codigoOferta);
      if (oferta == null) {
         return false;
      }

      oferta.setActiva(!oferta.isActiva());
      saveList(listEmpresas, fileEmpresas);

      return true;
   }

   public double calcularCoincidencia(Oferta oferta, Solicitud solicitud) {
      double puntos = 0;

      Persona persona = solicitud.getSolicitante();

      if (solicitud.getPuestoDeseado().equalsIgnoreCase(oferta.getPuesto())) {
         puntos += 30;
      }

      if (persona.getProvincia().equalsIgnoreCase(oferta.getProvincia())) {
         puntos += 15;
      }

      if (
         oferta.getSexo().equalsIgnoreCase("Ambos") ||
         persona.getSexo().equalsIgnoreCase(oferta.getSexo())
      ) {
         puntos += 10;
      }

      if (solicitud.isDispMudanza() == oferta.isDispuestoMudarse()) {
         puntos += 10;
      }

      if (
         solicitud.getSalarioMinDeseado() <= oferta.getSalarioMaximo() &&
         solicitud.getSalarioMaxDeseado() >= oferta.getSalarioMinimo()
      ) {
         puntos += 15;
      }

      if (
         persona instanceof Universitario &&
         oferta.getTipoTrabajo().equalsIgnoreCase("Universitario")
      ) {
         puntos += 10;

         Universitario universitario = (Universitario) persona;
         if (
            carreraRelacionadaConPuesto(
               universitario.getCarrera(),
               oferta.getPuesto()
            )
         ) {
            puntos += 10;
         }
      }

      if (
         persona instanceof Tecnico &&
         oferta.getTipoTrabajo().equalsIgnoreCase("Tecnico")
      ) {
         puntos += 10;
      }

      if (
         persona instanceof Obrero &&
         oferta.getTipoTrabajo().equalsIgnoreCase("Obrero")
      ) {
         puntos += 10;
      }

      if (persona.getAniosExperiencia() >= oferta.getExperienciaRequerida()) {
         puntos += 20;
      }

      return puntos;
   }

   private boolean carreraRelacionadaConPuesto(String carrera, String puesto) {
      if (carrera == null || puesto == null) {
         return false;
      }

      String carreraNormalizada = carrera.trim().toLowerCase();
      String puestoNormalizado = puesto.trim().toLowerCase();

      if (carreraNormalizada.isEmpty() || puestoNormalizado.isEmpty()) {
         return false;
      }

      if (
         puestoNormalizado.contains(carreraNormalizada) ||
         carreraNormalizada.contains(puestoNormalizado)
      ) {
         return true;
      }

      for (String palabra : carreraNormalizada.split("\\s+")) {
         if (palabra.length() > 3 && puestoNormalizado.contains(palabra)) {
            return true;
         }
      }

      return false;
   }

   public ArrayList<Solicitud> buscarMejoresCandidatos(Oferta oferta) {
      ArrayList<Solicitud> candidatos = new ArrayList<>();

      for (Solicitud solicitud : listSolicitudes) {
         if (!solicitud.getSolicitante().isEmpleada()) {
            candidatos.add(solicitud);
         }
      }

      candidatos.sort((s1, s2) ->
         Double.compare(
            calcularCoincidencia(oferta, s2),

            calcularCoincidencia(oferta, s1)
         )
      );

      return candidatos;
   }
}
