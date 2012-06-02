package pe.edu.unmsm.presentacion;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import pe.edu.unmsm.modelo.Usuario;
import pe.edu.unmsm.negocio.LoginService;

@ManagedBean(name="login")
@RequestScoped
public class LoginController {
	
	private String cuenta;
	private String password;
	
	@ManagedProperty(value="#{loginService}")
	private LoginService loginService;
	
	
	public String iniciarSesion(){
		Map<String,String> usuario=new HashMap<String,String >();
		usuario.put("usuario",getCuenta());
		usuario.put("pass",getPassword());
		
		Usuario u=new Usuario();
		u=loginService.iniciarSesion(usuario);
		if(u!=null)					
			return "Inicio";
		else{
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Error al iniciar sesión"));
			 return null;
		}
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
	
	public LoginService getLoginService() {
		return loginService;
	}


	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}


}
