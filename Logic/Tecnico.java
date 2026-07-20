package Logic;

public class Tecnico extends Persona {
	
	private String tecnicoProfesado;
	private int aniosExperiencia; 

	public Tecnico(String nombre, String cedula, String sexo, String numeroTelefono, String correo, String provincia, String tecnicoProfesado,int aniosExperiencia) {
		super(nombre, cedula, sexo, numeroTelefono, correo, provincia);
		this.tecnicoProfesado = tecnicoProfesado;
		this.aniosExperiencia = aniosExperiencia;
	}

	public String getTecnicoProfesado() {
		return tecnicoProfesado;
	}

	public void setTecnicoProfesado(String tecnicoProfesado) {
		this.tecnicoProfesado = tecnicoProfesado;
	}

	public int getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}
	
}
