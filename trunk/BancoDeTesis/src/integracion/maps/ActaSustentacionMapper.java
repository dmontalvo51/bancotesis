package integracion.maps;

import java.util.List;

import modelo.ActaSustentacion;

import org.apache.ibatis.annotations.*;


public interface ActaSustentacionMapper {

	@Select("Select * FROM actasustentacion")
	List<ActaSustentacion> getListaActaSustentacion();
	
	@Insert("Insert into actasustentacion values(#{acta})")
	void insertarActaSustentacion(@Param("acta") ActaSustentacion actaSustentacion);
	
}
