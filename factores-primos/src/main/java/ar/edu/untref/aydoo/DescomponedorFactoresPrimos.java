package ar.edu.untref.aydoo;

import java.util.LinkedList;

import ar.edu.untref.aydoo.interfaces.DescomponedorFactores;

public class DescomponedorFactoresPrimos implements DescomponedorFactores {

	public LinkedList<Integer> descomponer(int numero) {

		int factor = 2;

		// Se empieza probando como posible factor primo el 2.
		LinkedList<Integer> factores = new LinkedList<Integer>();

		while (factor <= numero) {
			// Mientras es divisible, se añade el factor a la lista de factores
			// primos
			// y se realiza la división.
			while (numero % factor == 0) {
				factores.add(new Integer(factor));
				numero = numero / factor;
			}

			// Si no es divisible, se pasa al posible siguiente factor.
			factor++;
		}

		return factores;
	}
}
