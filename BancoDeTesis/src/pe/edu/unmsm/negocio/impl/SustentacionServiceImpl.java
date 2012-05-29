package pe.edu.unmsm.negocio.impl;

import pe.edu.unmsm.integracion.maps.ActaSustentacionMapper;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.modelo.ActaSustentacion;
import pe.edu.unmsm.negocio.SustentacionService;

@Service("sustentacionService")
public class SustentacionServiceImpl implements SustentacionService {

	@Resource
	ActaSustentacionMapper actaSustentacionMapper;

	public List<ActaSustentacion> getListaActaSustentacion() {
		System.out.println("Entro al servicio");
		return actaSustentacionMapper.getListaActaSustentacion();
	}

}
