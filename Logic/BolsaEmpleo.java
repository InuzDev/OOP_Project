// Falta por hacer:
// - Conectar la logica con el UI.

package Logic;

import java.io.*;
import java.util.ArrayList;

public class BolsaEmpleo {

   private String filePersonal = "personal.dat";
   private String fileEmpresas = "centros.dat";
   private String fileSolicitudes = "solicitudes.dat";

   private ArrayList<Persona> listPersonal;
   private ArrayList<Empresa> listEmpresas;
   private ArrayList<Solicitud> listSolicitudes;

   public BolsaEmpleo() {
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

   // Funciones orientadas al personal

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

   // Funciones orientada a las empresas y sus representates

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

   // Funciones para las solicitudes del personal

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

   // Funciones para las ofertas

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
}
