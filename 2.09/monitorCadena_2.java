public class monitorCadena_2
{
	int elementos = 0;
	int elementosMaximo = 4; //Está a 4, cambiar a 50

	/** @param matriz: Matriz  a introducir*/
	public synchronized void introducir_matriz(int[][] matriz,int pos)
	{	while (elementos == elementosMaximo)
			try {	System.out.println("---Buffer 2 lleno ("+elementosMaximo+")"); wait();
			} catch (InterruptedException e){ }
		++elementos;
		System.out.println("Sea la matriz de la pos"+pos);
		for (int i = 0; i < matriz.length; i++)
		{	for (int j = 0; j < matriz.length; System.out.print(matriz[i][j++]+" "))
				UsamonitorCadena.matrizFinal[pos][i][j] = matriz[i][j];
			System.out.println();
		}
		System.out.println(" en la posicion " + pos + " del buffer 2");
		notifyAll();
	}

	/**	@return Matriz de la posición "pos */
	public synchronized int[][] retirar_matriz(int pos)
	{	while (elementos == 0)
			try { System.out.println("---Buffer 2 vacío"); wait();
				} catch (InterruptedException e) { }
		int[][] matriz = new int[UsamonitorCadena.matrizFinal[0].length][UsamonitorCadena.matrizFinal[0].length];
		for (int i = 0; i < matriz.length; i++)
			for (int j = 0; j < matriz.length; j++)
				matriz[i][j] = UsamonitorCadena.matrizFinal[pos][i][j];
		System.out.println("Se ha sacado la matriz " + pos + " del buffer1");
		--elementos;	notifyAll();
		return matriz;
	}
	
	public synchronized void mostrarResultados(int[][]matriz3,int id)
	{	for (int i = 0; i < matriz3.length; i++)
			for (int j = 0; j < matriz3[0].length; j++)
				UsamonitorCadena.matrizFinal[id][i][j] = matriz3[i][j];
		int res = 1;
		for (int i = 0; i < matriz3.length; i++)
			res *= matriz3[i][i];
		System.out.println("El valor del producto de los elementos de la "
				+ "diagonal principal de la matriz " + id + " es " + res);	}
}