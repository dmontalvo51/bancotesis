package pe.edu.unmsm.presentacion.revisionBorrador;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import pe.edu.unmsm.negocio.modelo.Tesis;


@ManagedBean(name = "oficiarJuradoEvaluador")
@ViewScoped
public class OficiarJuradoEvaluadorController implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -3650160015170800119L;
	
	private static final String VISTA_LISTAR_PROYECTO_TESIS_REGISTRADO = "ListarProyectoTesisRegistrado?faces-redirect=true";
	
	private static final String TESIS = "tesis";
	private Tesis tesis;
	
	/********************** INICIALIZACIÓN ***************************/

	public OficiarJuradoEvaluadorController(){
		
		
	}
	
	@PostConstruct
	public void init(){
		Tesis tesisRecuperado = (Tesis) getParamInFlashContext(TESIS);
		if (tesisRecuperado != null) {
			tesis = tesisRecuperado;
			
		}
	}
	
	public String cancelarJE(){
		return VISTA_LISTAR_PROYECTO_TESIS_REGISTRADO;
	}
    
	
	/********************** FLASH MARITA ***********************/
	private FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
	
	private Object getParamInFlashContext(String nameParam){
	    	Flash flash = getFacesContext().getExternalContext().getFlash();
			return flash.get(nameParam);
	}
	
	
	/***************** SETTER AND GETTER *****************************/
	public Tesis getTesis() {
		return tesis;
	}

	public void setTesis(Tesis tesis) {
		this.tesis = tesis;
	}
	
	
	
	
	
	

}
