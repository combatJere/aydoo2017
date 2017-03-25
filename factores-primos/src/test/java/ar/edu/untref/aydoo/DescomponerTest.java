package ar.edu.untref.aydoo;

import org.junit.Test;

import java.util.LinkedList;

import org.junit.Assert;

public class DescomponerTest {
	
	@Test
	public void DescomponerFunciona90(){
		DescomponedorFactoresPrimos descomponedor = new DescomponedorFactoresPrimos();
		LinkedList<Integer> numero90Descompuesto =descomponedor.descomponer(90);
		LinkedList<Integer> numero360Descompuesto =descomponedor.descomponer(360);
		
		Assert.assertEquals(4, numero90Descompuesto.size());
		Assert.assertEquals(2, (int)numero90Descompuesto.get(0));
		Assert.assertEquals(3, (int)numero90Descompuesto.get(1));
		Assert.assertEquals(3, (int)numero90Descompuesto.get(2));
		Assert.assertEquals(5, (int)numero90Descompuesto.get(3));
		
		Assert.assertEquals(6, numero360Descompuesto.size());
		Assert.assertEquals(2, (int)numero360Descompuesto.get(0));
		Assert.assertEquals(2, (int)numero360Descompuesto.get(1));
		Assert.assertEquals(2, (int)numero360Descompuesto.get(2));
		Assert.assertEquals(3, (int)numero360Descompuesto.get(3));
		Assert.assertEquals(3, (int)numero360Descompuesto.get(4));
		Assert.assertEquals(5, (int)numero360Descompuesto.get(5));
	}
}
