package Logic;

import java.util.ArrayList;

public class Empresa {

	private String rnc;
	private String nombre;
	private String direccion;
	private String telefono;
	private String sitioWeb;
	private String representante;
	private String tipo;

	private String username;
	private String password;

	private ArrayList<Oferta> misOfertas;

	public Empresa(String rnc, String nombre, String direccion,
			String telefono, String sitioWeb,
			String representante, String tipo,
			String username, String password) {

		this.rnc = rnc;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.sitioWeb = sitioWeb;
		this.representante = representante;
		this.tipo = tipo;
		this.username = username;
		this.password = password;

		misOfertas = new ArrayList<>();
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	public void buscarCandidatos() {

	}


	
}