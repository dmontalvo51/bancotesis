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
import pe.edu.unmsm.negocio.modelo.Usuario;
import pe.edu.unmsm.negocio.servicio.RegistroProyectoTesisService;
import pe.edu.unmsm.negocio.servicio.RevisionBorradorTesisService;
import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name = "generarActaObservacion")
public class GenerarActaObservacionController implements Serializable {

	private static final long serialVersionUID = 9054693765543258216L;
	private int observacion;
	private BorradorTesis borrador;

	private DetalleActaObservacion dao;
	private List<DetalleActaObservacion> listDAO = new ArrayList<DetalleActaObservacion>();
	private ActaObservacion ao;
	private int linea = 0;
	private String observaciones;
	private int nroPagina;
	private String estado;

	public GenerarActaObservacionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManagedProperty("#{revisionBorradorTesisService}")
	private RevisionBorradorTesisService revisionBorradorTesisService;

	@PostConstruct
	public void cargarDatos() {
		borrador = (BorradorTesis) TesisUtil.obtenerDeSesion("borrador");
		dao = new DetalleActaObservacion();
		ao = new ActaObservacion();
		ao.setCodigoBorrador(borrador.getCodigo());
		// ao.setVersion(borrador.getVersion());
		try {
			revisionBorradorTesisService.generarNroAO(ao);
		} catch (Exception e) {
			TesisUtil.escribir("ERROR no se genero ao!");
			e.printStackTrace();

		}
		// estado="1";
		// dao.setLinea(1);
		// dao.
		// InputText nropag=(InputText)nroPagina;
	}

	public String atrasPage() {
		// TesisUtil.flashScope("ficha", selectedFicha);
		return "ListarFichasProyectoDeTesis";
	}

	public String cancelarInformePT() {
		return "ListarFichasProyectoDeTesis?faces-redirect=true";
	}

	public void insertarObservacion() {

		for (int i = 0; i < listDAO.size(); i++) {
			revisionBorradorTesisService.insertarObservacion(listDAO.get(i));
		}

	}

	public void limpiar() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		UIViewRoot uiViewRoot = facesContext.getViewRoot();
		HtmlInputText txtpagina = null;
		txtpagina = (HtmlInputText) uiViewRoot
				.findComponent("formAO:nroPagina");
		txtpagina.setValue(null);

		/*
		 * inputText = (HtmlInputText)
		 * uiViewRoot.findComponent("formUsuario:inputAccount");
		 * inputText.setValue(null); inputText.setSubmittedValue(null);
		 * inputText.setLocalValueSet(false); inputText = (HtmlInputText)
		 * uiViewRoot.findComponent("formUsuario:inputNewPassword");
		 * inputText.setValue(null); inputText.setSubmittedValue(null);
		 * inputText.setLocalValueSet(false); inputText = (HtmlInputText)
		 * uiViewRoot.findComponent("formUsuario:inputConfirmPassword");
		 * inputText.setValue(null); inputText.setSubmittedValue(null);
		 * inputText.setLocalValueSet(false); inputText = (HtmlInputText)
		 * uiViewRoot.findComponent("formUsuario:inputConfirmPassword");
		 * inputText.setValue(null); inputText.setSubmittedValue(null);
		 * inputText.setLocalValueSet(false);
		 */
		// UISelectOne inputSelectOne = null;
		// inputSelectOne = (UISelectOne)
		// uiViewRoot.findComponent("formUsuario:inputSelectEmpresa");

	}

	public void agregarObservacion() {
		linea = linea + 1;
		dao.setLinea(getLinea());
		dao.setAo_codigo(ao.getCodigo());
		// dao.setObservaciones(getObservaciones());
		// dao.setNroPagina(getNroPagina());
		listDAO.add(dao);
		dao = new DetalleActaObservacion();
		// limpiar();
	}

	public String generarActaObservacion() {
		TesisUtil.escribir("EN EL METODO GUARDAR");

		try {
			ao.setCodigoBorrador(borrador.getCodigo());
			ao.setCodigoDocente(((Usuario) TesisUtil.obtenerDeSesion("usuario"))
					.getCuenta());
			if (estado == "") {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage("No se creo Acta de Observacion",
								"Elija si hay o no Observaciones"));
				return "";
			} else {
				ao.setEstado(Integer.valueOf(estado));
				revisionBorradorTesisService.insertarActaObservacion(ao);
				insertarObservacion();
			}

		} catch (Exception e) {
			TesisUtil.escribir("ERROR no se genero NRO DE ACTA OBSERVACION!");
			e.printStackTrace();
		}
		
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

		if (ao != null) {
			if (ao.isActaCreada()) {
				TesisUtil.escribir("Acta creada");
				FacesContext.getCurrentInstance().addMessage(
						"Acta Creada",new FacesMessage("Se creo el acta de observacion nro."+ ao.getCodigo()));

			} else {
				TesisUtil.escribir("Ya existe dos Actas");
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("Acta no creada", "Ya existe dos Actas"));
				return "";
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage("No se creo Acta de Observacion",
							"No se creo el Acta de observacion. Por favor, contacte con el administrador"));
			return "";
		}

		return "ListarBorradorTesis.xhtml?faces-redirect=true";
	}

	public String cancelarObservacion() {
		return "Inicio.xhtml?faces-redirect=true";

	}

	public RevisionBorradorTesisService getRevisionBorradorTesisService() {
		return revisionBorradorTesisService;
	}

	public void setRevisionBorradorTesisService(
			RevisionBorradorTesisService revisionBorradorTesisService) {
		this.revisionBorradorTesisService = revisionBorradorTesisService;
	}

	public BorradorTesis getBorrador() {
		return borrador;
	}

	public void setBorrador(BorradorTesis borrador) {
		this.borrador = borrador;
	}

	public DetalleActaObservacion getDao() {
		return dao;
	}

	public void setDao(DetalleActaObservacion dao) {
		this.dao = dao;
	}

	public List<DetalleActaObservacion> getListDAO() {
		return listDAO;
	}

	public void setListDAO(List<DetalleActaObservacion> listDAO) {
		this.listDAO = listDAO;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}

	public ActaObservacion getAo() {
		return ao;
	}

	public void setAo(ActaObservacion ao) {
		this.ao = ao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getNroPagina() {
		return nroPagina;
	}

	public void setNroPagina(int nroPagina) {
		this.nroPagina = nroPagina;
	}

	public int getObservacion() {
		return observacion;
	}

	public void setObservacion(int observacion) {
		this.observacion = observacion;
	}

}
