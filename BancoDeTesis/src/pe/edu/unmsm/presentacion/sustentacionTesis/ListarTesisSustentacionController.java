package pe.edu.unmsm.presentacion.sustentacionTesis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import pe.edu.unmsm.negocio.modelo.Tesis;
import pe.edu.unmsm.negocio.servicio.SustentarTesisService;
import pe.edu.unmsm.util.TesisUtil;

@ManagedBean(name="listarTesisSustentacion")
@ViewScoped
public class ListarTesisSustentacionController implements Serializable {
	
	private static final long serialVersionUID = 9054693765543258216L;
	private List<Tesis> listTesis = new ArrayList<Tesis>();
	private Tesis selectedTesis;
	
	@ManagedProperty("#{sustentarTesisService}")
	private SustentarTesisService sustentarTesisService;

	public ListarTesisSustentacionController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void cargarDatos(){
		
		String origen=FacesContext.getCurrentInstance().getExternalContext().getRequestServletPath();
		origen=origen.substring(7,origen.length()-4);
		
		if(origen.equals("ListarTesisPorAprobar"))
			cargarListaTesisPorAprobar();
		else if (origen.equals("ListarTesisAprobadas"))
			cargarListaTesisAprobadas();
		
	}
	
	public void cargarListaTesisPorAprobar(){
		setListTesis(sustentarTesisService.cargarListaTesisPorAprobar());
	}
	
	public void cargarListaTesisAprobadas(){
		setListTesis(sustentarTesisService.cargarListaTesisAprobadas());
	}
	
	public String registrarSustentacionTesis(){
	    TesisUtil.subirASesion("tesis", selectedTesis);
		return null;
	}
	
	public String programarSustentacionTesis(){
	    TesisUtil.flashScope("tesis", selectedTesis);
		//return "OficiarJuradoEvaluador?faces-redirect=true";
	    return null;
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

	public SustentarTesisService getSustentarTesisService() {
		return sustentarTesisService;
	}

	public void setSustentarTesisService(SustentarTesisService sustentarTesisService) {
		this.sustentarTesisService = sustentarTesisService;
	}
	
	
	
}
