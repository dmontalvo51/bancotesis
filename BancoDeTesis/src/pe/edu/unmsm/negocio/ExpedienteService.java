package pe.edu.unmsm.negocio;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.text.NumberFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.integracion.ExpedientesMapper;
import pe.edu.unmsm.modelo.Expediente;
import pe.edu.unmsm.modelo.Respuesta;
import pe.edu.unmsm.modelo.Usuario;
import pe.edu.unmsm.util.TesisUtil;

@Service(value="expedienteService")
public class ExpedienteService {

	@Autowired
	private ExpedientesMapper expedientesMapper;

	public List<Expediente> cargarTramites() {
		List<Expediente> listaExpedientes = new ArrayList<Expediente>();
		listaExpedientes = expedientesMapper.cargarExpedientes();

		return listaExpedientes;
	}

	public Respuesta crearExpediente() {
		String codigo = expedientesMapper.cargarUltimoCodigoExp();
				
		if (codigo != null) {
			/*Generando el codigo*/
			String serie = codigo.substring(0,3);
			serie = Integer.toString(Integer.valueOf(serie) + 1);
			codigo=String.format("%3s",serie).replace(' ','0')+"-FISI-"+TesisUtil.getAñoActual();
					
			Usuario usu = (Usuario) TesisUtil.obtenerDeSesion("usuario");

		} else {
			/* Primer Expediente */
			codigo = "001-FISI-" + TesisUtil.getAñoActual();
		}
		
		Respuesta r=new Respuesta();
		r.setMensaje(codigo);
		return r;
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
