package pe.edu.unmsm.presentacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import pe.edu.unmsm.modelo.ProyectoTesis;

@ViewScoped
@ManagedBean(name = "listaProyectoTesis")
public class ListaProyectoTesisController {

	private List<ProyectoTesis> listProyectoTesis;
	private ProyectoTesis selectedProyectoTesis;

	public ListaProyectoTesisController() {
		listProyectoTesis = new ArrayList<ProyectoTesis>();
		llenartabla(listProyectoTesis);
		
	}

	private void llenartabla(List<ProyectoTesis> lista) {
		
			lista.add(new ProyectoTesis("026-FISI-2012","titulo1","linea1","Jorge",""));
			lista.add(new ProyectoTesis("027-FISI-2012","titulo2","linea2","Diego",""));
			lista.add(new ProyectoTesis("028-FISI-2012","titulo3","linea3","Karina",""));
			lista.add(new ProyectoTesis("029-FISI-2012","titulo4","linea4","Johnny",""));
	}


	public void setSelectedProyectoTesis(ProyectoTesis selectedProyectoTesis) {
		this.selectedProyectoTesis = selectedProyectoTesis;
	}

	public ProyectoTesis getSelectedProyectoTesis() {
		return selectedProyectoTesis;
	}

	public List<ProyectoTesis> getListProyectoTesis() {
		return listProyectoTesis;
	}

	public void setListProyectoTesis(List<ProyectoTesis> listProyectoTesis) {
		this.listProyectoTesis = listProyectoTesis;
	}

}
