package pe.edu.unmsm.presentacion;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import pe.edu.unmsm.modelo.Respuesta;
import pe.edu.unmsm.negocio.ExpedienteService;
import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name = "inicio")
public class InicioController implements Serializable {

	private static final long serialVersionUID = -9091669945071307902L;

	@ManagedProperty("#{expedienteService}")
	private ExpedienteService expedienteService;
	private String codigoExpediente;

	public String crearExpediente() {

		Respuesta respuesta = expedienteService.crearExpediente();
		
		TesisUtil.escribir(respuesta.getMensaje());

		if (respuesta.getEstado() == Respuesta.OK)
			return "IngresarFicha";
		else{
			
			return null;
		}

	}

	public ExpedienteService getExpedienteService() {
		return expedienteService;
	}

	public void setExpedienteService(ExpedienteService expedienteService) {
		this.expedienteService = expedienteService;
	}
}
