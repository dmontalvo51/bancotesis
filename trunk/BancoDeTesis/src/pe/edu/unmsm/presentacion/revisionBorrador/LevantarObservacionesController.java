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

import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.Tesis;
import pe.edu.unmsm.negocio.modelo.InformeProyectoTesis;
import pe.edu.unmsm.negocio.modelo.ProyectoTesis;
import pe.edu.unmsm.negocio.modelo.Usuario;
import pe.edu.unmsm.negocio.modelo.DetalleActaObservacion;
import pe.edu.unmsm.negocio.servicio.RevisionBorradorTesisService;
import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name = "levantarObservaciones")
public class LevantarObservacionesController implements Serializable {
	
	private static final long serialVersionUID = 9054693765543258216L;
	
	private DetalleActaObservacion dao;
	private List<DetalleActaObservacion> listDAO = new ArrayList<DetalleActaObservacion>();

	
	public LevantarObservacionesController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManagedProperty("#{revisionBorradorTesisService}")
	private RevisionBorradorTesisService revisionborradorTesisService;
	
	@PostConstruct
	public void cargarDatos(){
		//tesis=(Tesis)TesisUtil.obtenerDeSesion("tesis");
		//DetalleActaObservacion dao=new DetalleActaObservacion();
	
	}
	
	public String atrasPage(){
		//TesisUtil.flashScope("ficha", selectedFicha);
		return "ListarFichasProyectoDeTesis";
	}

	public void handleFileUpload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
	

	
}
