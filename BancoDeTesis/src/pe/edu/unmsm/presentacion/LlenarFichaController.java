package pe.edu.unmsm.presentacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import pe.edu.unmsm.modelo.ActaSustentacion;
import pe.edu.unmsm.modelo.Docente;
import pe.edu.unmsm.modelo.Expediente;
import pe.edu.unmsm.modelo.LineaInvestigacion;
import pe.edu.unmsm.modelo.Usuario;
import pe.edu.unmsm.negocio.RegistroProyectoTesisService;
import pe.edu.unmsm.negocio.SeguridadService;

import pe.edu.unmsm.util.TesisUtil;

@ManagedBean(name="llenarFicha")
@ViewScoped
public class LlenarFichaController implements Serializable {
	
	private static final long serialVersionUID = 1248413041290513025L;
	
	//Datos maestros
	private List<LineaInvestigacion> listaLineasInvestigacion;
	private List<LineaInvestigacion> listaSubLineasInvestigacion=new ArrayList<LineaInvestigacion>();
	private List<Docente> listaAsesores=new ArrayList<Docente>();
	
	//Datos Ficha de inscripción
	private String titulo;
	private String resumen;
	private Docente asesor;
	private LineaInvestigacion lineaInvestigacion;
	private LineaInvestigacion subLineaInvestigacion;
	
	//Services
	@ManagedProperty("#{registroProyectoTesisService}")
	RegistroProyectoTesisService registroProyectoTesisService;	
	
	@PostConstruct
	public void init(){
		listaLineasInvestigacion=registroProyectoTesisService.cargarLineasInvestigacion();	
	}
	
	
	public LlenarFichaController() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public Docente getAsesor() {
		return asesor;
	}
	public void setAsesor(Docente asesor) {
		this.asesor = asesor;
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
	public LineaInvestigacion getSubLineaInvestigacion() {
		return subLineaInvestigacion;
	}
	public void setSubLineaInvestigacion(LineaInvestigacion subLineaInvestigacion) {
		this.subLineaInvestigacion = subLineaInvestigacion;
	}
	public RegistroProyectoTesisService getRegistroProyectoTesisService() {
		return registroProyectoTesisService;
	}
	public void setRegistroProyectoTesisService(
			RegistroProyectoTesisService registroProyectoTesisService) {
		this.registroProyectoTesisService = registroProyectoTesisService;
	}


	public LineaInvestigacion getLineaInvestigacion() {
		return lineaInvestigacion;
	}


	public void setLineaInvestigacion(LineaInvestigacion lineaInvestigacion) {
		this.lineaInvestigacion = lineaInvestigacion;
	}	
}
