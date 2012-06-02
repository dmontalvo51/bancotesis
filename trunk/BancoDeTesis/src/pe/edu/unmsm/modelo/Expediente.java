package pe.edu.unmsm.modelo;

import java.util.Date;

public class Expediente {
	
	private int id;
	private String codigo;
	private String estado;
	private String codigoBachiller;
	private String nombres;
	private String apellidos;
	private Date fechaInicio;
	
	
	
	public Expediente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Expediente(int id, String codigo, String estado,
			String codigoBachiller, String nombres, String apellidos,
			Date fechaInicio) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.estado = estado;
		this.codigoBachiller = codigoBachiller;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaInicio = fechaInicio;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCodigoBachiller() {
		return codigoBachiller;
	}
	public void setCodigoBachiller(String codigoBachiller) {
		this.codigoBachiller = codigoBachiller;
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
