package pe.edu.unmsm.negocio.modelo;

import java.io.Serializable;

public class Ficha implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//datos de la tabla
	
	private String nroExpediente;
	private String codigo;
	private String titulo;
	private String resumen;
	private String lineaInvestigacion;
	private int codigoLineaInvestigacion;
	private String nomBachiller;
	private String codigoBachiller;
	private String estado;
	private String nombreAsesor;
	private String codigoAsesor;
	private String ruta;
	private String fecha;
	private String hora;
	private String codigoRDinscripcion;
	private String rutaRDinscripcion;
	private int resolucionDirectoralAprobada;
	private String codigoTesis;
	
	public Ficha() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Ficha(String nroExpediente, String codigo, String titulo,
			String resumen, String lineaInvestigacion,
			int codigoLineaInvestigacion, String nomBachiller,
			String codigoBachiller, String estado, String nombreAsesor,
			String codigoAsesor, String ruta) {
		super();
		this.nroExpediente = nroExpediente;
		this.codigo = codigo;
		this.titulo = titulo;
		this.resumen = resumen;
		this.lineaInvestigacion = lineaInvestigacion;
		this.codigoLineaInvestigacion = codigoLineaInvestigacion;
		this.nomBachiller = nomBachiller;
		this.codigoBachiller = codigoBachiller;
		this.estado = estado;
		this.nombreAsesor = nombreAsesor;
		this.codigoAsesor = codigoAsesor;
	}


	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public String getLineaInvestigacion() {
		return lineaInvestigacion;
	}
	public void setLineaInvestigacion(String lineaInvestigacion) {
		this.lineaInvestigacion = lineaInvestigacion;
	}
	public String getNomBachiller() {
		return nomBachiller;
	}
	public void setNomBachiller(String nomBachiller) {
		this.nomBachiller = nomBachiller;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNroExpediente() {
		return nroExpediente;
	}
	public void setNroExpediente(String nroExpediente) {
		this.nroExpediente = nroExpediente;
	}
	public String getCodigoBachiller() {
		return codigoBachiller;
	}
	public void setCodigoBachiller(String codigoBachiller) {
		this.codigoBachiller = codigoBachiller;
	}
	public String getNombreAsesor() {
		return nombreAsesor;
	}
	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}
	public String getCodigoAsesor() {
		return codigoAsesor;
	}
	public void setCodigoAsesor(String codigoAsesor) {
		this.codigoAsesor = codigoAsesor;
	}
	public int getCodigoLineaInvestigacion() {
		return codigoLineaInvestigacion;
	}
	public void setCodigoLineaInvestigacion(int codigoLineaInvestigacion) {
		this.codigoLineaInvestigacion = codigoLineaInvestigacion;
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


	public String getCodigoRDinscripcion() {
		return codigoRDinscripcion;
	}


	public void setCodigoRDinscripcion(String codigoRDinscripcion) {
		this.codigoRDinscripcion = codigoRDinscripcion;
	}


	public String getRutaRDinscripcion() {
		return rutaRDinscripcion;
	}


	public void setRutaRDinscripcion(String rutaRDinscripcion) {
		this.rutaRDinscripcion = rutaRDinscripcion;
	}


	public int getResolucionDirectoralAprobada() {
		return resolucionDirectoralAprobada;
	}


	public void setResolucionDirectoralAprobada(int resolucionDirectoralAprobada) {
		this.resolucionDirectoralAprobada = resolucionDirectoralAprobada;
	}


	public String getCodigoTesis() {
		return codigoTesis;
	}


	public void setCodigoTesis(String codigoTesis) {
		this.codigoTesis = codigoTesis;
	}

	
}
	