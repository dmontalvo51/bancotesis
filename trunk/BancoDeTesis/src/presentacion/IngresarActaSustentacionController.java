package presentacion;

import java.util.List;

import modelo.ActaSustentacion;
import negocio.SustentacionService;

public class IngresarActaSustentacionController {
	
	private SustentacionService sustentacionService;
	public List<ActaSustentacion> listaActas;
	
	
	
	public void cargarListaActas(){
		listaActas=sustentacionService.getListaActaSustentacion();		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*Metodos de encampsulamiento*/
	
	public SustentacionService getSustentacionService() {
		return sustentacionService;
	}

	public void setSustentacionService(SustentacionService sustentacionService) {
		this.sustentacionService = sustentacionService;
	}
	
	
	
	

}
