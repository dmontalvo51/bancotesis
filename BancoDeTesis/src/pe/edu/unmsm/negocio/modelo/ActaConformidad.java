package pe.edu.unmsm.negocio.modelo;

import java.util.Date;

public class ActaConformidad {
	
	/*Datos de la Tabla*/
	private String codigo;
	private String ruta;
	private String observaciones;
	private String fecha;
	private String hora;
	
	
	private boolean actaCreada;
	private boolean actaAprobada;
	private int version;
	
	/*Datos cruzados*/
	private String codigoAsesor;
	private String codigoBorrador;
	private String codigoTesis;
	private String rutaBorrador;
	
	public ActaConformidad(){
		
	}
	
	public String getRutaBorrador() {
		return rutaBorrador;
	}
	public void setRutaBorrador(String rutaBorrador) {
		this.rutaBorrador = rutaBorrador;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public boolean isActaCreada() {
		return actaCreada;
	}
	public void setActaCreada(boolean actaCreada) {
		this.actaCreada = actaCreada;
	}
	public boolean isActaAprobada() {
		return actaAprobada;
	}
	public void setActaAprobada(boolean actaAprobada) {
		this.actaAprobada = actaAprobada;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getCodigoAsesor() {
		return codigoAsesor;
	}
	public void setCodigoAsesor(String codigoAsesor) {
		this.codigoAsesor = codigoAsesor;
	}
	public String getCodigoBorrador() {
		return codigoBorrador;
	}
	public void setCodigoBorrador(String codigoBorrador) {
		this.codigoBorrador = codigoBorrador;
	}
	public String getCodigoTesis() {
		return codigoTesis;
	}
	public void setCodigoTesis(String codigoTesis) {
		this.codigoTesis = codigoTesis;
	}
	
	
	
   
	
	
}