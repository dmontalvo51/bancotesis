package pe.edu.unmsm.modelo;

public class Usuario {
	
	private int id;
	private String cuenta;
	private String nombres;
	private String aPaterno;
	private String aMaterno;
	private String codigo;
	private String perfil;
	
	
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getaPaterno() {
		return aPaterno;
	}
	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}
	public String getaMaterno() {
		return aMaterno;
	}
	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	


}
