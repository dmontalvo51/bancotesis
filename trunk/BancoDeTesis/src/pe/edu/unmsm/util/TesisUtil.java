package pe.edu.unmsm.util;

import java.util.List;
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

import pe.edu.unmsm.negocio.modelo.Docente;


import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

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
		    //JasperReport report = JasperCompileManager.compileReport(path+nombre+".jrxml");
			//JasperPrint jasperPrint = JasperFillManager.fillReport(report,parametros);
						
			JREmptyDataSource jrEmptyDataSource=new JREmptyDataSource();
			JasperPrint jasperPrint = JasperFillManager.fillReport(path+nombre+".jasper",parametros,jrEmptyDataSource);
			
			JasperExportManager.exportReportToPdfFile(jasperPrint,"D:\\Reporte.pdf");
			
			File pdfGenerado;
			
			InputStream inputStream=new FileInputStream(new File("D:\\Reporte.pdf"));
			//		FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("E:\\Reporte.pdf");		
			
			StreamedContent streamedContent=new DefaultStreamedContent(inputStream,"application/pdf","Ficha.pdf");
			/*
			 * Reporte de prueba
			 * */
			List<Docente> listaDocentes=new ArrayList<Docente>();
			listaDocentes.add(new Docente("1","Profesor 1"));
			listaDocentes.add(new Docente("2","Profesor 2"));
			listaDocentes.add(new Docente("3","Profesor 3"));
			listaDocentes.add(new Docente("4","Profesor 4"));
			listaDocentes.add(new Docente("5","Profesor 5"));
			listaDocentes.add(new Docente("6","Profesor 6"));
			listaDocentes.add(new Docente("7","Profesor 7"));
			
			JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listaDocentes);
			JasperReport report = JasperCompileManager.compileReport(path+nombre+".jrxml");
			JasperPrint print = JasperFillManager.fillReport(report,parametros,beanCollectionDataSource);
			JasperExportManager.exportReportToHtmlFile(print,"D:\\Prueba.html");
			JasperExportManager.exportReportToPdfFile(print, "D:\\Prueba.pdf");
			
			/**/
			
			
			return streamedContent;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;	
	}

}
