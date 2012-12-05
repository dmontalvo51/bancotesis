package pe.edu.unmsm.negocio.modelo;

import java.util.Date;

public class ActaObservacion {
	
	/*Datos de la Tabla*/
	private String codigo;
	private int estado;
	private String ruta;
	private String fecha;
	private String hora;
	
	private boolean actaCreada;
	private boolean actaAprobada;
	private int version;
	
	/*Datos cruzados*/
	private String codigoDocente;
	private String codigoBorrador;
	
	
	public ActaObservacion(String codigo, int estado, String ruta,
			String fecha, String hora, boolean actaCreada,
			boolean actaAprobada, String codigoDocente, String codigoBorrador) {
		super();
		this.codigo = codigo;
		this.estado = estado;
		this.ruta = ruta;
		this.fecha = fecha;
		this.hora = hora;
		this.actaCreada = actaCreada;
		this.actaAprobada = actaAprobada;
		this.codigoDocente = codigoDocente;
		this.codigoBorrador = codigoBorrador;
	}
	
	public ActaObservacion(){
		
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
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
	public String getCodigoDocente() {
		return codigoDocente;
	}
	public void setCodigoDocente(String codigoDocente) {
		this.codigoDocente = codigoDocente;
	}
	public String getCodigoBorrador() {
		return codigoBorrador;
	}
	public void setCodigoBorrador(String codigoBorrador) {
		this.codigoBorrador = codigoBorrador;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
   
	
	
}