package pe.edu.unmsm.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.unmsm.modelo.Tesis;

@Service(value="revisionBorradorTesisService")
public class RevisionBorradorTesisService {

	public List<Tesis> cargarListaTesisInscritas() {
		
		List<Tesis> lista = new ArrayList<Tesis>();
		
		//lista=TesisMapper.cargarListaTesisInscritas();
		
		lista.add(new Tesis("123","0","abc","Jorge","perez","Bustamante","11/11/2012","resumen1","linea1"));
		lista.add(new Tesis("123","0","abc","Diego","perez","Piedra","11/11/2012","resumen2","linea2"));
		lista.add(new Tesis("123","1","abc","Karina","perez","Mauricio","11/11/2012","resumen3","linea3"));
		lista.add(new Tesis("123","0","abc","Johnny","perez","Luza","11/11/2012","resumen4","linea4"));
		
		return lista;
		
	}
}
