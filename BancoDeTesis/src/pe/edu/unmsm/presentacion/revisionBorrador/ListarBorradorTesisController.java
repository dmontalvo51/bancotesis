package pe.edu.unmsm.presentacion.revisionBorrador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import pe.edu.unmsm.negocio.modelo.BorradorTesis;
import pe.edu.unmsm.negocio.servicio.RevisionBorradorTesisService;
import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name = "listarBorradorTesis")
public class ListarBorradorTesisController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9054693765543258216L;
	private List<BorradorTesis> listBorradorTesis = new ArrayList<BorradorTesis>();
	private BorradorTesis selectedBorradorTesis;
	
	
	@ManagedProperty("#{revisionBorradorTesisService}")
	private RevisionBorradorTesisService revisionBorradorTesisService;
	
	
	public ListarBorradorTesisController() {
		TesisUtil.escribir("Constructor");
		
	}
	//llama a este metodo despues del constructor
	
	@PostConstruct
	public void cargarDatos(){
		//TesisUtil.escribir("Cargar Datos");
		//setListTesis(llenarTabla());
		String origen=FacesContext.getCurrentInstance().getExternalContext().getRequestServletPath();
		origen=origen.substring(7,origen.length()-4);
		TesisUtil.escribir(origen);	
		
		if(origen.equals("ListarFichasProyectoDeTesis"))
			setListBorradorTesis(listarBorradorTesis());
		else if (origen.equals("ListarProyectosTesis"))
			setListBorradorTesis(listarBorradorTesis());
		else if(origen.equals("ListarBorradorTesis"))
			setListBorradorTesis(listarBorradorTesis());
	}
	
	
	public String nextPage(){
	    TesisUtil.flashScope("tesis", selectedBorradorTesis);
		return "CargarBorrador?faces-redirect=true";
	}
	
	public String generarActaObservacion(){
	    TesisUtil.subirASesion("borrador", selectedBorradorTesis);
		return "GenerarActaObservacion?faces-redirect=true";
	}
	
	
	private List<BorradorTesis> listarBorradorTesis() {
		return revisionBorradorTesisService.cargarListaBorradorTesis();
	}
	
	public String cargarBorrador(){
		return "CargarBorrador";
	}

	public RevisionBorradorTesisService getRevisionBorradorTesisService() {
		return revisionBorradorTesisService;
	}

	public void setRevisionBorradorTesisService(
			RevisionBorradorTesisService revisionBorradorTesisService) {
		this.revisionBorradorTesisService = revisionBorradorTesisService;
	}

	public List<BorradorTesis> getListBorradorTesis() {
		return listBorradorTesis;
	}

	public void setListBorradorTesis(List<BorradorTesis> listBorradorTesis) {
		this.listBorradorTesis = listBorradorTesis;
	}

	public BorradorTesis getSelectedBorradorTesis() {
		return selectedBorradorTesis;
	}

	public void setSelectedBorradorTesis(BorradorTesis selectedBorradorTesis) {
		this.selectedBorradorTesis = selectedBorradorTesis;
	}

	
	
}
