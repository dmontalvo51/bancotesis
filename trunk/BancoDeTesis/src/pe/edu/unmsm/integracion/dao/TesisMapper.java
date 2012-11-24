package pe.edu.unmsm.integracion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import pe.edu.unmsm.negocio.modelo.Tesis;
public interface TesisMapper {
	
public List<Tesis> RegistrarTesis();

public List<Tesis> cargarListaTesis();

public List<Tesis> cargarListaBorradorTesis();
	
}