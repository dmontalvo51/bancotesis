package pe.edu.unmsm.integracion;

import java.util.List;

import pe.edu.unmsm.modelo.ActaSustentacion;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


public interface SustentacionMapper{


	List<ActaSustentacion> selectActaSustentacion();
	
	void insertarActaSustentacion(ActaSustentacion actaSustentacion);
	
}
