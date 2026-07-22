package Logic;

import java.io.Serializable;

public class Representante implements Serializable {

	private static final long serialVersionUID = 1L;

	private static int contId = 1;

	private int idRepresentante;
	private String nombre;
	private String cedula;
	private String telefono;
	private String correo;
	private String direccion;
	private String cargo;

	public Representante(String nombre, String cedula,
			String telefono, String correo,
			String direccion, String cargo) {

		this.idRepresentante = contId++;
		this.nombre = nombre;
		this.cedula = cedula;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
		this.cargo = cargo;
	}

	public static int getContId() {
		return contId;
	}

	public static void setContId(int contId) {
		Representante.contId = contId;
	}

	public int getIdRepresentante() {
		return idRepresentante;
	}

	public void setIdRepresentante(int idRepresentante) {
		this.idRepresentante = idRepresentante;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
