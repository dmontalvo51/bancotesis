package pe.edu.unmsm.negocio.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.integracion.dao.FichasMapper;
import pe.edu.unmsm.integracion.dao.InformeProyectoTesisMapper;
import pe.edu.unmsm.integracion.dao.ProyectoTesisMapper;
import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.InformeProyectoTesis;
import pe.edu.unmsm.negocio.modelo.LineaInvestigacion;
import pe.edu.unmsm.negocio.modelo.Tesis;

@Service(value="registroProyectoTesisService")
public class RegistroProyectoTesisService {
	
	//Referencias a los DAO (Mapper = DAO)
	@Autowired
	private ProyectoTesisMapper proyectoTesisMapper;
	
	@Autowired
	private FichasMapper fichasMapper;
	
	@Autowired
	private InformeProyectoTesisMapper informeProyectoTesisMapper;
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
		
		lista.add(new Ficha("026-FISI-2012","F001","titulo1","resumen de la ficha","linea1","Jorge","sin revisar","Bustamante"));
		lista.add(new Ficha("027-FISI-2012","F002","titulo2","resumen de la ficha","linea2","Diego","revisado","Piedra"));
		lista.add(new Ficha("028-FISI-2012","F003","titulo3","resumen de la ficha","linea3","Karina","revisado","Mauricio"));
		lista.add(new Ficha("029-FISI-2012","F004","titulo4","resumen de la ficha","linea4","Johnny","sin revisado","Luza"));
		
		return lista;
		
	}
	
	public List<InformeProyectoTesis> cargarInformeProyetoTesis() {
		
		List<InformeProyectoTesis> lista=new ArrayList<InformeProyectoTesis>();
		
		//lista=InformeProyectoTesisMapper.cargarInformeProyectoTesis();
		
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


	public InformeProyectoTesisMapper getInformeProyectoTesisMapper() {
		return informeProyectoTesisMapper;
	}

	public void setInformeProyectoTesisMapper(
			InformeProyectoTesisMapper informeProyectoTesisMapper) {
		this.informeProyectoTesisMapper = informeProyectoTesisMapper;
	}

	public void destruir(ActionEvent actionEvent){  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "System Error",  "Please try again later.");  
          
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }

}
