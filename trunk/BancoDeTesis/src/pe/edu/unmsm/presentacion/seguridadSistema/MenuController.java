package pe.edu.unmsm.presentacion.seguridadSistema;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

import pe.edu.unmsm.negocio.modelo.OpcionMenu;
import pe.edu.unmsm.negocio.modelo.Usuario;
import pe.edu.unmsm.util.TesisUtil;

@SessionScoped
@ManagedBean(name="menu")
public class MenuController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1961809545155152958L;
	
	private Usuario usuario=new Usuario();
	private MenuModel modeloMenu=new DefaultMenuModel();
	
	
	public MenuController(){
		
		usuario=(Usuario)TesisUtil.obtenerDeSesion("usuario");
			
		construirModelo(usuario.getOpcionesMenu());

	}
	
	public void construirModelo(List<OpcionMenu> listaOpcionesMenu){
		
		for(OpcionMenu om : listaOpcionesMenu){
			
			MenuItem menuItem = new MenuItem();
	        menuItem.setValue(om.getDescripcion());
	        menuItem.setUrl(om.getUrl());
	        modeloMenu.addMenuItem(menuItem);
	       
		}
		
		
				
		
		
	}
	
	public Usuario getUsuario() {
		return (Usuario)TesisUtil.obtenerDeSesion("usuario");
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public MenuModel getModeloMenu() {
		return modeloMenu;
	}

	public void setModeloMenu(MenuModel modeloMenu) {
		this.modeloMenu = modeloMenu;
	}
	
	
	

}
