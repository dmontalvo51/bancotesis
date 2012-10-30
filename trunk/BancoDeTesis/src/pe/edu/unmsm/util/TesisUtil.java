package pe.edu.unmsm.util;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import sun.security.jca.GetInstance;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class TesisUtil {

	/*
	 * public static void subirFlash(String clave, Object objeto){
	 * FacesContext.getCurrentInstance
	 * ().getExternalContext().getFlash().put(clave, objeto); }
	 */

	public static void flashScope(String clave, Object objeto) {
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.put(clave, objeto);
	}

	public static void escribir(String texto) {
		System.out.println(texto);
	}

	public static Object subirASesion(String clave, Object objeto) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().put(clave, objeto);

	}

	public static Object obtenerDeSesion(String clave) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(clave);
	}

	public static String fechaActual() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_MONTH) + "/"
				+ calendar.get(Calendar.MONTH) + "/"
				+ calendar.get(Calendar.YEAR);
	}

	public static int getAñoActual() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	public static StreamedContent generarReporte(String nombre, Map parametros) {

		String path = FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("/");
		path = path	+ "WEB-INF\\classes\\pe\\edu\\unmsm\\integracion\\reportes\\";
		escribir(path);

		try {
			JasperReport report = JasperCompileManager.compileReport(path+nombre+".jrxml");

			JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
					new ArrayList<Object>());

			JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametros, beanCollectionDataSource);
			//JasperPrint jasperPrint = JasperFillManager.fillReport(path+nombre+".jasper",parametros, beanCollectionDataSource);
			
			JasperExportManager.exportReportToPdfFile(jasperPrint, "E:\\Reporte.pdf");
			
			File pdfGenerado;
			
			InputStream inputStream=new FileInputStream(new File("E:\\Reporte.pdf"));
			//		FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("E:\\Reporte.pdf");		
			
			StreamedContent streamedContent=new DefaultStreamedContent(inputStream,"application/pdf","Ficha.pdf");
			
			return streamedContent;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;	
	}

}
