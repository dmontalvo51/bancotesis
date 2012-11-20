package pe.edu.unmsm.integracion.dao;

import java.util.List;

import pe.edu.unmsm.negocio.modelo.Tesis;
public interface TesisMapper {
	
public List<Tesis> RegistrarTesis();
public List<Tesis> cargarListaTesisInscritas();
public List<Tesis> cargarListaBorradorTesis();
	
}