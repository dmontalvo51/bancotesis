package pe.edu.unmsm.presentacion.revisionBorrador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import pe.edu.unmsm.negocio.modelo.DetalleActaObservacion;
import pe.edu.unmsm.negocio.modelo.Docente;
import pe.edu.unmsm.negocio.modelo.Tesis;
import pe.edu.unmsm.negocio.servicio.RegistroProyectoTesisService;


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
	private List<Docente> listaAsesores = new ArrayList<Docente>();
	private List<Docente> listaJurados = new ArrayList<Docente>();
	private Docente jurado;
	private String codigoAsesor;
	private int num=0;
	// Services
	@ManagedProperty("#{registroProyectoTesisService}")
	RegistroProyectoTesisService registroProyectoTesisService;
	
	/********************** INICIALIZACIÓN ***************************/

	public OficiarJuradoEvaluadorController(){
		jurado=new Docente();

	}
	
	@PostConstruct
	public void init(){
		Tesis tesisRecuperado = (Tesis) getParamInFlashContext(TESIS);
		if (tesisRecuperado != null) {
			tesis = tesisRecuperado;
			
		}
		
		listaAsesores = registroProyectoTesisService
				.cargarListaDocentesPorLinea(1);
	}
	
	public String cancelarJE(){
		return VISTA_LISTAR_PROYECTO_TESIS_REGISTRADO;
	}
    
	public void agregarJurado() {
		try{
		if(num==0){
			jurado.setCodigo(getCodigoAsesor());
			jurado.setNombre(registroProyectoTesisService.cargarDatoJurado(codigoAsesor));
			listaJurados.add(jurado);
			num++;
		}else{
			if(num==1){
			jurado.setCodigo(getCodigoAsesor());
			jurado.setNombre(registroProyectoTesisService.cargarDatoJurado(codigoAsesor));
			listaJurados.add(jurado);
			num++;
			}else{
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage("Ya existe dos Jurados",
								"Solo se puede elegir dos jurados"));
			}
		}
		}catch(Exception e){
			
			System.out.println("No encontro al docente");
		}
		
		jurado=new Docente();
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

	public List<Docente> getListaAsesores() {
		return listaAsesores;
	}

	public void setListaAsesores(List<Docente> listaAsesores) {
		this.listaAsesores = listaAsesores;
	}

	public RegistroProyectoTesisService getRegistroProyectoTesisService() {
		return registroProyectoTesisService;
	}

	public void setRegistroProyectoTesisService(
			RegistroProyectoTesisService registroProyectoTesisService) {
		this.registroProyectoTesisService = registroProyectoTesisService;
	}

	public Docente getJurado1() {
		return jurado;
	}

	public void setJurado1(Docente jurado) {
		this.jurado = jurado;
	}

	public String getCodigoAsesor() {
		return codigoAsesor;
	}

	public void setCodigoAsesor(String codigoAsesor) {
		this.codigoAsesor = codigoAsesor;
	}

	public List<Docente> getListaJurados() {
		return listaJurados;
	}

	public void setListaJurados(List<Docente> listaJurados) {
		this.listaJurados = listaJurados;
	}

	public Docente getJurado() {
		return jurado;
	}

	public void setJurado(Docente jurado) {
		this.jurado = jurado;
	}
	
	
	
	
	
	

}
