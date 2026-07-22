package Logic;

import java.io.Serializable;

public class Oferta implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigo;
	private String puesto;
	private int cantidadPuestos;
	private String sexo;
	private boolean requiereLicencia;
	private boolean dispuestoMudarse;
	private String tipoTrabajo;
	private double salarioMinimo;
	private double salarioMaximo;
	private String provincia;
	private int experienciaRequerida;
	private String descripcion;
	private double porcentajeCoincidencia;
	private boolean activa;

	public Oferta(String codigo, String puesto,
			int cantidadPuestos, String sexo,
			boolean requiereLicencia,
			boolean dispuestoMudarse,
			String tipoTrabajo,
			double salarioMinimo,
			double salarioMaximo,
			String provincia,
			int experienciaRequerida,
			String descripcion) {

		this.codigo = codigo;
		this.puesto = puesto;
		this.cantidadPuestos = cantidadPuestos;
		this.sexo = sexo;
		this.requiereLicencia = requiereLicencia;
		this.dispuestoMudarse = dispuestoMudarse;
		this.tipoTrabajo = tipoTrabajo;
		this.salarioMinimo = salarioMinimo;
		this.salarioMaximo = salarioMaximo;
		this.provincia = provincia;
		this.experienciaRequerida = experienciaRequerida;
		this.descripcion = descripcion;

		this.porcentajeCoincidencia = 0;
		this.activa = true;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public int getCantidadPuestos() {
		return cantidadPuestos;
	}

	public void setCantidadPuestos(int cantidadPuestos) {
		this.cantidadPuestos = cantidadPuestos;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isRequiereLicencia() {
		return requiereLicencia;
	}

	public void setRequiereLicencia(boolean requiereLicencia) {
		this.requiereLicencia = requiereLicencia;
	}

	public boolean isDispuestoMudarse() {
		return dispuestoMudarse;
	}

	public void setDispuestoMudarse(boolean dispuestoMudarse) {
		this.dispuestoMudarse = dispuestoMudarse;
	}

	public String getTipoTrabajo() {
		return tipoTrabajo;
	}

	public void setTipoTrabajo(String tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}

	public double getSalarioMinimo() {
		return salarioMinimo;
	}

	public void setSalarioMinimo(double salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}

	public double getSalarioMaximo() {
		return salarioMaximo;
	}

	public void setSalarioMaximo(double salarioMaximo) {
		this.salarioMaximo = salarioMaximo;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getExperienciaRequerida() {
		return experienciaRequerida;
	}

	public void setExperienciaRequerida(int experienciaRequerida) {
		this.experienciaRequerida = experienciaRequerida;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPorcentajeCoincidencia() {
		return porcentajeCoincidencia;
	}

	public void setPorcentajeCoincidencia(double porcentajeCoincidencia) {
		this.porcentajeCoincidencia = porcentajeCoincidencia;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public void completarOferta() {

		this.cantidadPuestos = 0;
		this.activa = false;

	}

	public boolean estaCompleta() {
		return cantidadPuestos == 0;
	}

}