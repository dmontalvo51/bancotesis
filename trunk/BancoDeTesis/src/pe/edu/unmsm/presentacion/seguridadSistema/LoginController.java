package pe.edu.unmsm.presentacion.seguridadSistema;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pe.edu.unmsm.negocio.modelo.Usuario;
import pe.edu.unmsm.negocio.servicio.SeguridadService;
import pe.edu.unmsm.util.TesisUtil;

@RequestScoped
@ManagedBean(name = "login")
public class LoginController implements Serializable {

	private static final long serialVersionUID = 730531515518687976L;
	private String cuenta;
	private String password;
	private Usuario usuario;

	@ManagedProperty("#{seguridadService}")
	SeguridadService seguridadService;

	public String iniciarSesion() {

		Map<String, String> usu = new HashMap<String, String>();
		usu.put("cuenta", getCuenta());
		usu.put("pass", getPassword());

		usuario = seguridadService.iniciarSesion(usu);

		if (usuario != null) {
			TesisUtil.subirASesion("usuario", usuario);
			return "Inicio.xhtml?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
							"Error al iniciar sesión"));
			return null;
		}
	}

	public String cerrarSesion() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "Login.xhtml?faces-redirect=true";
		
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public SeguridadService getSeguridadService() {
		return seguridadService;
	}

	public void setSeguridadService(SeguridadService seguridadService) {
		this.seguridadService = seguridadService;
	}
	
	

}
