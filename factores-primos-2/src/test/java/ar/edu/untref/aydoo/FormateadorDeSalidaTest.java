package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import org.junit.Assert;

public class FormateadorDeSalidaTest {

	@Test
	public void formateadorNoRecibeFormatoEntoncesPretty() {
		Formateador formateador = new FormateadorDeSalida(null);

		List<Integer> lista = new LinkedList<Integer>();
		lista.add(1);
		lista.add(2);

		String respuesta = formateador.formatear(lista, 3);

		Assert.assertEquals("Factores primos 3: 1 2", respuesta);
	}
	
	@Test
	public void formatearEnPrettyDevuelveResultados() {
		Formateador formateador = new FormateadorDeSalida("--format=pretty");

		List<Integer> lista = new LinkedList<Integer>();
		lista.add(1);
		lista.add(2);

		String respuesta = formateador.formatear(lista, 3);

		Assert.assertEquals("Factores primos 3: 1 2", respuesta);
	}
	
	@Test
	public void formatearEnPrettyFormatoConMayuscula() {
		Formateador formateador = new FormateadorDeSalida("--format=PRETTY");

		List<Integer> lista = new LinkedList<Integer>();
		lista.add(1);
		lista.add(2);

		String respuesta = formateador.formatear(lista, 3);

		Assert.assertEquals("Factores primos 3: 1 2", respuesta);
	}
	
	@Test
	public void formatearEnQuietDevuelveResultados() {
		Formateador formateador = new FormateadorDeSalida("--format=quiet");

		List<Integer> lista = new LinkedList<Integer>();
		lista.add(1);
		lista.add(2);

		String respuesta = formateador.formatear(lista, 3);

		Assert.assertEquals("2\n1\n", respuesta);
	}
	
	@Test
	public void formatearEnQuietFormatoConMayuscula() {
		Formateador formateador = new FormateadorDeSalida("--format=QuiEt");

		List<Integer> lista = new LinkedList<Integer>();
		lista.add(1);
		lista.add(2);

		String respuesta = formateador.formatear(lista, 3);

		Assert.assertEquals("2\n1\n", respuesta);
	}
	
	@Test
	public void formatearNoReconoceFormato() {
		Formateador formateador = new FormateadorDeSalida("abc");

		List<Integer> lista = new LinkedList<Integer>();
		lista.add(1);
		lista.add(2);

		String respuesta = formateador.formatear(lista, 3);

		Assert.assertEquals("Formato no aceptado. Las opciones posibles son: pretty o quiet.", respuesta);
	}

}
