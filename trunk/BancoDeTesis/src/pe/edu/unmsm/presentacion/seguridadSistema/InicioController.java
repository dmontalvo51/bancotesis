package pe.edu.unmsm.presentacion.seguridadSistema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.collections.map.HashedMap;
import org.primefaces.model.StreamedContent;

import pe.edu.unmsm.negocio.modelo.DatoMaestro;
import pe.edu.unmsm.negocio.modelo.Expediente;
import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.OpcionMenu;
import pe.edu.unmsm.negocio.modelo.Respuesta;
import pe.edu.unmsm.negocio.servicio.SeguridadService;
import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name = "inicio")
public class InicioController implements Serializable {

	private static final long serialVersionUID = -9091669945071307902L;

	StreamedContent archivo;
	private OpcionMenu om;
	private List<DatoMaestro> listaPerfiles;
	private List<DatoMaestro> listaPerfilesSeleccionados;
	
	@ManagedProperty("#{seguridadService}")
	private SeguridadService seguridadService;
	
	public InicioController() {
		super();
		om=new OpcionMenu();
		listaPerfiles=new ArrayList<DatoMaestro>();
		// TODO Auto-generated constructor stub
	}

	public String crearExpediente() {

		Respuesta respuesta=new Respuesta();
		
		if (respuesta.getEstado()==Respuesta.OK){
			if(respuesta.getMensaje()!=null)
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Crear expediente",respuesta.getMensaje())); 
			
			return "IngresarFicha";
		}else{
			
			return null;
		}

	}
	
	public void imprimirFichaTesis(){
		TesisUtil.escribir("Imprimiendo Ficha");
		Map<String,Object> parametros=new HashMap<String, Object>();
		parametros.put("Ficha",new Ficha());
		archivo=TesisUtil.generarReporte("FichaInscripcionProyectoTesis",parametros);		
	}
	
	public void ingresarOpcionMenu(){
		listaPerfiles=seguridadService.cargarPerfiles();
	}
	
	public void guardarOpcionMenu(){
		
		
	}

	public StreamedContent getArchivo() {
		return archivo;
	}

	public void setArchivo(StreamedContent archivo) {
		this.archivo = archivo;
	}
	
	
	public OpcionMenu getOm() {
		return om;
	}

	public void setOm(OpcionMenu om) {
		this.om = om;
	}

	public List<DatoMaestro> getListaPerfiles() {
		return listaPerfiles;
	}

	public void setListaPerfiles(List<DatoMaestro> listaPerfiles) {
		this.listaPerfiles = listaPerfiles;
	}

	public List<DatoMaestro> getListaPerfilesSeleccionados() {
		return listaPerfilesSeleccionados;
	}

	public void setListaPerfilesSeleccionados(
			List<DatoMaestro> listaPerfilesSeleccionados) {
		this.listaPerfilesSeleccionados = listaPerfilesSeleccionados;
	}

	public SeguridadService getSeguridadService() {
		return seguridadService;
	}

	public void setSeguridadService(SeguridadService seguridadService) {
		this.seguridadService = seguridadService;
	}


}
