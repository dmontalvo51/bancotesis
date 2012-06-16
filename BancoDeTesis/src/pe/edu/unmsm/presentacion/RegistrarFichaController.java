package pe.edu.unmsm.presentacion;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import pe.edu.unmsm.modelo.ActaSustentacion;
import pe.edu.unmsm.modelo.Asesor;
import pe.edu.unmsm.modelo.Expediente;
import pe.edu.unmsm.modelo.LineaInvestigacion;
import pe.edu.unmsm.modelo.Usuario;
import pe.edu.unmsm.negocio.ExpedientesService;
import pe.edu.unmsm.util.TesisUtil;

@RequestScoped
@ManagedBean(name="registrarFicha")
public class RegistrarFichaController {
	private String codigo;
	private String titulo;
	private String resumen;

	private Asesor asesor;
	private LineaInvestigacion lineaInvestigacion;
	private List<Asesor> asesores;
	private List<LineaInvestigacion> lineaInvestigaciones;
	
	@ManagedProperty(value="#{expedientesService}")
	private ExpedientesService expedientesService;
	
	
	public String iniciarExpediente(){
		
		Expediente exp=new Expediente();
		exp.setCodigoUsuario(((Usuario)TesisUtil.obtenerDeSesion("usuario")).getId());
		exp.setEstado(1);
		exp.setFechaInicio(TesisUtil.fechaActual());
		exp.setCodigo("001TESIS2012");
		
		exp=expedientesService.ingresarExpediente(exp);
		
		return "IngresarFicha";
	}
	
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public Asesor getAsesor() {
		return asesor;
	}
	public void setAsesor(Asesor asesor) {
		this.asesor = asesor;
	}
	public LineaInvestigacion getLineaInvestigacion() {
		return lineaInvestigacion;
	}
	public void setLineaInvestigacion(LineaInvestigacion lineaInvestigacion) {
		this.lineaInvestigacion = lineaInvestigacion;
	}
	public List<Asesor> getAsesores() {
		return asesores;
	}
	public void setAsesores(List<Asesor> asesores) {
		this.asesores = asesores;
	}
	public List<LineaInvestigacion> getLineaInvestigaciones() {
		return lineaInvestigaciones;
	}
	public void setLineaInvestigaciones(List<LineaInvestigacion> lineaInvestigaciones) {
		this.lineaInvestigaciones = lineaInvestigaciones;
	}

		
}
