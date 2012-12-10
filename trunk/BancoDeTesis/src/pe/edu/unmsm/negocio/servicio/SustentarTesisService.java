package pe.edu.unmsm.negocio.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.integracion.dao.TesisMapper;
import pe.edu.unmsm.negocio.modelo.Tesis;

@Service(value="sustentarTesisService")
public class SustentarTesisService {
	
	@Autowired
	private TesisMapper tesisMapper;
	
	public List<Tesis> cargarListaTesisPorAprobar(){
		return tesisMapper.cargarListaTesisPorAprobar();
	}
	
	public List<Tesis> cargarListaTesisAprobadas(){
		return tesisMapper.cargarListaTesisAprobadas();
	}
	
	
	
	
	
	public TesisMapper getTesisMapper() {
		return tesisMapper;
	}

	public void setTesisMapper(TesisMapper tesisMapper) {
		this.tesisMapper = tesisMapper;
	}
	
}
