package pe.edu.unmsm.negocio.servicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.integracion.dao.DocenteMapper;
import pe.edu.unmsm.integracion.dao.FichasMapper;
import pe.edu.unmsm.integracion.dao.InformeProyectoTesisMapper;
import pe.edu.unmsm.integracion.dao.LineaInvestigacionMapper;
import pe.edu.unmsm.integracion.dao.ProyectoTesisMapper;
import pe.edu.unmsm.negocio.modelo.Docente;

import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.InformeProyectoTesis;
import pe.edu.unmsm.negocio.modelo.LineaInvestigacion;
import pe.edu.unmsm.negocio.modelo.Tesis;
import pe.edu.unmsm.util.TesisUtil;

@Service(value = "registroProyectoTesisService")
public class RegistroProyectoTesisService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Referencias a los DAO (Mapper = DAO)
	@Autowired
	private ProyectoTesisMapper proyectoTesisMapper;

	@Autowired
	private FichasMapper fichasMapper;

	@Autowired
	private InformeProyectoTesisMapper informeProyectoTesisMapper;

	@Autowired
	private LineaInvestigacionMapper lineaInvestigacionMapper;

	@Autowired
	private DocenteMapper docenteMapper;

	// Servicios

	public List<LineaInvestigacion> cargarLineasInvestigacion() {

		return lineaInvestigacionMapper.cargarLineasInvestigacion();

	}

	public List<LineaInvestigacion> cargarSubLineasInvestigacion(int idLinea) {

		return lineaInvestigacionMapper.cargarSubLineasInvestigacion(idLinea);

	}

	public List<Docente> cargarListaDocentesPorLinea(int id) {
		return docenteMapper.cargarListaDocentesPorLinea(id);
	}

	public List<Ficha> cargarListaFichasInscritas() {

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
		return fichasMapper.cargarListaFichasInscritas();

	}

	public List<InformeProyectoTesis> cargarInformeProyetoTesis() {

		List<InformeProyectoTesis> lista = new ArrayList<InformeProyectoTesis>();

		// lista=InformeProyectoTesisMapper.cargarInformeProyectoTesis();

		return lista;

	}

	public void insertarFichaProyectoTesis(Ficha ficha) {
		try {
			fichasMapper.insertarFichaProyectoTesis(ficha);

			//TesisUtil.generarReporte("fichaTesis", null);

		} catch (Exception e) {
			TesisUtil.escribir("ERROR AL INSERTAR!");
			e.printStackTrace();
		}

	}
	
	public void insertarInformeProyectoTesis(InformeProyectoTesis ipt){
		try {
			informeProyectoTesisMapper.ingresarInformeProyectoTesis(ipt);
			
			TesisUtil.escribir("Se llamo al IPT Mapper");
			//TesisUtil.generarReporte("fichaTesis",null);
			
		} catch (Exception e) {
			TesisUtil.escribir("ERROR AL INSERTAR INFORME DE PROYECTO DE TESIS!");
			e.printStackTrace();
		}
	}

	// Metodos de encapsulamiento

	public ProyectoTesisMapper getProyectoTesisMapper() {
		return proyectoTesisMapper;
	}

	public void setProyectoTesisMapper(ProyectoTesisMapper proyectoTesisMapper) {
		this.proyectoTesisMapper = proyectoTesisMapper;
	}

	public FichasMapper getFichasMapper() {
		return fichasMapper;
	}

	public void setFichasMapper(FichasMapper fichasMapper) {
		this.fichasMapper = fichasMapper;
	}

	public InformeProyectoTesisMapper getInformeProyectoTesisMapper() {
		return informeProyectoTesisMapper;
	}

	public void setInformeProyectoTesisMapper(
			InformeProyectoTesisMapper informeProyectoTesisMapper) {
		this.informeProyectoTesisMapper = informeProyectoTesisMapper;
	}

	public void destruir(ActionEvent actionEvent) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"System Error", "Please try again later.");

		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public LineaInvestigacionMapper getLineaInvestigacionMapper() {
		return lineaInvestigacionMapper;
	}

	public void setLineaInvestigacionMapper(
			LineaInvestigacionMapper lineaInvestigacionMapper) {
		this.lineaInvestigacionMapper = lineaInvestigacionMapper;
	}

	public DocenteMapper getDocenteMapper() {
		return docenteMapper;
	}

	public void setDocenteMapper(DocenteMapper docenteMapper) {
		this.docenteMapper = docenteMapper;
	}

	public void generarDocumentoFichaProyectoTesis(Ficha ficha) {

	}

	public void generarDocumentoInformeProyectoTesis(Ficha ficha) {

	}

}
