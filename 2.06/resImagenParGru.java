import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**	@author Ignacio	*/
public class resImagenParGru implements Runnable
{
	public static int[][] matriz;
	public int f;
	public static int filas, columnas;
	static Scanner sc = new Scanner(System.in);
	static int nProc = Runtime.getRuntime().availableProcessors();
	static ExecutorService p = Executors.newFixedThreadPool(nProc);

	public resImagenParGru(int f)
	{ this.f = f; filas = matriz.length; columnas = matriz[0].length;	}

	/**
	 * Aplica la propiedad que se pide para la fila de la matriz que se le pase
	 * al ctor. Esto se lleva a cabo mediante el lanzamiento de hilos con la
	 * interfaz runnable
	 */
	public void run()
	{
		int [][] m1=new int[matriz.length][matriz[0].length];
		
			for(int col=0;col<matriz[0].length;++col)
			{	int aux=4*matriz[f][col];
				if(f-1>=0) 					aux-=matriz[f-1][col];
				if(col-1>=0) 				aux-=matriz[f][col-1];
				if(f+1<=matriz.length-1) 	aux-=matriz[f+1][col];
				if(col+1<=matriz.length-1) 	aux-=matriz[f][col+1];
				m1[f][col]=aux/8;
			}
		matriz = m1;
	}

	public static void main(String[] args)
	{
		double t1 = 0, t2 = 0;
		System.out.println("Introduce el tamaño de las filas de la  matriz");	int filas = sc.nextInt();
		System.out.println("Introduce el tamaño de las columnas de la  matriz");int columnas = sc.nextInt();
		matriz = new int[filas][columnas];
		
		inicializarMatriz(matriz);
		System.out.println("Iniciamos el cronometro");
		
		t1 = System.currentTimeMillis();
		for (int i = 0; i < filas; i++)
			p.execute(new resImagenParGru(i));
		p.shutdown();
		while (!p.isTerminated());
		t2 = System.currentTimeMillis() - t1;

		if (t2 < 1000)	System.out.println("Ha tardado " + t2 + " milisegundos");
		else		System.out.println("Ha tardado " + t2 / 1000 + " segundos");

		if (filas < 30 && columnas < 30)	imprimirMatriz(matriz);
	}

	/** Inicializa la matriz
	 * 
	 * @param matriz
	 * @return la matriz inicializada con valores aleatorios
	 */
	public static int[][] inicializarMatriz(int[][] matriz)
	{	Random rand = new Random(System.nanoTime());

		for (int i = 0; i < matriz.length; ++i)
			for (int j = 0; j < matriz[0].length; ++j)
				matriz[i][j] = 100 + rand.nextInt(1000);
		return matriz;
	}

	/**Imprime la matriz que recibe
	 * 
	 * @param matriz	
	 */
	public static void imprimirMatriz(int[][] matriz)
	{
		for (int i = 0; i < matriz.length; ++i)
		{
			System.out.print("[ ");
			for (int j = 0; j < matriz[0].length; ++j)
				System.out.print(matriz[i][j] + " ");
			System.out.println("]");
		}
	}
}
