package pe.edu.unmsm.negocio.modelo;

public class DetalleActaObservacion {
	
	private String ao_codigo;
	private int linea;
	private int nroPagina;
	private String observaciones;
	
	
	public DetalleActaObservacion(String ao_codigo, int linea, int nroPagina,
			String observaciones) {
		super();
		this.ao_codigo = ao_codigo;
		this.linea = linea;
		this.nroPagina = nroPagina;
		this.observaciones = observaciones;
	}
	
	public DetalleActaObservacion(){
		
	}
	public String getAo_codigo() {
		return ao_codigo;
	}
	public void setAo_codigo(String ao_codigo) {
		this.ao_codigo = ao_codigo;
	}
	public int getLinea() {
		return linea;
	}
	public void setLinea(int linea){
		this.linea=linea;
	}
	public int getNroPagina() {
		return nroPagina;
	}
	public void setNroPagina(int nroPagina) {
		this.nroPagina = nroPagina;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	

}
