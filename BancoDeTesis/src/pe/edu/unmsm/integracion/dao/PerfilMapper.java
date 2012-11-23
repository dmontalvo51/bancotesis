package pe.edu.unmsm.integracion.dao;

import java.util.List;

import pe.edu.unmsm.negocio.modelo.DatoMaestro;

public interface PerfilMapper {
	
	public List<DatoMaestro> cargarPerfiles();
}
