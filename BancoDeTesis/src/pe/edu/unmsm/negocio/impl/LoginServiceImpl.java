package pe.edu.unmsm.negocio.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import pe.edu.unmsm.modelo.Usuario;
import pe.edu.unmsm.negocio.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	
	public Usuario iniciarSesion(Map usuario) {
		if(usuario.get("usuario").equals(usuario.get("pass")))
				return new Usuario();
		else  
			return null;
	}

}
