package pe.edu.unmsm.presentacion.revisionBorrador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@RequestScoped
@ManagedBean(name="actaConformidad")
public class ActaConformidadController {
	
	private String resumen;
	private String observaciones;
	
	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public ActaConformidadController() {
		resumen="Resumen de la Tesis. Esta tesis es muy bonita e interesante, y les va a gustar mucho.";
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	
	
	
	
	
}
