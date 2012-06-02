package pe.edu.unmsm.negocio;

import java.util.Map;

import pe.edu.unmsm.modelo.Usuario;

public interface LoginService {
	
	public Usuario iniciarSesion(Map usuario);

}
