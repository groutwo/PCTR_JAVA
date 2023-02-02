import java.util.Random;

public class UsamonitorCadena extends Thread
{
	private static monitorCadena_1 monitor1 = new monitorCadena_1();
	private static monitorCadena_2 monitor2 = new monitorCadena_2();

	static int dimensiones = 2; //Está a 2, cambiar a 10
	static int cantidadMatrices = 8; //Está a 8, cambiar a 100
	static int[][][] matrizIntermedia = new int[cantidadMatrices][dimensiones][dimensiones];
	static int[][][] matrizFinal = new int[cantidadMatrices][dimensiones][dimensiones];
	int id;

	boolean usaMonitor1;

	public UsamonitorCadena(boolean usaMonitor1, int id)
	{	this.usaMonitor1 = usaMonitor1; this.id = id; }

	public void run()
	{ 	if (usaMonitor1)
		{	int[][] matriz = inicializa();
			monitor1.introducir_matriz(matriz, id);
			int[][] matriz2 = monitor1.retirar_matriz(id);
			System.out.println("          (Se transpone la matriz "+id+")");
			for (int i = 0; i < matriz2.length; i++)
				for (int j = 0; j < matriz2[0].length; matrizIntermedia[id][i][j] = matriz2[j++][i])
					/*System.out.println("\"Sea la matriz "+id+", en i = "+i+" y j = "+j+" ->"+matriz2[j][i]+"\"")*/;
		}
		else
		{	monitor2.introducir_matriz(matrizIntermedia[id], id);
			int[][] matriz3 = monitor2.retirar_matriz(id);
			monitor2.mostrarResultados(matriz3,id);
		}
	}

	/** @param args: no se usa */
	public static void main(String[] args)
	{	Thread[] hilos = new Thread[cantidadMatrices];

		for (int i = 0; i < hilos.length; hilos[i++].start())
			hilos[i] = new UsamonitorCadena(true, i);

		for (int i = 0; i < hilos.length; i++)
			try	{ hilos[i].join(); } catch (InterruptedException e)	{ }


		for (int i = 0; i < hilos.length; hilos[i++].start())
			hilos[i] = new UsamonitorCadena(false, i);

		for (int i = 0; i < hilos.length; i++)
			try	{ hilos[i].join(); } catch (InterruptedException e) { }
	}

	public static int[][] inicializa()
	{	int[][] m = new int[dimensiones][dimensiones];
		Random r = new Random();
		for (int i = 0; i < m.length; i++)
			for (int j = 0; j < m[0].length; j++)
				m[i][j] = 1 + r.nextInt(9);
		return m;
	}

	void muestraProductoDiagonalPrincipal(int[][] m, int id)
	{	int res = 1;
		for (int i = 0; i < m.length; i++)
			res *= m[i][i];
		System.out.println("El valor del producto de los elementos de la "
				+ "diagonal principal de la matriz " + id + " es " + res);
	}
}
