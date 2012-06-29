package pe.edu.unmsm.presentacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import pe.edu.unmsm.modelo.Expediente;
import pe.edu.unmsm.negocio.ExpedienteService;


@ViewScoped
@ManagedBean(name="listaExpedientes")
public class ListaExpedientesController{
	
	/*Atributos*/

	private List<Expediente> listaExpedientes;
	

	/*Contructor*/
	public ListaExpedientesController() {
		listaExpedientes=new ArrayList<Expediente>();
	}
	
	
	
	/*Metodos*/
	
	
	
	/*Encampsulamientos*/
	
	public List<Expediente> getListaExpedientes() {
//		ExpedienteService expedientesService=new ExpedienteService();
//		return expedientesService.cargarTramites();
		return listaExpedientes;
	}

	public void setListaExpedientes(List<Expediente> listaExpedientes) {
		this.listaExpedientes = listaExpedientes;
	}
	
	

}
