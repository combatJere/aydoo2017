package ar.edu.untref.aydoo;

import java.util.LinkedList;

import ar.edu.untref.aydoo.interfaces.DescomponedorFactores;

public class Programa {
	static DescomponedorFactores descomponedor;
	static Formateador formateador;

	public static final void main(String arg[]) {
		int numero = Integer.parseInt(arg[0]);
		String formato = arg[1];

		descomponedor = new DescomponedorFactoresPrimos();
		formateador = new FormateadorDeSalida(formato);

		LinkedList<Integer> numeroDescompuesto = descomponedor.descomponer(numero);
		String salidaFormateada = formateador.formatear(numeroDescompuesto, numero);

		System.out.println(salidaFormateada);
	}
}
