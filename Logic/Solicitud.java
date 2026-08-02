package Logic;

import java.io.Serializable;

public class Solicitud implements Serializable {

   private static final long serialVersionUID = 1L;

   protected static int contId = 1;
   private int idSolicitud;

   private Persona solicitante;
   private String puestoDeseado;
   private float salarioMinDeseado;
   private float salarioMaxDeseado;
   private boolean dispMudanza;

   public Solicitud(
      Persona solicitante,
      String puestoDeseado,
      float salarioMinDeseado,
      float salarioMaxDeseado,
      boolean dispMudanza
   ) {
      this.idSolicitud = contId++;
      this.solicitante = solicitante;
      this.puestoDeseado = puestoDeseado;
      this.salarioMinDeseado = salarioMinDeseado;
      this.salarioMaxDeseado = salarioMaxDeseado;
      this.dispMudanza = dispMudanza;
   }

   public int getIdSolicitud() {
      return idSolicitud;
   }

   public Persona getSolicitante() {
      return solicitante;
   }

   public void setSolicitante(Persona solicitante) {
      this.solicitante = solicitante;
   }

   public String getPuestoDeseado() {
      return puestoDeseado;
   }

   public void setPuestoDeseado(String puestoDeseado) {
      this.puestoDeseado = puestoDeseado;
   }

   public float getSalarioMinDeseado() {
      return salarioMinDeseado;
   }

   public void setSalarioMinDeseado(float salarioMinDeseado) {
      this.salarioMinDeseado = salarioMinDeseado;
   }

   public float getSalarioMaxDeseado() {
      return salarioMaxDeseado;
   }

   public void setSalarioMaxDeseado(float salarioMaxDeseado) {
      this.salarioMaxDeseado = salarioMaxDeseado;
   }

   public boolean isDispMudanza() {
      return dispMudanza;
   }

   public void setDispMudanza(boolean dispMudanza) {
      this.dispMudanza = dispMudanza;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      }
      if (!(obj instanceof Solicitud)) {
         return false;
      }

      return this.idSolicitud == ((Solicitud) obj).idSolicitud;
   }

   @Override
   public int hashCode() {
      return Integer.hashCode(idSolicitud);
   }
}
