package negocio.impl;

import integracion.maps.ActaSustentacionMapper;

import java.util.List;

import modelo.ActaSustentacion;
import negocio.SustentacionService;

public class SustentacionServiceImpl implements SustentacionService {

	ActaSustentacionMapper actaSustentacionMapper;
	
	@Override
	public List<ActaSustentacion> getListaActaSustentacion() {
		return actaSustentacionMapper.getListaActaSustentacion();
	}

}
