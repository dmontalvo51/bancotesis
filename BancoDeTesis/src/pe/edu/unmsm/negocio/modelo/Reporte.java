package pe.edu.unmsm.negocio.modelo;

import java.util.List;
import java.util.Map;

public class Reporte {
	
	public static String PATH="/documentos/";

	private String nombreReporte; //Nombre del archivo JRXML
	private String rutaReporte;  //Ubicacion donde se guardará el PDF generado
	private Map<String,Object> parametros; //Parametros del PDF
	private List<Object> dataSource;
	
	
	public String getNombreReporte() {
		return nombreReporte;
	}
	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}
	public String getRutaReporte() {
		return rutaReporte;
	}
	public void setRutaReporte(String rutaReporte) {
		this.rutaReporte = rutaReporte;
	}
	public Map<String, Object> getParametros() {
		return parametros;
	}
	public void setParametros(Map<String, Object> parametros) {
		this.parametros = parametros;
	}
	public List<Object> getDataSource() {
		return dataSource;
	}
	public void setDataSource(List<Object> dataSource) {
		this.dataSource = dataSource;
	}
	
}
