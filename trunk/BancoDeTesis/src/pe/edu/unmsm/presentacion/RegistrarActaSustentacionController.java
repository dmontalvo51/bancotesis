package pe.edu.unmsm.presentacion;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pe.edu.unmsm.modelo.ActaSustentacion;
import pe.edu.unmsm.modelo.Expediente;
import pe.edu.unmsm.negocio.SustentacionService;
import pe.edu.unmsm.negocio.ExpedientesService;
import pe.edu.unmsm.util.TesisUtil;


@RequestScoped
@ManagedBean(name="registrarActaSustentacion")
public class RegistrarActaSustentacionController {
	
	
	@ManagedProperty(value="#{sustentacionService}")
	private SustentacionService sustentacionService;
	
	@ManagedProperty(value="#{tramitesService}")
	private ExpedientesService tramitesService;
	
	
	public List<ActaSustentacion> listaActas;
	
	
	
	public void cargarListaActas(){
		List<Expediente> tramites=tramitesService.cargarTramites();
		if(tramites!=null){
			for(Expediente t:tramites)
				TesisUtil.escribir(t.getId()+" "+t.getCodigo());			
		}

	}
	
		
	/*Metodos de encampsulamiento*/
	
	public SustentacionService getSustentacionService() {
		return sustentacionService;
	}

	public void setSustentacionService(SustentacionService sustentacionService) {
		this.sustentacionService = sustentacionService;
	}


	public List<ActaSustentacion> getListaActas() {
		return listaActas;
	}

	public void setListaActas(List<ActaSustentacion> listaActas) {
		this.listaActas = listaActas;
	}


	public ExpedientesService getTramitesService() {
		return tramitesService;
	}


	public void setTramitesService(ExpedientesService tramitesService) {
		this.tramitesService = tramitesService;
	}
	
}
