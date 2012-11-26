package pe.edu.unmsm.presentacion.registroProyecto;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.Respuesta;
import pe.edu.unmsm.negocio.servicio.RegistroProyectoTesisService;
import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name = "registroFichaTesis")
public class RegistroFichaTesisController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Ficha ficha;

	@ManagedProperty("#{registroProyectoTesisService}")
	RegistroProyectoTesisService registroProyectoTesisService;

	public RegistroFichaTesisController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void cargarDatos() {
		ficha = (Ficha) TesisUtil.obtenerDeSesion("ficha");
		ficha.setResolucionDirectoralAprobada(1);

	}

	public String generarRDInscripcion() {

		Respuesta r = registroProyectoTesisService.generarRDInscripcion(ficha);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.setKeepMessages(true);

		if (r.getEstado() == Respuesta.OK) {
			if (ficha != null) {
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(
										"RD inscripción",
										" Se generó la resolución directoral nro."
												+ " "
												+ ficha.getCodigoRDinscripcion()));

				return "ListarFichasTesisAprobadas?faces-redirect=true";
			} else {
				FacesContext
						.getCurrentInstance()
						.addMessage(
								null,
								new FacesMessage(
										"RD Inscripción",
										" Ocurrió un error al genera la RD para inscribir el proyecto de tesis"
												+ " "
												+ ficha.getCodigoRDinscripcion()));

				return null;
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage("RD Inscripción",
							" Ocurrió un error al genera la RD para inscribir el proyecto de tesis"
									+ " " + ficha.getCodigoRDinscripcion()));

			return null;

		}

	}

	public String registrarProyectoTesis() {

		TesisUtil.escribir("El decano va a aprobar la tesis!!");

		Respuesta r = registroProyectoTesisService
				.inscribirProyectoDeTesis(ficha);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.setKeepMessages(true);

		if (r.getEstado() == Respuesta.OK) {

			if (ficha.getResolucionDirectoralAprobada() == 1) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage("Inscripcion de proyecto de tesis",
								" Se registro la ficha de tesis y se genero la tesis nro."
										+ " " + ficha.getCodigoTesis()));
				return "ListarFichasTesisPorRegistrar?faces-redirect=true";
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage("Inscripcion de proyecto de tesis",
								"Se rechazó el proyecto de tesis de expediente "+ficha.getNroExpediente()));
				return "ListarFichasTesisPorRegistrar?faces-redirect=true";
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage("Inscripcion de proyecto de tesis",
							" Ocurrió un error al aprobar la ficha."));
			return null;
		}
	}

	public String cancelar() {
		return "ListarFichasTesisAprobadas?faces-redirect=true";
	}

	public String cancelarRegistro() {
		return "ListarFichasTesisPorRegistrar?faces-redirect=true";
	}

	public String registroFichaTesis() {

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
