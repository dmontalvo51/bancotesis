package pe.edu.unmsm.presentacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import pe.edu.unmsm.modelo.Tesis;
import pe.edu.unmsm.negocio.RevisionBorradorTesisService;
import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name = "listarTesis")
public class ListarTesisController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9054693765543258216L;
	private List<Tesis> listTesis = new ArrayList<Tesis>();
	private Tesis selectedTesis;
	
	
	@ManagedProperty("#{revisionBorradorTesisService}")
	private RevisionBorradorTesisService revisionBorradorTesisService;
	
	
	public ListarTesisController() {
		TesisUtil.escribir("Constructor");
		
	}
	//llama a este metodo despues del constructor
	
	@PostConstruct
	public void cargarDatos(){
		TesisUtil.escribir("Cargar Datos");
		setListTesis(llenarTabla());
	}
	
	
	public String nextPage(){
		   TesisUtil.flashScope("tesis", selectedTesis); 
		   return "CargarBorrador?faces-redirect=true";
	}
	
	private List<Tesis> llenarTabla() {
			return revisionBorradorTesisService.cargarListaTesisInscritas();
	}
	
	public String cargarBorrador(){
		return "CargarBorrador";
	}

	public List<Tesis> getListTesis() {
		return listTesis;
	}

	public void setListTesis(List<Tesis> listTesis) {
		this.listTesis = listTesis;
	}

	public Tesis getSelectedTesis() {
		return selectedTesis;
	}

	public void setSelectedTesis(Tesis selectedTesis) {
		this.selectedTesis = selectedTesis;
	}

	public RevisionBorradorTesisService getRevisionBorradorTesisService() {
		return revisionBorradorTesisService;
	}

	public void setRevisionBorradorTesisService(
			RevisionBorradorTesisService revisionBorradorTesisService) {
		this.revisionBorradorTesisService = revisionBorradorTesisService;
	}

}
