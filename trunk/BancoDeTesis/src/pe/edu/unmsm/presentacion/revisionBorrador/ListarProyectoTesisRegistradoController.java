package pe.edu.unmsm.presentacion.revisionBorrador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import pe.edu.unmsm.negocio.modelo.Tesis;
import pe.edu.unmsm.negocio.servicio.RevisionBorradorTesisService;


@ManagedBean(name="listarProyectoTesisRegistrado")
@ViewScoped
public class ListarProyectoTesisRegistradoController implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -7229399356318948263L;
	
	private static final String VISTA_OFICIAR_JURADO_EVALUADOR = "OficiarJuradoEvaluador?faces-redirect=true";
	
	private static final String TESIS = "tesis";	
	private List<Tesis> listaTesisRegistrados;
	private Tesis selectedTesis;
	
	
	@ManagedProperty(value = "#{revisionBorradorTesisService}")
	private RevisionBorradorTesisService revisionBorradorTesisService;

	
	/****************** INICIALIZACIÓN **********************/
	

	public ListarProyectoTesisRegistradoController(){
	}

	@PostConstruct
	public void init(){
		try {
			listaTesisRegistrados = revisionBorradorTesisService.cargarListaTesisRegistrados();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR : " + e);
		}
		
	}

	/****************************  METODOS  ****************************************/
	
	public String oficiarJE(){
		try {
			setParamInFlashContext(TESIS, selectedTesis);
			return  VISTA_OFICIAR_JURADO_EVALUADOR;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR : " + e);
			return null;
		}		
	}
	
	
	/********************** FLASH MARITA ***********************/
	private FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
	
	private void setParamInFlashContext(String nameParam, Object valueParam){		 
		Flash flash = getFacesContext().getExternalContext().getFlash();
        flash.put(nameParam, valueParam);
	}

	
	/************************SETTER AND  GETTER **********************************/
	
	public List<Tesis> getListaTesisRegistrados() {
		return listaTesisRegistrados;
	}

	public void setListaTesisRegistrados(List<Tesis> listaTesisRegistrados) {
		this.listaTesisRegistrados = listaTesisRegistrados;
	}

	public RevisionBorradorTesisService getRevisionBorradorTesisService() {
		return revisionBorradorTesisService;
	}

	public void setRevisionBorradorTesisService(
			RevisionBorradorTesisService revisionBorradorTesisService) {
		this.revisionBorradorTesisService = revisionBorradorTesisService;
	}

	public Tesis getSelectedTesis() {
		return selectedTesis;
	}

	public void setSelectedTesis(Tesis selectedTesis) {
		this.selectedTesis = selectedTesis;
	}
	
	
}
