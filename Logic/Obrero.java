package Logic;

public class Obrero extends Persona {

   private String habilidades;

   public Obrero(
      String nombre,
      String cedula,
      String sexo,
      String numeroTelefono,
      String correo,
      String provincia,
      String habilidades
   ) {
      super(nombre, cedula, sexo, numeroTelefono, correo, provincia);
      this.habilidades = habilidades;
   }

   public String getHabilidades() {
      return habilidades;
   }

   public void setHabilidades(String habilidades) {
      this.habilidades = habilidades;
   }
}
