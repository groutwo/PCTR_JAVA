public class monitorCadena_1
{
	int elementos = 0;
	int elementosMaximo = 7; //Está a 7, cambiar a 100

	/**	@param matriz Matriz a introducir */
	public synchronized void introducir_matriz(int[][] matriz, int pos)
	{	System.out.println("Sea la matriz:");
		for (int i = 0; i < matriz.length; i++)
		{	for (int j = 0; j < matriz.length; j++)
				System.out.print(matriz[i][j]+" ");
			System.out.println();
		}
		while (elementos >= elementosMaximo)
			try	{	System.out.println("---Buffer 1 lleno ("+elementosMaximo+" max)");	wait();
			} catch (InterruptedException e) { }
		++elementos;
		for (int i = 0; i < matriz.length; i++)
			for (int j = 0; j < matriz.length; j++)
				UsamonitorCadena.matrizIntermedia[pos][i][j] = matriz[i][j];
		System.out.println("Se introduce en el buffer1 en la posicion " + pos);
		notifyAll();
	}

	/**	@return Matriz de la posición "pos" */
	public synchronized int[][] retirar_matriz(int pos)
	{	while (elementos == 0)
			try { System.out.println("----Buffer 1 vacio"); wait();
			} catch (InterruptedException e) { }
		--elementos;
		int[][] matriz = new int[UsamonitorCadena.matrizIntermedia[0].length][UsamonitorCadena.matrizIntermedia[0].length];
		for (int i = 0; i < matriz.length; i++)
			for (int j = 0; j < matriz[0].length; j++)
				matriz[i][j] = UsamonitorCadena.matrizIntermedia[pos][i][j];
		System.out.println("Se ha sacado la matriz " + pos + " del buffer1");
		notifyAll();
		return matriz;
	}
}