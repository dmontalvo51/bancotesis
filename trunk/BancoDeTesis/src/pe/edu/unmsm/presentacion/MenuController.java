package pe.edu.unmsm.presentacion;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import pe.edu.unmsm.modelo.Usuario;
import pe.edu.unmsm.util.TesisUtil;

@SessionScoped
@ManagedBean(name="menu")
public class MenuController {
	
	Usuario usuario;

	public Usuario getUsuario() {
		return (Usuario)TesisUtil.obtenerDeSesion("usuario");
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
