package pe.edu.unmsm.integracion;

import java.util.List;

import pe.edu.unmsm.modelo.Tesis;
public interface TesisMapper {
	
public List<Tesis> RegistrarTesis();
public List<Tesis> cargarListaTesisInscritas();
	
}