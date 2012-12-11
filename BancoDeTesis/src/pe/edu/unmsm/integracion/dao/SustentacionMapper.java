package pe.edu.unmsm.integracion.dao;

import java.util.List;

import pe.edu.unmsm.negocio.modelo.ActaSustentacion;
import pe.edu.unmsm.negocio.modelo.Sustentacion;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;


public interface SustentacionMapper{


	List<ActaSustentacion> selectActaSustentacion();
	
	void insertarActaSustentacion(ActaSustentacion actaSustentacion);
	
	@Options(statementType = StatementType.CALLABLE)
	@Update("{CALL sp_asignarJuradoEvaluador(#{codigoTesis, mode=IN},#{codigoJurado1, mode=IN},#{codigoJurado2, mode=IN},#{asignado, mode=OUT,javaType=boolean,jdbcType=BOOLEAN})}")
	void asignarJuradoEvaluador(Sustentacion sus);
	
}
