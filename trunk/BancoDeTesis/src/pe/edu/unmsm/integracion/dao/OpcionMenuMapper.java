package pe.edu.unmsm.integracion.dao;

import java.util.List;
import java.util.Map;

import pe.edu.unmsm.negocio.modelo.OpcionMenu;

public interface OpcionMenuMapper {
	
	public List<OpcionMenu> cargarOpcionesMenu(String codigoUsuario);
	
	public void ingresarOpcionMenu(OpcionMenu opcionMenu);
	
	public void ingresarPermisoPorPerfil(Map<String,Integer> permiso_perfil_menu);

	public int existeOpcion(String descripcion);

}
