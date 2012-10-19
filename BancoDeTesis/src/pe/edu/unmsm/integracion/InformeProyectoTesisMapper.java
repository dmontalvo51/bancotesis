package pe.edu.unmsm.integracion;

import java.util.List;
import pe.edu.unmsm.modelo.Ficha;
import pe.edu.unmsm.modelo.InformeProyectoTesis;

public interface InformeProyectoTesisMapper {
	
public List<Ficha> RegistrarFichas();
public List<InformeProyectoTesis> cargarInformeProyectoTesis();
	
}