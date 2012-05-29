package pe.edu.unmsm.presentacion;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import pe.edu.unmsm.modelo.ActaSustentacion;
import pe.edu.unmsm.negocio.SustentacionService;


@RequestScoped
@ManagedBean(name="registrarActaSustentacion")
public class IngresarActaSustentacionController {
	
	
	@ManagedProperty(value="#{sustentacionService}")
	private SustentacionService sustentacionService;
	
	
	
	public List<ActaSustentacion> listaActas;
	
	
	
	public void cargarListaActas(){
		System.out.println("Ingreso al metodo");
		listaActas=sustentacionService.getListaActaSustentacion();
		if(listaActas!=null){
			for(ActaSustentacion a:listaActas)
				System.out.println(a.getCodigo());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*Metodos de encampsulamiento*/
	
	public SustentacionService getSustentacionService() {
		return sustentacionService;
	}

	public void setSustentacionService(SustentacionService sustentacionService) {
		this.sustentacionService = sustentacionService;
	}
	
	
	
	

}
