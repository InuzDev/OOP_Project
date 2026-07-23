package Logic;

public abstract class Persona {

   protected static int contId = 1;
   protected int numIdentificador;
   protected Usuario usuarioEmpleado;
   protected String nombre;
   protected String cedula;
   protected String sexo;
   protected String numeroTelefono;
   protected String correo;
   protected String provincia;
   protected boolean isEmpleada;

   public Persona(
      String nombre,
      String cedula,
      String sexo,
      String numeroTelefono,
      String correo,
      String provincia
   ) {
      this.numIdentificador = contId++;
      this.nombre = nombre;
      this.cedula = cedula;
      this.sexo = sexo;
      this.numeroTelefono = numeroTelefono;
      this.correo = correo;
      this.provincia = provincia;
      this.isEmpleada = false;
   }

   public static int getContId() {
      return contId;
   }

   public static void setContId(int contId) {
      Persona.contId = contId;
   }

   public int getNumIdentificador() {
      return numIdentificador;
   }

   public void setNumIdentificador(int numIdentificador) {
      this.numIdentificador = numIdentificador;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getCedula() {
      return cedula;
   }

   public void setCedula(String cedula) {
      this.cedula = cedula;
   }

   public String getSexo() {
      return sexo;
   }

   public void setSexo(String sexo) {
      this.sexo = sexo;
   }

   public String getNumeroTelefono() {
      return numeroTelefono;
   }

   public void setNumeroTelefono(String numeroTelefono) {
      this.numeroTelefono = numeroTelefono;
   }

   public String getCorreo() {
      return correo;
   }

   public void setCorreo(String correo) {
      this.correo = correo;
   }

   public String getProvincia() {
      return provincia;
   }

   public void setProvincia(String provincia) {
      this.provincia = provincia;
   }

   public boolean isEmpleada() {
      return isEmpleada;
   }

   public void setEmpleada(boolean isEmpleada) {
      this.isEmpleada = isEmpleada;
   }
}
