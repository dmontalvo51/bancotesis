package pe.edu.unmsm.integracion.dao;

import java.util.List;

import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import pe.edu.unmsm.negocio.modelo.Ficha;

public interface FichasMapper {

	public List<Ficha> RegistrarFichas();

	public List<Ficha> cargarListaFichasInscritas();

	@Options(statementType = StatementType.CALLABLE)
	@Update("{CALL sp_crearFichaTesis(#{codigoBachiller, mode=IN},#{codigoAsesor, mode=IN},#{codigoLineaInvestigacion, mode=IN},#{titulo, mode=IN},#{resumen, mode=IN},#{ruta, mode=OUT,javaType=String},#{nroExpediente, mode=OUT,javaType=String, jdbcType=VARCHAR},#{codigo, mode=OUT,javaType=String, jdbcType=VARCHAR})}")
	public void insertarFichaProyectoTesis(Ficha ficha);
}