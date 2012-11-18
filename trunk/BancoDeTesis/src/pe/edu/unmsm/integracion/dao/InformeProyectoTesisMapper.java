package pe.edu.unmsm.integracion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.InformeProyectoTesis;

public interface InformeProyectoTesisMapper {
	
public List<Ficha> RegistrarFichas();
public List<InformeProyectoTesis> cargarInformeProyectoTesis();

@Options(statementType = StatementType.CALLABLE)
@Update("{CALL sp_crearInformeProyectoTesis(#{codigoFicha, mode=IN},#{codigoDocente, mode=IN},#{opinion, mode=IN},#{observaciones, mode=IN},#{sugerencias, mode=IN},#{informeCreado, mode=OUT,javaType=boolean,jdbcType=BOOLEAN},#{codigoInformeProyecto,mode=OUT,javaType=String,jdbcType=VARCHAR},#{actaGenerada, mode=OUT,javaType=boolean, jdbcType=BOOLEAN},#{nroActaEvaluacion,mode=OUT,javaType=String,jdbcType=VARCHAR})}")
public void ingresarInformeProyectoTesis(InformeProyectoTesis ipt) throws Exception;
	
}