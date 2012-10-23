package pe.edu.unmsm.negocio.modelo;

public class ProyectoTesis {
	
	private String nroExpediente;
	private String codigoFicha;
	private String titulo;
	private String lineaInvestigacion;
	private String nomBachiller;
	private String estado;
	private String asesor;
	private String resumen;
	
	
		
	public ProyectoTesis(String nroExpediente, String codigoFicha,
			String titulo, String lineaInvestigacion, String nomBachiller,
			String estado, String asesor, String resumen) {
		super();
		this.nroExpediente = nroExpediente;
		this.codigoFicha = codigoFicha;
		this.titulo = titulo;
		this.lineaInvestigacion = lineaInvestigacion;
		this.nomBachiller = nomBachiller;
		this.estado = estado;
		this.asesor = asesor;
		this.resumen = resumen;
	}
	public ProyectoTesis(String nroExpediente, String codigoFicha,
			String titulo, String lineaInvestigacion, String nomBachiller,
			String estado) {
		super();
		this.nroExpediente = nroExpediente;
		this.codigoFicha = codigoFicha;
		this.titulo = titulo;
		this.lineaInvestigacion = lineaInvestigacion;
		this.nomBachiller = nomBachiller;
		this.estado = estado;
	}
	public String getLineaInvestigacion() {
		return lineaInvestigacion;
	}
	public void setLineaInvestigacion(String lineaInvestigacion) {
		this.lineaInvestigacion = lineaInvestigacion;
	}
	public String getNroExpediente() {
		return nroExpediente;
	}
	public void setNroExpedientee(String nroExpediente) {
		this.nroExpediente = nroExpediente;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	
}
