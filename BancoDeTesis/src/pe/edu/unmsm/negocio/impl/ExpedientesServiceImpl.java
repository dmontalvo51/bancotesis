package pe.edu.unmsm.negocio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pe.edu.unmsm.integracion.ExpedientesMapper;
import pe.edu.unmsm.modelo.Expediente;
import pe.edu.unmsm.negocio.ExpedientesService;

@Service("expedientesService")
public class ExpedientesServiceImpl implements ExpedientesService {
	
	@Resource
	private ExpedientesMapper expedientesMapper;

	public List<Expediente> cargarTramites() {
		List<Expediente> listaExpedientes=new ArrayList<Expediente>();		
		listaExpedientes=expedientesMapper.cargarExpedientes();
		
		return listaExpedientes;
	}
	

	public Expediente ingresarExpediente(Expediente exp) {
		return expedientesMapper.ingresarExpediente(exp);
	}

	
	public ExpedientesMapper getExpedientesMapper() {
		return expedientesMapper;
	}

	public void setExpedientesMapper(ExpedientesMapper expedientesMapper) {
		this.expedientesMapper = expedientesMapper;
	}


	
	
}
