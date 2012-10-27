package pe.edu.unmsm.integracion.dao;

import java.util.List;

import pe.edu.unmsm.negocio.modelo.Docente;

public interface DocenteMapper {
	
	public List<Docente> cargarListaDocentesPorLinea(int lineaId);

}
