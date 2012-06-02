package pe.edu.unmsm.negocio.impl;

import pe.edu.unmsm.integracion.SustentacionMapper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.modelo.ActaSustentacion;
import pe.edu.unmsm.negocio.SustentacionService;
import pe.edu.unmsm.util.TesisUtil;

@Service("sustentacionService")
public class SustentacionServiceImpl implements SustentacionService {

	@Resource
	SustentacionMapper actaSustentacionMapper;

	public List<ActaSustentacion> getListaActaSustentacion() {
		TesisUtil.escribir("Entro al servicio");
		try {
			return actaSustentacionMapper.selectActaSustentacion();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList();
		}
		
	}
	
	

	public SustentacionMapper getActaSustentacionMapper() {
		return actaSustentacionMapper;
	}

	public void setActaSustentacionMapper(
			SustentacionMapper actaSustentacionMapper) {
		this.actaSustentacionMapper = actaSustentacionMapper;
	}


}
