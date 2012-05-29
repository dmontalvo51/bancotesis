package pe.edu.unmsm.negocio.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pe.edu.unmsm.integracion.TramitesMapper;
import pe.edu.unmsm.modelo.Tramite;
import pe.edu.unmsm.negocio.TramitesService;

@Service("tramitesService")
public class TramitesServiceImpl implements TramitesService {
	
	@Resource
	private TramitesMapper tramitesMapper;

	public List<Tramite> cargarTramites() {
		return tramitesMapper.cargarTramites();
	}
	
	

	public TramitesMapper getTramitesMapper() {
		return tramitesMapper;
	}

	public void setTramitesMapper(TramitesMapper tramitesMapper) {
		this.tramitesMapper = tramitesMapper;
	}

}
