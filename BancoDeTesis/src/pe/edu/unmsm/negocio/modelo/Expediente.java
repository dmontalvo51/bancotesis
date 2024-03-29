package pe.edu.unmsm.negocio.modelo;

import java.util.Date;

public class Expediente {
	
	private String codigo;
	private String estado;
	private String usuario;
	private String nombres;
	private String apellidos;
	private Date fechaInicio;
	
	

	public Expediente(String codigo, String estado, String usuario,
			String nombres, String apellidos, Date fechaInicio) {
		super();
		
		this.codigo = codigo;
		this.estado = estado;
		this.usuario = usuario;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaInicio = fechaInicio;
	}
	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Expediente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	
	
}
	
