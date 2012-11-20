package pe.edu.unmsm.presentacion.revisionBorrador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.unmsm.negocio.modelo.Ficha;
import pe.edu.unmsm.negocio.modelo.Tesis;
import pe.edu.unmsm.negocio.modelo.InformeProyectoTesis;
import pe.edu.unmsm.negocio.modelo.ProyectoTesis;
import pe.edu.unmsm.negocio.modelo.Usuario;
import pe.edu.unmsm.negocio.modelo.DetalleActaObservacion;
import pe.edu.unmsm.negocio.servicio.RegistroProyectoTesisService;
import pe.edu.unmsm.util.TesisUtil;

@ViewScoped
@ManagedBean(name = "generarActaObservacion")
public class GenerarActaObservacionController implements Serializable {
	
	private static final long serialVersionUID = 9054693765543258216L;
	private String ipt_observaciones;
	private String ipt_sugerencias;
	private int ipt_opinion;
	private int observacion;
	private Tesis tesis;
	
	private DetalleActaObservacion dao;
	private List<DetalleActaObservacion> listDAO = new ArrayList<DetalleActaObservacion>();
	private int linea=0;
	
	public GenerarActaObservacionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManagedProperty("#{registroProyectoTesisService}")
	private RegistroProyectoTesisService registroProyectoTesisService;
	
	@PostConstruct
	public void cargarDatos(){
		tesis=(Tesis)TesisUtil.obtenerDeSesion("tesis");
		DetalleActaObservacion dao=new DetalleActaObservacion();
	
	}
	
	public String atrasPage(){
		//TesisUtil.flashScope("ficha", selectedFicha);
		return "ListarFichasProyectoDeTesis";
	}

	
	public String cancelarInformePT(){
		return "ListarFichasProyectoDeTesis?faces-redirect=true";
	}

	public void generarActa(){
		
	}
	
	public void agregarObrservacion(){
		linea=linea+1;
		dao.setLinea(linea);
	}
	
	public RegistroProyectoTesisService getRegistroProyectoTesisService() {
		return registroProyectoTesisService;
	}

	public void setRegistroProyectoTesisService(
			RegistroProyectoTesisService registroProyectoTesisService) {
		this.registroProyectoTesisService = registroProyectoTesisService;
	}

	

	public Tesis getTesis() {
		return tesis;
	}

	public void setTesis(Tesis tesis) {
		this.tesis = tesis;
	}
	
	public int getIpt_opinion() {
		return ipt_opinion;
	}

	public void setIpt_opinion(int ipt_opinion) {
		this.ipt_opinion = ipt_opinion;
	}

	public String getIpt_observaciones() {
		return ipt_observaciones;
	}

	public void setIpt_observaciones(String ipt_observaciones) {
		this.ipt_observaciones = ipt_observaciones;
	}

	public String getIpt_sugerencias() {
		return ipt_sugerencias;
	}

	public void setIpt_sugerencias(String ipt_sugerencias) {
		this.ipt_sugerencias = ipt_sugerencias;
	}

	public DetalleActaObservacion getDao() {
		return dao;
	}

	public void setDao(DetalleActaObservacion dao) {
		this.dao = dao;
	}



	

	
}