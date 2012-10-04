package pe.edu.unmsm.negocio;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.text.NumberFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.integracion.ExpedientesMapper;
import pe.edu.unmsm.modelo.Expediente;
import pe.edu.unmsm.modelo.Respuesta;
import pe.edu.unmsm.modelo.Tesis;
import pe.edu.unmsm.modelo.Usuario;
import pe.edu.unmsm.util.TesisUtil;

@Service(value = "expedienteService")
public class ExpedienteService {

	@Autowired
	private ExpedientesMapper expedientesMapper;

	public List<Expediente> cargarTramites() {
		List<Expediente> listaExpedientes = new ArrayList<Expediente>();
		listaExpedientes = expedientesMapper.cargarExpedientes();

		return listaExpedientes;
	}

	public Respuesta crearExpediente() {
		Respuesta r = new Respuesta();
		Map datos = new HashMap<String, String>();
		datos.put("codigo",
				((Usuario) TesisUtil.obtenerDeSesion("usuario")).getCuenta());
		datos.put("codigExp", "");

		String codigo = expedientesMapper.crearExpediente(datos);

		if (codigo != null) {
			TesisUtil.escribir((String)datos.get("codigoExp"));

			Tesis tesis = new Tesis();
			tesis = expedientesMapper.cargarTesisPorCodigo(codigo);
			TesisUtil.subirASesion("tesis", tesis);

			r.setEstado(Respuesta.OK);
			r.setMensaje("Expediente " + codigo + " creado correctamente.");
		} else {
			r.setEstado(Respuesta.ERROR);
		}

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
