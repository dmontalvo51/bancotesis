package pe.edu.unmsm.modelo;

public class OpcionMenu {
	
	private String url;
	private String descripcion;
	private String icono;
	
	
	
	public OpcionMenu(String url, String descripcion, String icono) {
		super();
		this.url = url;
		this.descripcion = descripcion;
		this.icono = icono;
	}
	
	public OpcionMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	
	
	
	
}
