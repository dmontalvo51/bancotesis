package pe.edu.unmsm.negocio.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.integracion.dao.TesisMapper;
import pe.edu.unmsm.negocio.modelo.Programacion;
import pe.edu.unmsm.negocio.modelo.Respuesta;
import pe.edu.unmsm.negocio.modelo.Tesis;
import pe.edu.unmsm.util.TesisUtil;

@Service(value="sustentarTesisService")
public class SustentarTesisService {
	
	@Autowired
	private TesisMapper tesisMapper;
	
	public List<Tesis> cargarListaTesisPorAprobar(){
		try {
			return tesisMapper.cargarListaTesisPorAprobar();
		} catch (Exception e) {
			TesisUtil.escribir("Error al cargar la lista de Tesis por aprobar");
			e.printStackTrace();
			return new ArrayList<Tesis>();
		}
	}
	
	public List<Tesis> cargarListaTesisAprobadas(){
		try {
			return tesisMapper.cargarListaTesisAprobadas();
		} catch (Exception e) {
			TesisUtil.escribir("Error al cargar la lista de Tesis aprobadas");
			e.printStackTrace();
			return new ArrayList<Tesis>();
		}
		
	}
	
	public Respuesta aprobarSustentacionTesis(String codigoTesis){
		Respuesta r=new Respuesta();
		
		try {
			tesisMapper.aprobarTesis(codigoTesis);
		} catch (Exception e) {
			TesisUtil.escribir("********ERROR AL APROBAR LA TESIS*********");
			e.printStackTrace();
			r.setEstado(Respuesta.ERROR);
		}finally{
			r.setEstado(Respuesta.OK);
		}
		return r;
	}
	
	public Respuesta programarSustentacioNTesis(Programacion programacion){
		Respuesta r=new Respuesta();
		
		try {
			tesisMapper.programarSustentacionTesis(programacion);
		} catch (Exception e) {
			TesisUtil.escribir("********ERROR AL PROGRAMAR LA TESIS********");
			e.printStackTrace();
			r.setEstado(Respuesta.ERROR);
		}finally{
			r.setEstado(Respuesta.OK);
		}
		return r;
	}
	
	
	
	
	public TesisMapper getTesisMapper() {
		return tesisMapper;
	}

	public void setTesisMapper(TesisMapper tesisMapper) {
		this.tesisMapper = tesisMapper;
	}
	
}
