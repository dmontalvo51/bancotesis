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

import org.primefaces.model.UploadedFile;

import pe.edu.unmsm.negocio.modelo.ActaConformidad;
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
	private ActaConformidad ac;
	private String fileBorrador;
	
	private UploadedFile file;  

	public PresentarBorradorTesisController() {
		super();
		ac=new ActaConformidad();
		// TODO Auto-generated constructor stub
	}

	@ManagedProperty("#{revisionBorradorTesisService}")
	private RevisionBorradorTesisService revisionBorradorTesisService;

	@PostConstruct
	public void cargarDatos() {
		tesis = (Tesis) TesisUtil.obtenerDeSesion("tesis");
		Usuario usuario = (Usuario) TesisUtil.obtenerDeSesion("usuario");
		try{
		tesis.setNombreAsesor(usuario.getApellidos()+" "+usuario.getNombres());
		}catch(Exception e){
			System.out.println("Error no encontro al asesor");
		}
	}

	
	public String generarActaConformidad() {
		TesisUtil.escribir("EN EL METODO GUARDAR");
		upload();
		tesis = (Tesis) TesisUtil.obtenerDeSesion("tesis");
		
		ac.setCodigoTesis(tesis.getCodigo());
		ac.setCodigoAsesor(((Usuario) TesisUtil.obtenerDeSesion("usuario"))
					.getCuenta());
		ac.setObservaciones("");
		TesisUtil.escribir(ac.getCodigoTesis());
		revisionBorradorTesisService.insertarActaConformidad(ac);
		
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		
		if(ac.getCodigo()!=null){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Acta de Conformidad creada","Se creo el Acta de Conformidad nro."+ ac.getCodigo()));
		}else{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("No se creo Acta de Conformidad",
							"No se creo el Acta de observacion. Por favor, contacte con el administrador"));
			return "";
		}

	


		return "ListarTesis.xhtml?faces-redirect=true";
	}
	
	
	 public void upload() {  
	    	System.out.println("1");
	        if(file != null) { 
	        	System.out.println("2");
	            FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");  
	            FacesContext.getCurrentInstance().addMessage(null, msg);  
	        }else{
	        	
	        	System.out.println("No sube archivo");
	        } 

	        //return  "ListarTesis?faces-redirect=true";
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


	public ActaConformidad getAc() {
		return ac;
	}


	public void setAc(ActaConformidad ac) {
		this.ac = ac;
	}


	public String getFileBorrador() {
		return fileBorrador;
	}


	public void setFileBorrador(String fileBorrador) {
		this.fileBorrador = fileBorrador;
	}


	public UploadedFile getFile() {
		return file;
	}


	public void setFile(UploadedFile file) {
		this.file = file;
	}

	
}
