package pe.edu.unmsm.negocio.servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.integracion.dao.LoginMapper;
import pe.edu.unmsm.integracion.dao.OpcionMenuMapper;
import pe.edu.unmsm.integracion.dao.PerfilMapper;
import pe.edu.unmsm.negocio.modelo.DatoMaestro;
import pe.edu.unmsm.negocio.modelo.OpcionMenu;
import pe.edu.unmsm.negocio.modelo.Usuario;

@Service(value = "seguridadService")
public class SeguridadService {
	
	@Autowired
	LoginMapper loginMapper;
	
	@Autowired
	OpcionMenuMapper opcionMenuMapper;
	
	@Autowired
	PerfilMapper perfilMapper;
	
	public SeguridadService() {

	}	
	
	public Usuario iniciarSesion(Map usuario) {

		Usuario usu;
		usu= loginMapper.iniciarSesion(usuario);
		
		if (usu != null) {
			usu.setOpcionesMenu(opcionMenuMapper.cargarOpcionesMenu(usu.getCuenta()));
			// usu.setOpcionesMenu(loginMapper.cargarOpcionesMenu(usuario.getCuenta()));

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
					"Registrar Acta de sustentación", ""));
			opcionesMenu.add(new OpcionMenu("/pages/RegistrarRDInscripcion.jsf",
					"Registrar RD Inscripcion", ""));

			opcionesMenu.add(new OpcionMenu("/pages/ListarFichasProyectoDeTesis.jsf",
					"Revisar ficha de Tesis", ""));
			
			opcionesMenu.add(new OpcionMenu("/pages/ListarProyectosTesis.jsf",
					"Solicitud de registro de proyecto de tesis", ""));
			
			opcionesMenu.add(new OpcionMenu("/pages/ListarTesis.jsf",
					"Listar Tesis", ""));
			
			opcionesMenu.add(new OpcionMenu("/pages/ListarProyectoTesisRegistrado.jsf",
					"Asignar Jurado Evaluar", ""));
			
			opcionesMenu.add(new OpcionMenu("/pages/ListarBorradorTesis.jsf",
					"Revisar Borrador de Tesis", ""));
			
			opcionesMenu.add(new OpcionMenu("/pages/LevantarObservaciones.jsf",
					"Levantar Observaciones", ""));
			
			usu.setOpcionesMenu(opcionesMenu);

			return usu;
		} else
			return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public void ingresarOpcionMenu(OpcionMenu opcionMenu,List<Integer> perfiles){
		try {
			
			opcionMenuMapper.ingresarOpcionMenu(opcionMenu);
			
			for(Integer codigoPerfil:perfiles){
				Map map=new HashMap<String,Integer>();
				map.put("perfil",codigoPerfil);
				map.put("opcionMenu",opcionMenu.getIdOpcionMenu());
				opcionMenuMapper.ingresarPermisoPorPerfil(map);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public List<DatoMaestro> cargarPerfiles(){
		return perfilMapper.cargarPerfiles();
	}
	
	public LoginMapper getLoginMapper() {
		return loginMapper;
	}

	public void setLoginMapper(LoginMapper loginMapper) {
		this.loginMapper = loginMapper;
	}
}
