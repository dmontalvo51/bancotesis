package pe.edu.unmsm.presentacion.seguridadSistema;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import pe.edu.unmsm.negocio.MailService;
import pe.edu.unmsm.util.TesisUtil;


@SessionScoped
@ManagedBean(name="comun")
public class CommonController implements Serializable {
	
	@ManagedProperty("#{mailService}")
	private MailService mailService;
	
	public String  enviarCorreo(){
		TesisUtil.escribir("Escribiendo un correo");
		mailService.enviarCorreo();
		return null;
	}

	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}
	
	
}
