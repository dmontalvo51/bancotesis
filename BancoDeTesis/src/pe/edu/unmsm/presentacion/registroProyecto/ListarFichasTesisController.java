package pe.edu.unmsm.presentacion.registroProyecto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.ProyectoTesis;
import pe.edu.unmsm.negocio.servicio.RegistroProyectoTesisService;
import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name = "listarFichasTesis")
public class ListarFichasTesisController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9054693765543258216L;
	private List<Ficha> listFicha = new ArrayList<Ficha>();;
	private Ficha selectedFicha;
	
	
	@ManagedProperty("#{registroProyectoTesisService}")
	private RegistroProyectoTesisService registroProyectoTesisService;
	
	
	public ListarFichasTesisController() {
		TesisUtil.escribir("Constructor");
		
	}
	//llama a este metodo despues del constructor
	
	@PostConstruct
	public void cargarDatos(){
		TesisUtil.escribir("Cargar Datos");
		setListFicha(llenarTabla());
	}
	
	
	private List<Ficha> llenarTabla() {
			return registroProyectoTesisService.cargarListaFichasInscritas();
	}
	
	public String revisarProyectoTesis(){
		return "InformeProyectoTesis";
	}
	
	
	public RegistroProyectoTesisService getRegistroProyectoTesisService() {
		return registroProyectoTesisService;
	}

	public void setRegistroProyectoTesisService(
			RegistroProyectoTesisService registroProyectoTesisService) {
		this.registroProyectoTesisService = registroProyectoTesisService;
	}

	public List<Ficha> getListFicha() {
		return listFicha;
	}

	public void setListFicha(List<Ficha> listFicha) {
		this.listFicha = listFicha;
	}

	public Ficha getSelectedFicha() {
		return selectedFicha;
	}

	public void setSelectedFicha(Ficha selectedFicha) {
		this.selectedFicha = selectedFicha;
	}

}
