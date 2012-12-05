package pe.edu.unmsm.negocio.servicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.integracion.dao.TesisMapper;
import pe.edu.unmsm.integracion.dao.BorradorTesisMapper;
import pe.edu.unmsm.integracion.dao.LevantarObservacionesMapper;
import pe.edu.unmsm.negocio.modelo.ActaObservacion;
import pe.edu.unmsm.negocio.modelo.DetalleActaObservacion;
import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.Respuesta;
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

		List<Tesis> lista = new ArrayList<Tesis>();

		// lista=TesisMapper.cargarListaTesisInscritas();

		// lista.add(new
		// Tesis("1234","Sin Revisar","Luis Alarcón","Bustamante","Jorge","Caceres","11/11/2012","resumen1","linea1"));
		// lista.add(new
		// Tesis("1235","Sin Revisar","Luis Alarcón","Piedra","Diego","Montalvo","11/11/2012","resumen2","linea2"));
		// lista.add(new
		// Tesis("1236","Revisado","Luis Alarcón","Mauricio","Karina","Aranguren","11/11/2012","resumen3","linea3"));
		// lista.add(new
		// Tesis("1237","Sin Revisar","Luis Alarcón","Luza","Johnny","Apolinario","11/11/2012","resumen4","linea4"));
		return lista;
		// return tesisMapper.cargarListaTesis();
	}

	public List<BorradorTesis> cargarListaBorradorTesis() {
		return borradorMapper.cargarListaBorradorTesis();

	}

	public BorradorTesis cargarBorrador(String cuenta) {

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
			TesisUtil.escribir("ERROR AL INSERTAR ACTA DE OBSERVACION!");
			e.printStackTrace();
		}

	}
}
