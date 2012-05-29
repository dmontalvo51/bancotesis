package pe.edu.unmsm.integracion.maps;

import java.util.List;

import pe.edu.unmsm.modelo.ActaSustentacion;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


public interface ActaSustentacionMapper {

	@Select("Select * FROM actasustentacion")
	List<ActaSustentacion> getListaActaSustentacion();
	
	@Insert("Insert into actasustentacion values(#{acta})")
	void insertarActaSustentacion(@Param("acta") ActaSustentacion actaSustentacion);
	
}
