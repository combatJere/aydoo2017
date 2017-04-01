package ar.edu.untref.aydoo;

import java.util.List;

public abstract class Formateador {

	protected String formato;
	
	public Formateador(String formato){
		this.formato = formato.toLowerCase();
	}
	
	public abstract String formatear(List<Integer> numeros, int numeroOriginal);
}
