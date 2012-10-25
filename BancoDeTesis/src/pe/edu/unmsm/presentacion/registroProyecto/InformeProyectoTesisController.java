package pe.edu.unmsm.presentacion.registroProyecto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.ProyectoTesis;
import pe.edu.unmsm.negocio.servicio.RegistroProyectoTesisService;
import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name = "informeProyectoTesis")
public class InformeProyectoTesisController implements Serializable {
	private String ipt_observaciones;
	private String ipt_sugerencias;
	private int ipt_opinion;
	
	public int getIpt_opinion() {
		return ipt_opinion;
	}

	public void setIpt_opinion(int ipt_opinion) {
		this.ipt_opinion = ipt_opinion;
	}

	public String getIpt_observaciones() {
		return ipt_observaciones;
	}

	public void setIpt_observaciones(String ipt_observaciones) {
		this.ipt_observaciones = ipt_observaciones;
	}

	public String getIpt_sugerencias() {
		return ipt_sugerencias;
	}

	public void setIpt_sugerencias(String ipt_sugerencias) {
		this.ipt_sugerencias = ipt_sugerencias;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 9054693765543258216L;
	
	
	@ManagedProperty("#{registroProyectoTesisService}")
	private RegistroProyectoTesisService registroProyectoTesisService;
	
	
	public InformeProyectoTesisController() {
		
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
