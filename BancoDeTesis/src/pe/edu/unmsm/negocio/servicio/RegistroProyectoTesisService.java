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
import pe.edu.unmsm.integracion.dao.RDInscripcionMapper;
import pe.edu.unmsm.negocio.modelo.Docente;

import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.InformeProyectoTesis;
import pe.edu.unmsm.negocio.modelo.LineaInvestigacion;
import pe.edu.unmsm.negocio.modelo.Respuesta;
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
	
	@Autowired
	private RDInscripcionMapper rdInscripcionMapper;

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

		return fichasMapper.cargarListaFichasInscritas();

	}
	

	public  List<Ficha> cargarListaFichasAprobadas() {

		return fichasMapper.cargarListaFichasAprobadas();
	}
	
	public List<Ficha> cargarListaFichasPorRegistrar() {
		return fichasMapper.cargarListaFichasPorRegistrar();
	}


	public List<InformeProyectoTesis> cargarInformeProyetoTesis() {

		List<InformeProyectoTesis> lista = new ArrayList<InformeProyectoTesis>();

		// lista=InformeProyectoTesisMapper.cargarInformeProyectoTesis();

		return lista;

	}

	public Respuesta insertarFichaProyectoTesis(Ficha ficha) {
		Respuesta r=new Respuesta();
		
		try {
			fichasMapper.insertarFichaProyectoTesis(ficha);
			r.setEstado(Respuesta.OK);

			//TesisUtil.generarReporte("fichaTesis", null);

		} catch (Exception e) {
			TesisUtil.escribir("ERROR AL INSERTAR!");
			e.printStackTrace();
			r.setEstado(Respuesta.ERROR);
		}
		
		return r;

	}
	
	public void insertarInformeProyectoTesis(InformeProyectoTesis ipt){
		Respuesta r=new Respuesta();
		
		try {
			informeProyectoTesisMapper.ingresarInformeProyectoTesis(ipt);
			
			TesisUtil.escribir("Se llamo al IPT Mapper");
			TesisUtil.generarReporte("fichaTesis",null);
			
		} catch (Exception e) {
			TesisUtil.escribir("ERROR AL INSERTAR INFORME DE PROYECTO DE TESIS!");
			e.printStackTrace();
		}
	}

	
	public Respuesta inscribirProyectoDeTesis(Ficha ficha){
		Respuesta r=new Respuesta();
		
		try {
			//rdInscripcionMapper.inscribirProyectoDeTesis(ficha);
			r.setEstado(Respuesta.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r.setEstado(Respuesta.ERROR);
		}
		
		return r;
		
	}
	



	public Respuesta generarRDInscripcion(Ficha ficha) {
		Respuesta r=new Respuesta();
		
		try {
			rdInscripcionMapper.generarRDInscripcion(ficha);
			r.setEstado(Respuesta.OK);
		} catch (Exception e) {
			TesisUtil.escribir("ERROR AL CREAR LA RD DE INSCRIPCIÓN!");
			e.printStackTrace();
			r.setEstado(Respuesta.ERROR);
		}
		
		return r;
			
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

	public RDInscripcionMapper getRdInscripcionMapper() {
		return rdInscripcionMapper;
	}

	public void setRdInscripcionMapper(RDInscripcionMapper rdInscripcionMapper) {
		this.rdInscripcionMapper = rdInscripcionMapper;
	}

	public void generarDocumentoFichaProyectoTesis(Ficha ficha) {

	}

	public void generarDocumentoInformeProyectoTesis(Ficha ficha) {

	}

}
