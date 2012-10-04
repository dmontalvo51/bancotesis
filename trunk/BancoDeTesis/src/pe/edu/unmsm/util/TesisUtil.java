package pe.edu.unmsm.util;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.context.FacesContext;

public class TesisUtil {
	
	
	public static void escribir(String texto) {
		System.out.println(texto);
	}
	
	public static Object subirASesion(String clave, Object objeto){
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(clave, objeto);

	}
	
	public static Object obtenerDeSesion(String clave){
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(clave);
	}
	
	public static String fechaActual(){
		Calendar calendar=Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_MONTH)+"/"+
				calendar.get(Calendar.MONTH)+"/"+
		calendar.get(Calendar.YEAR);
	}

	public static int getAñoActual() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}


}
