package pe.edu.unmsm.modelo;

import java.util.Date;

public class Tesis {
	
	private String codigoExp;
	private String estado;
	private String usuario;
	private String bachiller;
	private String nombres;
	private String apellidos;
	private Date fechaRegistro;
	private String resumen;
	private String linea;
	
	public Tesis() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public String getCodigoExp() {
		return codigoExp;
	}


	public void setCodigoExp(String codigoExp) {
		this.codigoExp = codigoExp;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getBachiller() {
		return bachiller;
	}

	public void setBachiller(String bachiller) {
		this.bachiller = bachiller;
	}
	
	
	
}
	
