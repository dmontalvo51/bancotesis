package pe.edu.unmsm.integracion.dao;

import java.util.List;

import pe.edu.unmsm.negocio.modelo.LineaInvestigacion;

public interface LineaInvestigacionMapper {
	
	public List<LineaInvestigacion> cargarLineasInvestigacion();
	
	public List<LineaInvestigacion> cargarSubLineasInvestigacion(int idLinea);

}
