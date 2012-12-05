package pe.edu.unmsm.integracion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import pe.edu.unmsm.negocio.modelo.ActaObservacion;
import pe.edu.unmsm.negocio.modelo.BorradorTesis;
import pe.edu.unmsm.negocio.modelo.DetalleActaObservacion;
public interface BorradorTesisMapper {
	
public List<BorradorTesis> cargarListaBorradorTesis();

public void ingresarDetalleObservacion(DetalleActaObservacion dao);

@Options(statementType = StatementType.CALLABLE)
@Update("{CALL sp_crearActaObservacion(#{codigoBorrador, mode=IN},#{codigoDocente, mode=IN},#{estado, mode=IN},#{actaCreada, mode=OUT,javaType=boolean,jdbcType=BOOLEAN},#{codigo, mode=OUT,javaType=String,jdbcType=VARCHAR},#{actaAprobada, mode=OUT,javaType=boolean,jdbcType=BOOLEAN})}")
public void insertarActaObservacion(ActaObservacion ao) throws Exception;

//`sp_crearActaObservacion`(IN `codigo_borrador` VARCHAR(20), IN `codigo_docente` VARCHAR(20), IN `estado` INT,OUT `actaCreado` BOOLEAN, OUT `codigo_ao` VARCHAR(20), OUT `actaAprobada` BOOLEAN)

@Options(statementType = StatementType.CALLABLE)
@Update("{CALL sp_generarNroAO(#{codigoBorrador, mode=IN},#{codigo, mode=OUT,javaType=String,jdbcType=VARCHAR})}")
public void generarNroAO(ActaObservacion ao) throws Exception;
	
}