package pe.edu.unmsm.negocio.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import pe.edu.unmsm.integracion.LoginMapper;
import pe.edu.unmsm.modelo.Usuario;
import pe.edu.unmsm.negocio.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Resource
	LoginMapper loginMapper;
	
	public Usuario iniciarSesion(Map usuario) {
		Usuario usu=loginMapper.iniciarSesion(usuario);
		if(usu!=null)
			return usu;
		else  
			return null;
	}

}
