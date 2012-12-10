package pe.edu.unmsm.presentacion.revisionBorrador;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import pe.edu.unmsm.negocio.modelo.BorradorTesis;
import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.Usuario;
import pe.edu.unmsm.negocio.servicio.RevisionBorradorTesisService;
import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name = "levantarObservaciones")
public class LevantarObservacionesController implements Serializable {

	private static final long serialVersionUID = 9054693765543258216L;

	private BorradorTesis borrador;
	private Ficha db;

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

		Usuario usuario = (Usuario) TesisUtil.obtenerDeSesion("usuario");
		borrador = new BorradorTesis();
		//Usuario usuario = (Usuario) TesisUtil.obtenerDeSesion("usuario");
		//borrador.setCodigoBachiller("08200075");

		if (origen.equals("ListarProyectosPorAprobar"))
			// System.out.println("entro");
			setDb(llenarTabla());
		else if (origen.equals("ListarProyectosTesis"))
			setDb(llenarTabla());
		else if (origen.equals("LevantarObservaciones"))
			//Usuario usuario = (Usuario) TesisUtil.obtenerDeSesion("usuario");
			try{
			borrador.setNombreAsesor(usuario.getNombres()+" "+usuario.getApellidos());
		
			}catch(Exception e){
			System.out.println("Error no encontro al asesor");
			}

	}

	public Ficha llenarTabla() {
		Usuario usuario = (Usuario) TesisUtil.obtenerDeSesion("usuario");
		// borrador.setCodigoBachiller("08200075");
		// borrador.setTitulo("SE");
		// borrador.setLineaInvestigacion("lineaInvestigacion1");
		// borrador.setNomBachiller("Apolinario Ballico Johnny");
		return revisionborradorTesisService.cargarBorrador(usuario.getCuenta());
		// return borrador;
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

	public Ficha getDb() {
		return db;
	}

	public void setDb(Ficha db) {
		this.db = db;
	}

}
