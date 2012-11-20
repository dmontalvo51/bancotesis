package pe.edu.unmsm.presentacion.registroProyecto;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import pe.edu.unmsm.negocio.modelo.ActaSustentacion;
import pe.edu.unmsm.negocio.modelo.Docente;
import pe.edu.unmsm.negocio.modelo.Expediente;
import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.LineaInvestigacion;
import pe.edu.unmsm.negocio.modelo.Usuario;
import pe.edu.unmsm.negocio.servicio.RegistroProyectoTesisService;
import pe.edu.unmsm.negocio.servicio.SeguridadService;

import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name="llenarFicha")
public class LlenarFichaController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Datos maestros
	private List<LineaInvestigacion> listaLineasInvestigacion=new ArrayList<LineaInvestigacion>();
	private List<LineaInvestigacion> listaSubLineasInvestigacion=new ArrayList<LineaInvestigacion>();
	private List<Docente> listaAsesores=new ArrayList<Docente>();
	
	//Datos Ficha de inscripción
	
	private Ficha ficha=new Ficha();
	
	private String codigoAsesor;
	private int codigoLinea;
	private int codigoSubLinea;
	
	//Services
	@ManagedProperty("#{registroProyectoTesisService}")
	RegistroProyectoTesisService registroProyectoTesisService;	
	
	public LlenarFichaController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init(){
		listaLineasInvestigacion=registroProyectoTesisService.cargarLineasInvestigacion();
		listaSubLineasInvestigacion=registroProyectoTesisService.cargarSubLineasInvestigacion(1);
		listaAsesores=registroProyectoTesisService.cargarListaDocentesPorLinea(1);
	}
	
	public void seleccionaLinea(){
		listaSubLineasInvestigacion=registroProyectoTesisService.cargarSubLineasInvestigacion(codigoLinea);
	}
	
	public void seleccionaSubLinea(){
		listaAsesores=registroProyectoTesisService.cargarListaDocentesPorLinea(codigoSubLinea);
	}
	
	
	public String registrarFicha() {

		Usuario usuario = (Usuario) TesisUtil.obtenerDeSesion("usuario");

		ficha.setCodigoLineaInvestigacion(codigoSubLinea);
		ficha.setCodigoBachiller(usuario.getCuenta());
			
		registroProyectoTesisService.insertarFichaProyectoTesis(ficha);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.setKeepMessages(true);

		if (ficha != null) {
			FacesContext.getCurrentInstance().addMessage(
					"Ficha creada",
					new FacesMessage("Ficha creada",
							"Se creo la ficha de inscripción nro. "
									+ ficha.getCodigo()));
			return "Inicio.xhtml?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage("Ficha creada",
					new FacesMessage("Error al crear la ficha"));
			return null;
		}
		
	}
	
	public void revisarFicha(){

		Usuario usuario=(Usuario)TesisUtil.obtenerDeSesion("usuario");
		
		ficha.setCodigoLineaInvestigacion(codigoSubLinea);
		ficha.setCodigoBachiller(usuario.getCuenta());
			
		//registroProyectoTesisService.insertarInformeProyectoTesis(ficha);
		
		registroProyectoTesisService.generarDocumentoInformeProyectoTesis(ficha);
		
				
	}
	
	
	
	public List<LineaInvestigacion> getListaLineasInvestigacion() {
		return listaLineasInvestigacion;
	}
	public void setListaLineasInvestigacion(
			List<LineaInvestigacion> listaLineasInvestigacion) {
		this.listaLineasInvestigacion = listaLineasInvestigacion;
	}
	public List<LineaInvestigacion> getListaSubLineasInvestigacion() {
		return listaSubLineasInvestigacion;
	}
	public void setListaSubLineasInvestigacion(
			List<LineaInvestigacion> listaSubLineasInvestigacion) {
		this.listaSubLineasInvestigacion = listaSubLineasInvestigacion;
	}
	public List<Docente> getListaAsesores() {
		return listaAsesores;
	}
	public void setListaAsesores(List<Docente> listaAsesores) {
		this.listaAsesores = listaAsesores;
	}
	
	public RegistroProyectoTesisService getRegistroProyectoTesisService() {
		return registroProyectoTesisService;
	}
	public void setRegistroProyectoTesisService(
			RegistroProyectoTesisService registroProyectoTesisService) {
		this.registroProyectoTesisService = registroProyectoTesisService;
	}
	
	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public String getCodigoAsesor() {
		return codigoAsesor;
	}

	public void setCodigoAsesor(String codigoAsesor) {
		this.codigoAsesor = codigoAsesor;
	}

	public int getCodigoSubLinea() {
		return codigoSubLinea;
	}

	public void setCodigoSubLinea(int codigoSubLinea) {
		this.codigoSubLinea = codigoSubLinea;
	}

	public int getCodigoLinea() {
		return codigoLinea;
	}

	public void setCodigoLinea(int codigoLinea) {
		this.codigoLinea = codigoLinea;
	}

}
