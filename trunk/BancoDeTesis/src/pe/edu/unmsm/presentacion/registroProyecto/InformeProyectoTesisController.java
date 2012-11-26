package pe.edu.unmsm.presentacion.registroProyecto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.InformeProyectoTesis;
import pe.edu.unmsm.negocio.modelo.ProyectoTesis;
import pe.edu.unmsm.negocio.modelo.Usuario;
import pe.edu.unmsm.negocio.servicio.RegistroProyectoTesisService;
import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name = "informeProyectoTesis")
public class InformeProyectoTesisController implements Serializable {

	private static final long serialVersionUID = 9054693765543258216L;
	private String ipt_observaciones;
	private String ipt_sugerencias;
	private String opinion;
	private Ficha ficha;
	private InformeProyectoTesis ipt;
	ResourceBundle resourceBundle;

	public InformeProyectoTesisController() {
		super();
		ficha = new Ficha();
		ipt = new InformeProyectoTesis();
	}

	@ManagedProperty("#{registroProyectoTesisService}")
	private RegistroProyectoTesisService registroProyectoTesisService;

	@PostConstruct
	public void cargarDatos() {
		ficha = (Ficha) TesisUtil.obtenerDeSesion("ficha");

	}

	public String guardarInformeProyecto() {

		
		ipt.setCodigoFicha(ficha.getCodigo());
		ipt.setCodigoDocente(((Usuario) TesisUtil.obtenerDeSesion("usuario"))
				.getCuenta());
		ipt.setOpinion(Integer.valueOf(opinion));
		ipt.setObservaciones(ipt_observaciones);
		ipt.setSugerencias(ipt_sugerencias);

		registroProyectoTesisService.insertarInformeProyectoTesis(ipt);

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.setKeepMessages(true);

		if (ipt != null) {
			if (ipt.isInformeCreado()) {
				if (ipt.isActaGenerada()) {
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage("Informe creado","Se creo el informe nro."
							+ " "+ipt.getCodigoInformeProyecto()));
										
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage("Acta de evaluacion creada"," Se creo el acta de evaluación nro."
									+" "+ ipt.getNroActaEvaluacion()));
					return "ListarFichasProyectoDeTesis.xhtml?faces-redirect=true";
				} else {
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage("Informe creado","Se creo el informe nro."+ipt.getCodigoInformeProyecto()));
					return "ListarFichasProyectoDeTesis.xhtml?faces-redirect=true";
				}
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage("msgInformeNoCreado","msgInformeNoCreadoDetalleMax2"));
										
				return "ListarFichasProyectoDeTesis.xhtml?faces-redirect=true";
			}
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage("msgInformeNoCreado","msgInformeNoCreadoDetalleError"));
									
			return "ListarFichasProyectoDeTesis.xhtml?faces-redirect=true";
		}

	}

	public String atrasPage() {
		// TesisUtil.flashScope("ficha", selectedFicha);
		return "ListarFichasProyectoDeTesis";
	}

	public String escribir(String msg, String etiqueta) {
		return FacesContext.getCurrentInstance().getApplication()
			.getResourceBundle(FacesContext.getCurrentInstance(),msg).getString(etiqueta);
	
	}

	public String cancelarInformePT() {
		return "ListarFichasProyectoDeTesis?faces-redirect=true";
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



	public String getIpt_observaciones() {
		return ipt_observaciones;
	}

	public void setIpt_observaciones(String ipt_observaciones) {
		this.ipt_observaciones = ipt_observaciones;
	}

	public String getIpt_sugerencias() {
		return ipt_sugerencias;
	}

	public void setIpt_sugerencias(String ipt_sugerencias) {
		this.ipt_sugerencias = ipt_sugerencias;
	}

	public InformeProyectoTesis getIpt() {
		return ipt;
	}

	public void setIpt(InformeProyectoTesis ipt) {
		this.ipt = ipt;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

}
