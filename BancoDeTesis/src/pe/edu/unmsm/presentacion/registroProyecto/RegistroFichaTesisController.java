package pe.edu.unmsm.presentacion.registroProyecto;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.servicio.RegistroProyectoTesisService;
import pe.edu.unmsm.util.TesisUtil;


@ViewScoped
@ManagedBean(name="registroFichaTesis")
public class RegistroFichaTesisController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Ficha ficha;
	
	@ManagedProperty("#{registroProyectoTesisService}")
	RegistroProyectoTesisService registroProyectoTesisService;	
	
	public RegistroFichaTesisController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void cargarDatos(){
		ficha=(Ficha)TesisUtil.obtenerDeSesion("ficha");
		
	}
	
	public String generarRDInscripcion(){
		
		registroProyectoTesisService.generarRDInscripcion(ficha);		
		
		return "ListarFichasTesisAprobadas?faces-redirect=true";
		
	}
	
	public String registroFichaTesis(){
		

		return "Inicio?faces-redirect=true";
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public RegistroProyectoTesisService getRegistroProyectoTesisService() {
		return registroProyectoTesisService;
	}

	public void setRegistroProyectoTesisService(
			RegistroProyectoTesisService registroProyectoTesisService) {
		this.registroProyectoTesisService = registroProyectoTesisService;
	}
	
	
	
}
