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
		
		listaExpedientes.add(new Expediente(1, "0001-FISI-2012","Nuevo", "07200024","Diego Ignacio", "Montalvo Molina",new Date(23,5,2012)));
		listaExpedientes.add(new Expediente(2, "0002-FISI-2012","Nuevo", "08200111","Salomon Rodrigo", "Mendoza Cardenas",new Date(23,5,2012)));
		listaExpedientes.add(new Expediente(3, "0003-FISI-2012","Nuevo", "08200190","Jaime Alonso", "Medina Zacarias",new Date(23,5,2012)));
		
		return listaExpedientes;
	}

	public ExpedientesMapper getExpedientesMapper() {
		return expedientesMapper;
	}

	public void setExpedientesMapper(ExpedientesMapper expedientesMapper) {
		this.expedientesMapper = expedientesMapper;
	}

	
}
