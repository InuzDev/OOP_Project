package Logic;

import java.util.ArrayList;

public interface IBolsaEmpleo {
   Object login(String username, String password);

   void registerPersonal(Persona persona);

   boolean removePersonal(int identificador);

   Persona searchPersonalById(int identificador);

   Persona searchPersonalByPersonalId(String cedula);

   ArrayList<Persona> showListPersonal();

   ArrayList<Tecnico> showListTecnicians();

   ArrayList<Universitario> listCollegeStudent();

   ArrayList<Obrero> listLaborer();

   void registerEmpresa(Empresa business);

   boolean removeEmpresa(String rnc);

   Empresa searchEmpresaByRNC(String rnc);

   ArrayList<Empresa> showListEmpresa();

   ArrayList<Empresa> showListEmpresaByType(String type);

   void createRequestPersonal(Solicitud req);

   boolean removeRequest(Solicitud req);

   ArrayList<Solicitud> showListSolicitudes();

   ArrayList<Solicitud> showListSolicitudesByPersonalId(Persona persona);

   boolean addBusinessJobOffer(String businessRNC, Oferta offer);

   ArrayList<Oferta> showListAllOffers();

   ArrayList<Oferta> showActiveOffers();

   boolean contratar(Solicitud solicitud, Oferta oferta);

   boolean renunciar(Persona persona);

   boolean toggleOfertaActiva(String rncEmpresa, String codigoOferta);

   double calcularCoincidencia(Oferta oferta, Solicitud solicitud);

   ArrayList<Solicitud> buscarMejoresCandidatos(Oferta oferta);
}
