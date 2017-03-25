package ar.edu.untref.aydoo;

import java.util.LinkedList;

import ar.edu.untref.aydoo.interfaces.IDescomponedorFactores;

public class Program 
{
	static IDescomponedorFactores descomponedor;
	
	//public Program(){
		//descomponedor = new DescomponedorFactoresPrimos();
	//}
	
    public static final void main(String arg[])
    {
    	int numero = Integer.parseInt(arg[0]);
    	descomponedor = new DescomponedorFactoresPrimos();
    	LinkedList<Integer> numeroDescompuesto = descomponedor.descomponer(numero);
    	
    	System.out.println(numeroDescompuesto);
    }
}
