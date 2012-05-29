package pe.edu.unmsm.presentacion;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginController {
	
	private String cuenta;
	private String password;
	
	public String iniciarSesion(){
		//Llamar al servicio de conexión a datos.
		//Inyeccion de dependencias
		//Invocación de métodos
				
		return "inicio";
	}
	
	
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
