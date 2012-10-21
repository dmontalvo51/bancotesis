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
		
		lista.add(new Tesis("1234","Sin Revisar","Luis Alarcón","Bustamante","Jorge","Caceres","11/11/2012","resumen1","linea1"));
		lista.add(new Tesis("1235","Sin Revisar","Luis Alarcón","Piedra","Diego","Montalvo","11/11/2012","resumen2","linea2"));
		lista.add(new Tesis("1236","Revisado","Luis Alarcón","Mauricio","Karina","Aranguren","11/11/2012","resumen3","linea3"));
		lista.add(new Tesis("1237","Sin Revisar","Luis Alarcón","Luza","Johnny","Apolinario","11/11/2012","resumen4","linea4"));
		
		return lista;
		
	}
}
