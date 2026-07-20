package Logic;

public class Solicitud {

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
      this.solicitante = solicitante;
      this.puestoDeseado = puestoDeseado;
      this.salarioMinDeseado = salarioMinDeseado;
      this.salarioMaxDeseado = salarioMaxDeseado;
      this.dispMudanza = dispMudanza;
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
}
