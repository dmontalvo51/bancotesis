package pe.edu.unmsm.modelo;

public class Ficha {
	
//datos de la tabla
	private int codigo;
	private String Titulo;
	private String Bosquejo;
	
//datos cruzados
	//LineaInvestigacion LineaInvestigacion;
	//Asesor Asesor;
	private String LineaInvestigacion;
	private String Asesor;
	
//metodos set y get
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return Titulo;
	}
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	public String getBosquejo() {
		return Bosquejo;
	}
	public void setBosquejo(String bosquejo) {
		Bosquejo = bosquejo;
	}
	public String getLineaInvestigacion() {
		return LineaInvestigacion;
	}
	public void setLineaInvestigacion(String lineaInvestigacion) {
		LineaInvestigacion = lineaInvestigacion;
	}
	public String getAsesor() {
		return Asesor;
	}
	public void setAsesor(String asesor) {
		Asesor = asesor;
	}
	
}
	