package pe.edu.unmsm.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.context.FacesContext;

public class TesisUtil {
	
	
	public static void escribir(String texto) {
		System.out.println(texto);
	}
	
	public static void subirASesion(String clave, Object objeto){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(clave, objeto);

	}
	
	public static Object obtenerDeSesion(String clave){
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(clave);
	}
	
	public static String fechaActual(){
		Calendar calendar=new GregorianCalendar();
		return "2012-06-02";
	}


}
