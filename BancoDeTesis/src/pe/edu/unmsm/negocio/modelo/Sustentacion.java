package pe.edu.unmsm.negocio.modelo;

import java.io.Serializable;

public class Sustentacion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String codigoTesis;
	private String observaciones;
	private int calificacion;
	private String codigoActaSustentacion;
	private String rutaActaSustentacion;
	
	private String codigoJurado1;
	private String codigoJurado2;
	private boolean asignado;
	
	public String getCodigoTesis() {
		return codigoTesis;
	}
	public void setCodigoTesis(String codigoTesis) {
		this.codigoTesis = codigoTesis;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public String getCodigoActaSustentacion() {
		return codigoActaSustentacion;
	}
	public void setCodigoActaSustentacion(String codigoActaSustentacion) {
		this.codigoActaSustentacion = codigoActaSustentacion;
	}
	public String getRutaActaSustentacion() {
		return rutaActaSustentacion;
	}
	public void setRutaActaSustentacion(String rutaActaSustentacion) {
		this.rutaActaSustentacion = rutaActaSustentacion;
	}
	public String getCodigoJurado1() {
		return codigoJurado1;
	}
	public void setCodigoJurado1(String codigoJurado1) {
		this.codigoJurado1 = codigoJurado1;
	}
	public String getCodigoJurado2() {
		return codigoJurado2;
	}
	public void setCodigoJurado2(String codigoJurado2) {
		this.codigoJurado2 = codigoJurado2;
	}
	public boolean isAsignado() {
		return asignado;
	}
	public void setAsignado(boolean asignado) {
		this.asignado = asignado;
	}
	
	
	

}
