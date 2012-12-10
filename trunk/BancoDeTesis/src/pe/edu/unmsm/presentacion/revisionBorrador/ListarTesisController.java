package pe.edu.unmsm.presentacion.revisionBorrador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import pe.edu.unmsm.negocio.modelo.Tesis;
import pe.edu.unmsm.negocio.servicio.RevisionBorradorTesisService;
import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name = "listarTesis")
public class ListarTesisController implements Serializable {


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
		String origen=FacesContext.getCurrentInstance().getExternalContext().getRequestServletPath();
		origen=origen.substring(7,origen.length()-4);
		TesisUtil.escribir(origen);	
		if(origen.equals("ListarTesis"))
			setListTesis(llenarTabla());
		else if (origen.equals("ListarProyectosTesis"))
			setListTesis(llenarTabla());

	}
	
	private List<Tesis> llenarTabla() {
		return revisionBorradorTesisService.cargarListaTesis();
	}
	
	public String presentarBorradorTesis(){
	    TesisUtil.subirASesion("tesis", selectedTesis);
		return "PresentarBorradorTesis?faces-redirect=true";
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
