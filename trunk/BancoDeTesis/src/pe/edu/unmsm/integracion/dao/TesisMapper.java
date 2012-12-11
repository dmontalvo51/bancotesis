package pe.edu.unmsm.integracion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import pe.edu.unmsm.negocio.modelo.Programacion;
import pe.edu.unmsm.negocio.modelo.Tesis;

public interface TesisMapper {
	
public List<Tesis> RegistrarTesis();

public List<Tesis> cargarListaTesis();

public List<Tesis> cargarListaTesisRegistrados();

public List<Tesis> cargarListaBorradorTesis();

public String cargarAsesor(String nombre);

public List<Tesis> cargarListaTesisPorAprobar() throws Exception;

public List<Tesis> cargarListaTesisAprobadas() throws Exception;

@Options(statementType = StatementType.CALLABLE)
@Update("{CALL sp_registrarSustentacionTesis(#{codigoTesis,mode=IN})}")
public void aprobarTesis(String codigoTesis) throws Exception;


@Options(statementType = StatementType.CALLABLE)
@Update("{CALL sp_programarSustentacionTesis(#{codigoTesis,mode=IN},#{fechaProgramada,mode=IN},#{horaProgramada,mode=IN})}")
public void programarSustentacionTesis(Programacion p) throws Exception;
	
}