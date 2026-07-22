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

   public void registrarPersonal(Persona persona) {
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

   public Persona searchPersonalByRNC(String rnc) {
      for (Persona pers : listPersonal) {}
   }
}
