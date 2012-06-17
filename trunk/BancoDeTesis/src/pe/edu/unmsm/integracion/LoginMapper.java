package pe.edu.unmsm.integracion;

import java.util.Map;

import org.springframework.stereotype.Repository;

import pe.edu.unmsm.modelo.Usuario;


public interface LoginMapper {
	
	public Usuario iniciarSesion(Map<String,String> usuario);

}
