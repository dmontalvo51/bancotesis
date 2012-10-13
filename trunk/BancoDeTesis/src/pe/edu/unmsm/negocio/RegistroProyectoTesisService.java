package pe.edu.unmsm.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.unmsm.modelo.LineaInvestigacion;

@Service(value="registroProyectoTesisService")
public class RegistroProyectoTesisService {

	public List<LineaInvestigacion> cargarLineasInvestigacion() {
		
		List<LineaInvestigacion> listaLineasInvestigacion=new ArrayList<LineaInvestigacion>();
		
		listaLineasInvestigacion.add(new LineaInvestigacion(1,"Ingeniería de Software"));
		listaLineasInvestigacion.add(new LineaInvestigacion(2,"Inteligencia artificial"));
		listaLineasInvestigacion.add(new LineaInvestigacion(3,"Sistemas distribuidos"));
		
		return listaLineasInvestigacion;
						
	}

}
