package pe.edu.unmsm.negocio.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.integracion.dao.TesisMapper;
import pe.edu.unmsm.integracion.dao.BorradorTesisMapper;
import pe.edu.unmsm.integracion.dao.LevantarObservacionesMapper;
import pe.edu.unmsm.negocio.modelo.ActaObservacion;
import pe.edu.unmsm.negocio.modelo.DetalleActaObservacion;
import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.Tesis;
import pe.edu.unmsm.negocio.modelo.BorradorTesis;
import pe.edu.unmsm.util.TesisUtil;

@Service(value = "revisionBorradorTesisService")
public class RevisionBorradorTesisService {
	private static final long serialVersionUID = 12L;
	@Autowired
	private TesisMapper tesisMapper;
	@Autowired
	private BorradorTesisMapper borradorMapper;
	@Autowired
	private LevantarObservacionesMapper loMapper;

	public List<Tesis> cargarListaTesis() {

		return tesisMapper.cargarListaTesis();
	}

	public List<BorradorTesis> cargarListaBorradorTesis() {
		return borradorMapper.cargarListaBorradorTesis();

	}

	public Ficha cargarBorrador(String cuenta) {

		return loMapper.cargarBorrador(cuenta);
	}

	public void insertarObservacion(DetalleActaObservacion dao) {

		borradorMapper.ingresarDetalleObservacion(dao);

	}

	public void generarNroAO(ActaObservacion ao) {

		try{
		borradorMapper.generarNroAO(ao);
		}catch (Exception e) {
			TesisUtil.escribir("ERROR AL GENERAR NRO DE AO!");
			e.printStackTrace();
		}
	}

	public void insertarActaObservacion(ActaObservacion ao) {
		// Respuesta r=new Respuesta();

		try {
			borradorMapper.insertarActaObservacion(ao);

			TesisUtil.escribir("Se llamo al AO Mapper");
			// TesisUtil.generarReporte("fichaTesis",null);

		} catch (Exception e) {
			TesisUtil.escribir("ERROR AL INSERTAR ACTA DE OBSERVACIONN!");
			e.printStackTrace();
		}

	}
	

}
