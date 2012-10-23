package pe.edu.unmsm.integracion.dao;

import java.util.List;

import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.InformeProyectoTesis;

public interface InformeProyectoTesisMapper {
	
public List<Ficha> RegistrarFichas();
public List<InformeProyectoTesis> cargarInformeProyectoTesis();
	
}