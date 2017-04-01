package ar.edu.untref.aydoo;

import java.util.List;

public class FormateadorDeSalida extends Formateador {

	private static final String textoError = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
	private static final String textoPretty = "Factores primos ";

	public FormateadorDeSalida(String formato) {
		super(formato);
	}

	@Override
	public String formatear(List<Integer> numeros, int numeroOriginal) {
		String numeroFormateado = textoError;

		if (formato.equals("pretty")) {

			numeroFormateado = textoPretty + numeroOriginal + ":" + this.formatearPretty(numeros);

		} else if (formato.equals("quiet")) {

			numeroFormateado = this.formatearQuiet(numeros);

		}

		return numeroFormateado;
	}

	private String formatearPretty(List<Integer> numeros) {
		String numerosEnTexto = new String();

		for (int numero : numeros) {
			numerosEnTexto = numerosEnTexto + " " + numero;
		}

		return numerosEnTexto;
	}

	private String formatearQuiet(List<Integer> numeros) {
		String numerosEnTexto = new String();

		for (int numero : numeros) {
			numerosEnTexto = numerosEnTexto + numero + "\n";
		}

		return numerosEnTexto;
	}
}
