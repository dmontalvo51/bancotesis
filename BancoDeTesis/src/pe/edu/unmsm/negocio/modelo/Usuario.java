package pe.edu.unmsm.negocio.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 5735379635324594498L;
	
	private String cuenta;
	private String nombres;
	private String apellidos;
	private String perfil;
	private int tipo;
	private Date fecha;
	private String correo;
	
	private List<OpcionMenu> opcionesMenu;
	
	
	public List<OpcionMenu> getOpcionesMenu() {
		return opcionesMenu;
	}
	public void setOpcionesMenu(List<OpcionMenu> opcionesMenu) {
		this.opcionesMenu = opcionesMenu;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
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
		return apellidos;
	}
	public void setaPaterno(String aPaterno) {
		this.apellidos = aPaterno;
	}

	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	


}
