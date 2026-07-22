package Logic;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String correo;
	private String username;
	private String password;
	private String rol;
	private boolean activo;

	public Usuario(int id, String correo, String password, String rol) {

		this.id = id;
		this.correo = correo;
		this.username = generarUsername(correo);
		this.password = password;
		this.rol = rol;
		this.activo = true;
	}

	private String generarUsername(String correo) {

		int posicion = correo.indexOf("@");

		if (posicion != -1) {
			return correo.substring(0, posicion);
		}

		return correo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
		this.username = generarUsername(correo);
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}