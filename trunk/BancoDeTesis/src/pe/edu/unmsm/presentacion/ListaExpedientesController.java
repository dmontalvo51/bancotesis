package pe.edu.unmsm.presentacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import pe.edu.unmsm.modelo.Expediente;
import pe.edu.unmsm.negocio.ExpedientesService;

@RequestScoped
@ManagedBean(name="listaExpedientes")
public class ListaExpedientesController{
	
	/*Atributos*/
	@ManagedProperty(value="#{expedientesService}")
	private ExpedientesService expedientesService;
	private List<Expediente> listaExpedientes;
	

	/*Contructor*/
	public ListaExpedientesController() {
		listaExpedientes=new ArrayList<Expediente>();
	}

	
	/*Metodos*/
	
	
	
	/*Encampsulamientos*/
	public ExpedientesService getExpedientesService() {
		return expedientesService;
	}
	
	public void setExpedientesService(ExpedientesService expedientesService) {
		this.expedientesService = expedientesService;
	}

	public List<Expediente> getListaExpedientes() {
		return expedientesService.cargarTramites();
		//return listaExpedientes;
	}

	public void setListaExpedientes(List<Expediente> listaExpedientes) {
		this.listaExpedientes = listaExpedientes;
	}
	
	

}
