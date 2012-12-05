package pe.edu.unmsm.presentacion.revisionBorrador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.unmsm.negocio.modelo.BorradorTesis;

import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.ProyectoTesis;
import pe.edu.unmsm.negocio.modelo.Usuario;
import pe.edu.unmsm.negocio.modelo.DetalleActaObservacion;
import pe.edu.unmsm.negocio.servicio.RevisionBorradorTesisService;
import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name = "levantarObservaciones")
public class LevantarObservacionesController implements Serializable {

	private static final long serialVersionUID = 9054693765543258216L;

	private BorradorTesis borrador;

	// private List<BorradorTesis> listBT = new ArrayList<BorradorTesis>();

	public LevantarObservacionesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManagedProperty("#{revisionBorradorTesisService}")
	private RevisionBorradorTesisService revisionborradorTesisService;

	@PostConstruct
	public void cargarDatos() {
		
		String origen = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestServletPath();
		origen = origen.substring(7, origen.length() - 4);
		TesisUtil.escribir(origen);
		
		if(origen.equals("LevantarObservaciones"))
			//System.out.println("entro");
			setBorrador(llenarTabla());
		else if (origen.equals("ListarProyectosTesis"))
			setBorrador(llenarTabla());
		else if(origen.equals("ListarProyectosPorAprobar"))
			setBorrador(llenarTabla());
		
	}

	private BorradorTesis llenarTabla() {
		//Usuario usuario = (Usuario) TesisUtil.obtenerDeSesion("usuario");
		return revisionborradorTesisService.cargarBorrador("08200172");
	}

	public String atrasPage() {
		// TesisUtil.flashScope("ficha", selectedFicha);
		return "ListarFichasProyectoDeTesis";
	}

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Succesful", event.getFile()
				.getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public BorradorTesis getBorrador() {
		return borrador;
	}

	public void setBorrador(BorradorTesis borrador) {
		this.borrador = borrador;
	}

	public RevisionBorradorTesisService getRevisionborradorTesisService() {
		return revisionborradorTesisService;
	}

	public void setRevisionborradorTesisService(
			RevisionBorradorTesisService revisionborradorTesisService) {
		this.revisionborradorTesisService = revisionborradorTesisService;
	}

}
