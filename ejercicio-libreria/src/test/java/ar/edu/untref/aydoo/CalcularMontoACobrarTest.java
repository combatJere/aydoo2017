package ar.edu.untref.aydoo;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;


public class CalcularMontoACobrarTest {

	@Test
	public void CalcularMontoACobrarClienteUnaSolaCompraEnMes(){
		Libreria libreria  = new Libreria();
		libreria.agragarCliente(1, "02320-2344234", "Delia 1000");
		
		Calendar fechaCompra = Calendar.getInstance();
		fechaCompra.set(2016, 2, 31);
		
		Libro elHobbit = new Libro(50);
		
		libreria.venderProducto(1, fechaCompra.getTime(), elHobbit);
		
		
		double monto = libreria.calcularMontoACobrar(2016, 2, 1);
		

		Assert.assertEquals(50, monto, 0.5);
	}
	
	@Test
	public void CalcularMontoACobrarClienteMasDeUnaCompraEnMes(){
		Libreria libreria  = new Libreria();
		libreria.agragarCliente(1, "02320-2344234", "Delia 1000");
		
		Calendar fechaCompraHobbit = Calendar.getInstance();
		fechaCompraHobbit.set(2016, 2, 31);
		Calendar fechaCompraCuaderno = Calendar.getInstance();
		fechaCompraCuaderno.set(2016, 2, 12);
		
		Libro elHobbit = new Libro(50);
		ArticuloDeLibreria cuaderno = new ArticuloDeLibreria(10, 20);
		
		libreria.venderProducto(1, fechaCompraHobbit.getTime(), elHobbit);
		libreria.venderProducto(1, fechaCompraCuaderno.getTime(), cuaderno);
		
		double monto = libreria.calcularMontoACobrar(2016, 2, 1);

		Assert.assertEquals(62, monto, 0.5);
	}
	
	@Test
	public void CalcularMontoACobrarClienteUnaSuscripcionEnMes(){
		Libreria libreria  = new Libreria();
		libreria.agragarCliente(1, "02320-2344234", "Delia 1000");
		
		Calendar fechaInicioSuscripcion = Calendar.getInstance();
		fechaInicioSuscripcion.set(2016, 2, 31);
		Calendar fechaFinSuscripcion = Calendar.getInstance();
		fechaFinSuscripcion.set(2017, 2, 31);
		
		Suscribible laNacion = new Suscribible(30, 4);
		
		libreria.venderSuscripcion(1, fechaInicioSuscripcion.getTime(), fechaFinSuscripcion.getTime(), laNacion, true);
		
		double monto = libreria.calcularMontoACobrar(2016, 3, 1);

		Assert.assertEquals(96, monto, 0.5);
	}
}
