package pe.edu.unmsm.modelo;

public class ProyectoTesis {
	private String NroExpediente;
	private String titulo;
	private String lineaInvestigacion;
	private String nomBachiller;
	private String estado;
	
	

	
	public ProyectoTesis(String nroExpediente, String titulo,String lineaInvestigacion, String nomBachiller,String estado) {
		super();
		NroExpediente = nroExpediente;
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
		return NroExpediente;
	}
	public void setNroExpedientee(String nroExpediente) {
		NroExpediente = nroExpediente;
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
