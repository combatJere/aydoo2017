package ar.edu.untref.aydoo;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class VenderProductoTest {

	@Test
	public void venderProducto(){
		Libreria libreria  = new Libreria();
		libreria.agragarCliente(1, "02320-2344234", "Delia 1000");
		
		Calendar fechaCompra = Calendar.getInstance();
		fechaCompra.set(2016, 2, 31);
		
		Libro libro = new Libro(50);
		
//		System.out.println(fechaCompra.get(Calendar.YEAR));
//		System.out.println(fechaCompra.get(Calendar.MONTH));
//		System.out.println(fechaCompra.get(Calendar.DATE));
//		
//		Date d  = fechaCompra.getTime();
//		Calendar c = Calendar.getInstance();
//		c.setTime(d);
//		
//		System.out.println(fechaCompra.get(c.YEAR));
//		System.out.println(fechaCompra.get(c.MONTH));
//		System.out.println(fechaCompra.get(c.DATE));

		
		libreria.venderProducto(1, fechaCompra.getTime(), libro);
		
	}
	
}
