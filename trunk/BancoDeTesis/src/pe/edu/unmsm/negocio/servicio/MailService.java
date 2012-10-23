package pe.edu.unmsm.negocio.servicio;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;
import org.jasypt.util.text.TextEncryptor;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.util.TesisUtil;

@Service(value = "mailService")
public class MailService {

	public void enviarCorreo() {
		TesisUtil.escribir("Escribiendo un correo");
		
		try {
			
			BasicTextEncryptor spassencryptor=new BasicTextEncryptor();
			spassencryptor.setPassword("tesis");
			
					
			// Propiedades de la conexión
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.setProperty("mail.smtp.port", "587");
			// Nombre del usuario
			props.setProperty("mail.smtp.user", "07200024@unmsm.edu.pe");
			props.setProperty("mail.smtp.auth", "true");

			// Preparamos la sesion
			Session sesion = Session.getDefaultInstance(props);
			// Para obtener un log de salida más extenso
			sesion.setDebug(true);
			// Construimos el mensaje
			MimeMessage message = new MimeMessage(sesion);
			message.setFrom(new InternetAddress("07200024@unmsm.edu.pe"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					"dmontalvo.m@gmail.com"));
			message.setSubject("Pruebita");
			message.setText("Mensajito con Java Mail" + "de los buenos."+ "poque si");

			// Lo enviamos.
			Transport t = sesion.getTransport("smtp");
			t.connect("07200024@unmsm.edu.pe", spassencryptor.decrypt("D0Dnerr7XTOvnPeJonob8r+g4aBrLq3j"));
			t.sendMessage(message, message.getAllRecipients());
		//	t.send(message);
			
		
			// Cierre.
			t.close();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
