package pe.edu.unmsm.integracion.dao;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import pe.edu.unmsm.negocio.modelo.Ficha;

public interface RDInscripcionMapper {
	
	@Options(statementType = StatementType.CALLABLE)
	@Update("{CALL sp_generarRDInscripcion(#{codigo, mode=IN},#{codigoRDinscripcion, mode=OUT,javaType=String,jdbcType=VARCHAR},#{rutaRDinscripcion, mode=OUT,javaType=String, jdbcType=VARCHAR})}")
	public void generarRDInscripcion(Ficha ficha) throws Exception;
	
	@Options(statementType = StatementType.CALLABLE)
	@Update("{CALL sp_registroProyectoTesis(#{codigoRDinscripcion,mode=IN},#{resolucionDirectoralAprobada,mode=IN},#{codigoTesis, mode=OUT,javaType=String,jdbcType=VARCHAR})}")
	public void  inscribirProyectoDeTesis(Ficha ficha) throws Exception;

}
