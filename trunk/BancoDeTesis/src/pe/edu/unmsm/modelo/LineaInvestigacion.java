package pe.edu.unmsm.modelo;

public class LineaInvestigacion {
	
	private int id;
	private String lineaInvestigacion;

		
	public LineaInvestigacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LineaInvestigacion(int id, String lineaInvestigacion) {
		super();
		this.id = id;
		this.lineaInvestigacion = lineaInvestigacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLineaInvestigacion() {
		return lineaInvestigacion;
	}

	public void setLineaInvestigacion(String lineaInvestigacion) {
		this.lineaInvestigacion = lineaInvestigacion;
	}


	

}
