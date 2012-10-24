package pe.edu.unmsm.negocio.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.integracion.dao.LoginMapper;
import pe.edu.unmsm.negocio.modelo.OpcionMenu;
import pe.edu.unmsm.negocio.modelo.Usuario;

@Service(value = "seguridadService")
public class SeguridadService {
	
	@Autowired
	LoginMapper loginMapper;

	public SeguridadService() {

	}	
	
	public Usuario iniciarSesion(Map usuario) {

		Usuario usu;
		usu= loginMapper.iniciarSesion(usuario);

		if (usu != null) {
			// usu.setOpcionesMenu(loginMapper.cargarOpcionesMenu(usuario));

			List<OpcionMenu> opcionesMenu = new ArrayList<OpcionMenu>();
			opcionesMenu.add(new OpcionMenu("/pages/DatosBachiller.jsf",
					"Mis datos", ""));
			opcionesMenu.add(new OpcionMenu("/pages/InformeProyectoTesis.jsf",
					"Informe Proyecto Tesis", ""));
			opcionesMenu.add(new OpcionMenu("/pages/LlenarFicha.jsf",
					"Llenar Ficha", ""));
			opcionesMenu.add(new OpcionMenu("/pages/RegistrarActaConformidad.jsf",
					"Registrar Acta de Conformidad", ""));
			opcionesMenu.add(new OpcionMenu("/pages/RegistrarActaSustentacion.jsf",
					"Registrar Acta de sustentaci�n", ""));
			opcionesMenu.add(new OpcionMenu("/pages/RegistrarRDInscripcion.jsf",
					"Registrar RD Inscripcion", ""));

			opcionesMenu.add(new OpcionMenu("/pages/ListarFichasProyectoDeTesis.jsf",
					"Revisar ficha de Tesis", ""));
			
			opcionesMenu.add(new OpcionMenu("/pages/ListarTesis.jsf",
					"Listar Tesis", ""));
			
			usu.setOpcionesMenu(opcionesMenu);

			return usu;
		} else
			return null;
	}
	
	public LoginMapper getLoginMapper() {
		return loginMapper;
	}

	public void setLoginMapper(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}
}
