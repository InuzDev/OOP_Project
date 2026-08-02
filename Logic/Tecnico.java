package Logic;

public class Tecnico extends Persona {

   private String tecnicoProfesado;
  

   public Tecnico(
      String nombre,
      String cedula,
      String sexo,
      String numeroTelefono,
      String correo,
      String provincia,
      String tecnicoProfesado,
      int aniosExperiencia
   ) {
      super(nombre, cedula, sexo, numeroTelefono, correo, provincia, aniosExperiencia);
      this.tecnicoProfesado = tecnicoProfesado;
      
   }

   public String getTecnicoProfesado() {
      return tecnicoProfesado;
   }

   public void setTecnicoProfesado(String tecnicoProfesado) {
      this.tecnicoProfesado = tecnicoProfesado;
   }

}
