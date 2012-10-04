package pe.edu.unmsm.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.batch.core.annotation.BeforeProcess;
import org.springframework.batch.core.annotation.BeforeWrite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.integracion.LoginMapper;
import pe.edu.unmsm.modelo.OpcionMenu;
import pe.edu.unmsm.modelo.Usuario;
import pe.edu.unmsm.util.TesisUtil;

@Service(value="loginService")
public class LoginService {
	
	@Autowired
	LoginMapper loginMapper;

	public LoginService() {

	}

	public Usuario iniciarSesion(Map usuario) {
		
		Usuario usu;
		//usu= loginMapper.iniciarSesion(usuario);
				
		
		//borrar cuando haya base de datos
		if(usuario.get("cuenta").equals(usuario.get("pass")))
			usu=new Usuario();
		else
			usu=null;
		//borrar cuando haya base de datos
		
		
		if (usu != null){
			//usu.setOpcionesMenu(loginMapper.cargarOpcionesMenu(usuario));
			
			List<OpcionMenu> opcionesMenu=new ArrayList<OpcionMenu>();
			opcionesMenu.add(new OpcionMenu("/pages/DetalleTesis.jsf", "DetalleTesis", ""));
			opcionesMenu.add(new OpcionMenu("/pages/InformeProyectoTesis.jsf", "Informe Proyecto Tesis", ""));
			opcionesMenu.add(new OpcionMenu("/pages/IngresarFicha.jsf", "Ingresar Ficha", ""));
			
			usu.setOpcionesMenu(opcionesMenu);
			
			return usu;
		}
		else
			return null;
	}

	public LoginMapper getLoginMapper() {
		return loginMapper;
	}

	public void setLoginMapper(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}

}
