package pe.edu.unmsm.integracion.dao;


import java.util.Map;
import pe.edu.unmsm.negocio.modelo.Usuario;


public interface LoginMapper {
	
	public Usuario iniciarSesion(Map<String,String> usuario);
	
}
