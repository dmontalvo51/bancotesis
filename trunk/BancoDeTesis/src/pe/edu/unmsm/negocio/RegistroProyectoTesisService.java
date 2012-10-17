package pe.edu.unmsm.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.integracion.FichasMapper;
import pe.edu.unmsm.integracion.ProyectoTesisMapper;
import pe.edu.unmsm.modelo.Ficha;
import pe.edu.unmsm.modelo.LineaInvestigacion;
import pe.edu.unmsm.modelo.ProyectoTesis;

@Service(value="registroProyectoTesisService")
public class RegistroProyectoTesisService {
	
	//Referencias a los DAO (Mapper = DAO)
	@Autowired
	private ProyectoTesisMapper proyectoTesisMapper;
	
	@Autowired
	private FichasMapper fichasMapper;
	
	//Servicios
	
	public List<LineaInvestigacion> cargarLineasInvestigacion() {
		
		List<LineaInvestigacion> listaLineasInvestigacion=new ArrayList<LineaInvestigacion>();
		
		listaLineasInvestigacion.add(new LineaInvestigacion(1,"Ingeniería de Software"));
		listaLineasInvestigacion.add(new LineaInvestigacion(2,"Inteligencia artificial"));
		listaLineasInvestigacion.add(new LineaInvestigacion(3,"Sistemas distribuidos"));
		
		return listaLineasInvestigacion;
						
	}

	public List<Ficha> cargarListaFichasInscritas() {
		
		List<Ficha> lista=new ArrayList<Ficha>();
		
		//lista=fichasMapper.cargarListaFichasInscritas();
		
		lista.add(new Ficha("026-FISI-2012","titulo1","resumen de la ficha","linea1","Jorge",null,null));
		lista.add(new Ficha("027-FISI-2012","titulo2","resumen de la ficha","linea2","Diego",null,null));
		lista.add(new Ficha("028-FISI-2012","titulo3","resumen de la ficha","linea3","Karina",null,null));
		lista.add(new Ficha("029-FISI-2012","titulo4","resumen de la ficha","linea4","Johnny",null,null));
		
		return lista;
		
	}
	
	
	
	
	
	//Metodos de encapsulamiento

	public ProyectoTesisMapper getProyectoTesisMapper() {
		return proyectoTesisMapper;
	}

	public void setProyectoTesisMapper(ProyectoTesisMapper proyectoTesisMapper) {
		this.proyectoTesisMapper = proyectoTesisMapper;
	}

	public FichasMapper getFichasMapper() {
		return fichasMapper;
	}

	public void setFichasMapper(FichasMapper fichasMapper) {
		this.fichasMapper = fichasMapper;
	}



}
