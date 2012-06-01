package pe.edu.unmsm.integracion;

import java.util.List;

import pe.edu.unmsm.modelo.Expediente;

public interface ExpedientesMapper {
	
	public List<Expediente> cargarTramites();
	
	public int insertarTramite(Expediente tramite);

}
