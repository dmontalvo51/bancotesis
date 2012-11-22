package pe.edu.unmsm.negocio.modelo;


public class BorradorTesis {
	
	private String codigoTes;
	private String codigo;
	private String titulo;
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
	
	
	public BorradorTesis() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BorradorTesis(String codigoTes, String codigo, String titulo,
			String lineaInvestigacion, int codigoLineaInvestigacion,
			String nomBachiller, String codigoBachiller, String estado,
			String nombreAsesor, String codigoAsesor, String ruta,
			String fecha, String hora) {
		super();
		this.codigoTes = codigoTes;
		this.codigo = codigo;
		this.titulo = titulo;
		this.lineaInvestigacion = lineaInvestigacion;
		this.codigoLineaInvestigacion = codigoLineaInvestigacion;
		this.nomBachiller = nomBachiller;
		this.codigoBachiller = codigoBachiller;
		this.estado = estado;
		this.nombreAsesor = nombreAsesor;
		this.codigoAsesor = codigoAsesor;
		this.ruta = ruta;
		this.fecha = fecha;
		this.hora = hora;
	}


	public String getCodigoTes() {
		return codigoTes;
	}


	public void setCodigoTes(String codigoTes) {
		this.codigoTes = codigoTes;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getLineaInvestigacion() {
		return lineaInvestigacion;
	}


	public void setLineaInvestigacion(String lineaInvestigacion) {
		this.lineaInvestigacion = lineaInvestigacion;
	}


	public int getCodigoLineaInvestigacion() {
		return codigoLineaInvestigacion;
	}


	public void setCodigoLineaInvestigacion(int codigoLineaInvestigacion) {
		this.codigoLineaInvestigacion = codigoLineaInvestigacion;
	}


	public String getNomBachiller() {
		return nomBachiller;
	}


	public void setNomBachiller(String nomBachiller) {
		this.nomBachiller = nomBachiller;
	}


	public String getCodigoBachiller() {
		return codigoBachiller;
	}


	public void setCodigoBachiller(String codigoBachiller) {
		this.codigoBachiller = codigoBachiller;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
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


	
	}