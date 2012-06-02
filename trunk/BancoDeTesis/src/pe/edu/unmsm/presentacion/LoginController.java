package pe.edu.unmsm.presentacion;

import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.edu.unmsm.modelo.Usuario;
import pe.edu.unmsm.negocio.LoginService;
import pe.edu.unmsm.util.TesisUtil;

@ManagedBean(name="login")
@SessionScoped
public class LoginController {
	
	private String cuenta;
	private String password;
	private Usuario usuario;
	
	
	@ManagedProperty(value="#{loginService}")
	private LoginService loginService;
	
	
	public String iniciarSesion(){
		Map<String,String> usu=new HashMap<String,String >();
		usu.put("usuario",getCuenta());
		usu.put("pass",getPassword());
		
		usuario=loginService.iniciarSesion(usu);
		if(usuario!=null)					
			return "Inicio";
		else{
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Error al iniciar sesión"));
			 return null;
		}
	}
	
	public String cerrarSesion(){
		TesisUtil.escribir("Cerrando sesion");
		return "Login";
		
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

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
