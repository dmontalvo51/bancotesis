package pe.edu.unmsm.presentacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.unmsm.modelo.Ficha;
import pe.edu.unmsm.modelo.ProyectoTesis;
import pe.edu.unmsm.negocio.RegistroProyectoTesisService;
import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name = "informeProyectoTesis")
public class InformeProyectoTesis implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9054693765543258216L;
	
	
	@ManagedProperty("#{registroProyectoTesisService}")
	private RegistroProyectoTesisService registroProyectoTesisService;
	
	
	public InformeProyectoTesis() {
		
	}
	
	@PostConstruct
	public void cargarDatos(){
	
	}
	
	
	
	
	public RegistroProyectoTesisService getRegistroProyectoTesisService() {
		return registroProyectoTesisService;
	}

	public void setRegistroProyectoTesisService(
			RegistroProyectoTesisService registroProyectoTesisService) {
		this.registroProyectoTesisService = registroProyectoTesisService;
	}

	
}
