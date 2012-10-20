package pe.edu.unmsm.util;

import java.util.Calendar;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class TesisUtil {
	
	
	/*public static void subirFlash(String clave, Object objeto){
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put(clave, objeto);
	}*/
	
	public static Flash flashScope(String clave, Object objeto){
		return (FacesContext.getCurrentInstance().getExternalContext().getFlash());
	}
	
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
