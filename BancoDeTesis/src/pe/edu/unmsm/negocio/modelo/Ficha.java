package pe.edu.unmsm.negocio.modelo;

public class Ficha {
	
//datos de la tabla
	
	private String nroExpediente;
	private String codigo;
	private String titulo;
	private String resumen;
	private String lineaInvestigacion;
	private String nomBachiller;
	private String estado;
	private String asesor;
	
	
	
	
	public Ficha(String nroExpediente, String codigo, String titulo,
			String resumen, String lineaInvestigacion, String nomBachiller,
			String estado, String asesor) {
		super();
		this.nroExpediente = nroExpediente;
		this.codigo = codigo;
		this.titulo = titulo;
		this.resumen = resumen;
		this.lineaInvestigacion = lineaInvestigacion;
		this.nomBachiller = nomBachiller;
		this.estado = estado;
		this.asesor = asesor;
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
	public String getAsesor() {
		return asesor;
	}
	public void setAsesor(String asesor) {
		this.asesor = asesor;
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
	

//metodos set y get

	
}
	