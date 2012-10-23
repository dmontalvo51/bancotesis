package pe.edu.unmsm.integracion.dao;

import java.util.List;

import pe.edu.unmsm.negocio.modelo.Ficha;
public interface FichasMapper {
	
public List<Ficha> RegistrarFichas();
public List<Ficha> cargarListaFichasInscritas();
	
}