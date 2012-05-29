package pe.edu.unmsm.modelo;

import java.util.Date;

public class ActaSustentacion {
	
	/*Datos de la Tabla*/
	private int id;
	private String codigo;
	private int calificaci�n;
	private Date fechaRegistro;
	
	
	/*Datos cruzados*/
	private String codigoTramite;
	private String codigoAlumno;
	
	
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
	public int getCalificaci�n() {
		return calificaci�n;
	}
	public void setCalificaci�n(int calificaci�n) {
		this.calificaci�n = calificaci�n;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getCodigoTramite() {
		return codigoTramite;
	}
	public void setCodigoTramite(String codigoTramite) {
		this.codigoTramite = codigoTramite;
	}
	public String getCodigoAlumno() {
		return codigoAlumno;
	}
	public void setCodigoAlumno(String codigoAlumno) {
		this.codigoAlumno = codigoAlumno;
	}
	
	
}
