package Logic;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {

   private static final long serialVersionUID = 1L;

   private String rnc;
   private String nombre;
   private String direccion;
   private String telefono;
   private String provincia;
   private String correo;
   private String sitioWeb;
   private String tipo;

   private Representante representante;
   private Usuario usuario;

   private ArrayList<Oferta> misOfertas;

   public Empresa(
      String rnc,
      String nombre,
      String direccion,
      String provincia,
      String telefono,
      String correo,
      String sitioWeb,
      String tipo,
      Representante representante,
      Usuario usuario
   ) {
      this.rnc = rnc;
      this.nombre = nombre;
      this.direccion = direccion;
      this.provincia = provincia;
      this.telefono = telefono;
      this.correo = correo;
      this.sitioWeb = sitioWeb;
      this.tipo = tipo;
      this.representante = representante;
      this.usuario = usuario;
   }

   public String getRnc() {
      return rnc;
   }

   public void setRnc(String rnc) {
      this.rnc = rnc;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getDireccion() {
      return direccion;
   }

   public void setDireccion(String direccion) {
      this.direccion = direccion;
   }

   public String getProvincia() {
      return provincia;
   }

   public void setProvincia(String provincia) {
      this.provincia = provincia;
   }

   public String getTelefono() {
      return telefono;
   }

   public void setTelefono(String telefono) {
      this.telefono = telefono;
   }

   public String getCorreo() {
      return correo;
   }

   public void setCorreo(String correo) {
      this.correo = correo;
   }

   public String getSitioWeb() {
      return sitioWeb;
   }

   public void setSitioWeb(String sitioWeb) {
      this.sitioWeb = sitioWeb;
   }

   public String getTipo() {
      return tipo;
   }

   public void setTipo(String tipo) {
      this.tipo = tipo;
   }

   public Representante getRepresentante() {
      return representante;
   }

   public void setRepresentante(Representante representante) {
      this.representante = representante;
   }

   public Usuario getUsuario() {
      return usuario;
   }

   public void setUsuario(Usuario usuario) {
      this.usuario = usuario;
   }

   public ArrayList<Oferta> getMisOfertas() {
      return misOfertas;
   }

   public void setMisOfertas(ArrayList<Oferta> misOfertas) {
      this.misOfertas = misOfertas;
   }

   public void agregarOferta(Oferta nuevaOferta) {
      misOfertas.add(nuevaOferta);
   }

   public void eliminarOferta(Oferta oferta) {
      misOfertas.remove(oferta);
   }

   public Oferta buscarOferta(String codigo) {
      Oferta aux = null;

      for (Oferta oferta : misOfertas) {
         if (oferta.getCodigo().equalsIgnoreCase(codigo)) {
            aux = oferta;
            break;
         }
      }

      return aux;
   }

   public int cantidadOfertas() {
      return misOfertas.size();
   }

   public ArrayList<Oferta> getOfertasActivas() {
      ArrayList<Oferta> activas = new ArrayList<>();

      for (Oferta oferta : misOfertas) {
         if (oferta.isActiva()) {
            activas.add(oferta);
         }
      }

      return activas;
   }

   // Este método será utilizado cuando implementen el algoritmo de búsqueda de candidatos.
   // public void buscarCandidatos() { }
}
