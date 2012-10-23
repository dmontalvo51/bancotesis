package pe.edu.unmsm.presentacion.sustentacionTesis;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pe.edu.unmsm.negocio.modelo.ActaSustentacion;
import pe.edu.unmsm.negocio.modelo.Expediente;

import pe.edu.unmsm.util.TesisUtil;


@RequestScoped
@ManagedBean(name="registrarActaSustentacion")
public class RegistrarActaSustentacionController {
	
		
	public List<ActaSustentacion> listaActas;
	
	
	
	public void cargarListaActas(){
		
		
	}
	
		
	/*Metodos de encampsulamiento*/
	
	

	public List<ActaSustentacion> getListaActas() {
		return listaActas;
	}

	public void setListaActas(List<ActaSustentacion> listaActas) {
		this.listaActas = listaActas;
	}


	
}
