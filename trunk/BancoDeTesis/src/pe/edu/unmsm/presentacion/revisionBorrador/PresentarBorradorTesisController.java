package pe.edu.unmsm.presentacion.revisionBorrador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;

import pe.edu.unmsm.negocio.modelo.ActaObservacion;
import pe.edu.unmsm.negocio.modelo.BorradorTesis;
import pe.edu.unmsm.negocio.modelo.DetalleActaObservacion;
import pe.edu.unmsm.negocio.modelo.Respuesta;
import pe.edu.unmsm.negocio.modelo.Tesis;
import pe.edu.unmsm.negocio.modelo.Usuario;
import pe.edu.unmsm.negocio.servicio.RegistroProyectoTesisService;
import pe.edu.unmsm.negocio.servicio.RevisionBorradorTesisService;
import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name = "presentarBorradorTesis")
public class PresentarBorradorTesisController implements Serializable {

	private static final long serialVersionUID = 9054693765543258216L;
	private Tesis tesis;

	public PresentarBorradorTesisController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManagedProperty("#{revisionBorradorTesisService}")
	private RevisionBorradorTesisService revisionBorradorTesisService;

	@PostConstruct
	public void cargarDatos() {
		tesis = (Tesis) TesisUtil.obtenerDeSesion("tesis");
		Usuario usuario = (Usuario) TesisUtil.obtenerDeSesion("usuario");
		try{
		tesis.setNombreAsesor(usuario.getNombres()+" "+usuario.getApellidos());
		}catch(Exception e){
			System.out.println("Error no encontro al asesor");
		}
	}

	public String cargarAsesor(String nombre){
		return revisionBorradorTesisService.cargarAsesor(nombre);
	}
	public String cancelarPresentarBorrador() {
		return "Inicio.xhtml?faces-redirect=true";

	}

	public RevisionBorradorTesisService getRevisionBorradorTesisService() {
		return revisionBorradorTesisService;
	}

	public void setRevisionBorradorTesisService(
			RevisionBorradorTesisService revisionBorradorTesisService) {
		this.revisionBorradorTesisService = revisionBorradorTesisService;
	}

	public Tesis getTesis() {
		return tesis;
	}

	public void setTesis(Tesis tesis) {
		this.tesis = tesis;
	}


}
