package Logic;

public class Universitario extends Persona {

   private String carrera;
   private String universidad;

   public Universitario(
      String nombre,
      String cedula,
      String sexo,
      String numeroTelefono,
      String correo,
      String provincia,
      int aniosExperiencia,
      String carrera,
      String universidad
   ) {
      super(
         nombre,
         cedula,
         sexo,
         numeroTelefono,
         correo,
         provincia,
         aniosExperiencia
      );
      this.carrera = carrera;
      this.universidad = universidad;
   }

   public String getCarrera() {
      return carrera;
   }

   public void setCarrera(String carrera) {
      this.carrera = carrera;
   }

   public String getUniversidad() {
      return universidad;
   }

   public void setUniversidad(String universidad) {
      this.universidad = universidad;
   }
}
