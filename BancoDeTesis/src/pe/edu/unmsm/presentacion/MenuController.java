package pe.edu.unmsm.presentacion;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import pe.edu.unmsm.modelo.Usuario;
import pe.edu.unmsm.util.TesisUtil;

@SessionScoped
@ManagedBean(name="menu")
public class MenuController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1961809545155152958L;
	
	private Usuario usuario;

	public Usuario getUsuario() {
		return (Usuario)TesisUtil.obtenerDeSesion("usuario");
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
