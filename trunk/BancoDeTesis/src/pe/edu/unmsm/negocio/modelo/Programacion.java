package pe.edu.unmsm.negocio.modelo;

import java.io.Serializable;

public class Programacion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String codigTesis;
	private String fechaProgramada;
	private String horaProgramada;
	
	public String getCodigTesis() {
		return codigTesis;
	}
	public void setCodigTesis(String codigTesis) {
		this.codigTesis = codigTesis;
	}
	public String getFechaProgramada() {
		return fechaProgramada;
	}
	public void setFechaProgramada(String fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}
	public String getHoraProgramada() {
		return horaProgramada;
	}
	public void setHoraProgramada(String horaProgramada) {
		this.horaProgramada = horaProgramada;
	}
	
		
}
