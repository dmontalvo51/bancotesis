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
import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.Tesis;
import pe.edu.unmsm.negocio.modelo.BorradorTesis;

@Service(value="revisionBorradorTesisService")
public class RevisionBorradorTesisService {
	
	private static final long serialVersionUID = 12L;
	
	@Autowired
	private TesisMapper tesisMapper;
	
	@Autowired
	private BorradorTesisMapper borradorMapper;

	public List<Tesis> cargarListaTesis() {

		List<Tesis> lista = new ArrayList<Tesis>();
		
		//lista=TesisMapper.cargarListaTesisInscritas();
		
		//lista.add(new Tesis("1234","Sin Revisar","Luis Alarcón","Bustamante","Jorge","Caceres","11/11/2012","resumen1","linea1"));
		//lista.add(new Tesis("1235","Sin Revisar","Luis Alarcón","Piedra","Diego","Montalvo","11/11/2012","resumen2","linea2"));
		//lista.add(new Tesis("1236","Revisado","Luis Alarcón","Mauricio","Karina","Aranguren","11/11/2012","resumen3","linea3"));
		//lista.add(new Tesis("1237","Sin Revisar","Luis Alarcón","Luza","Johnny","Apolinario","11/11/2012","resumen4","linea4"));
		
		return tesisMapper.cargarListaTesis();
	}
	
	public List<BorradorTesis> cargarListaBorradorTesis() {

		//List<Ficha> lista = new ArrayList<Ficha>();

		// lista=fichasMapper.cargarListaFichasInscritas();

		/*
		 * lista.add(new Ficha("026-FISI-2012", "F001", "titulo 1",
		 * "resumen ficha 1", "linea 1", 1, "Diego", "revisado",
		 * "Piedra",null,null,null)); lista.add(new Ficha("027-FISI-2012",
		 * "F002", "titulo 2", "resumen ficha 2", "linea 2", 1, "Diego",
		 * "revisado", "Piedra",null,null,null)); lista.add(new
		 * Ficha("028-FISI-2012", "F003", "titulo 3", "resumen ficha 3",
		 * "linea 3", 1, "Karina", "revisado", "Mauricio",null,null,null));
		 * lista.add(new Ficha("029-FISI-2012", "F004", "titulo 4",
		 * "resumen ficha 4", "linea 4", 1, "Johnny", "rechazada",
		 * "Luza",null,null,null));
		 */
		return borradorMapper.cargarListaBorradorTesis();

	}
	
	
}
