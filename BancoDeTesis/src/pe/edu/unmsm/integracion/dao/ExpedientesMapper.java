package pe.edu.unmsm.integracion.dao;

import java.util.List;
import java.util.Map;

import pe.edu.unmsm.negocio.modelo.Expediente;
import pe.edu.unmsm.negocio.modelo.Tesis;

public interface ExpedientesMapper {
	
	public List<Expediente> cargarExpedientes();
	
	public Expediente ingresarExpediente(Expediente exp);

	public String crearExpediente(Map datos);
	
	public String cargarUltimoCodigoExp();

	public Tesis cargarTesisPorCodigo(String codigo);

}
