import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** @author Ignacio */
public class matVectorConcurrenteGranoGrueso implements Runnable
{
	static Scanner sc = new Scanner(System.in);
	static int[][] a;
	static int[] b, c;
	int filaActual,columnas;

	/** Constuctor 
	 * 
	 * @param fila filas de la matriz
	 * @param columnas columnas de la matriz
	 */
	public matVectorConcurrenteGranoGrueso(int fila, int columnas)
	{ filaActual = fila; this.columnas = columnas; }

	/** Da valores a un vector, a partir de multiplicar una matriz y otro vector 	 */
	public void run()
	{ for (int col = 0; col < columnas; col++)	c[filaActual]+=a[filaActual][col]*b[col]; }

	public static void main(String[] args)
	{
		System.out.print("Introduce el numero de filas: "); 	int filas = sc.nextInt();
		System.out.print("Introduce el numero de columnas: "); 	int columnas = sc.nextInt();
		a = new int[filas][columnas]; b = new int[columnas]; c = new int[filas];

		System.out.println("\nElije una opcion: "
				+ "\n1: Introducir elementos."
				+ "\nOtro:	Generar numeros aleatorios.");
		if (sc.nextInt() == 1) 	introduceElementos(filas, columnas);
		else					generaAleatorio(filas, columnas);

		if (filas < 20)
		{	System.out.println(a.toString());System.out.println(b.toString()); }
		
		System.out.println("Vamos ahora con la medicion de tiempos:");
		double tInicio = System.nanoTime(), tFinal;
		ExecutorService pool = Executors.newCachedThreadPool();

		for (int fil = 0; fil < filas; fil++)
			pool.execute(new matVectorConcurrenteGranoGrueso(fil, columnas));
		
		pool.shutdown();
		while (!pool.isTerminated());

		tFinal = System.nanoTime() - tInicio;
		System.out.println("Concurrentemente, tarda: " + tFinal / 1000000 + " milisegundos");

		if (filas < 20)
			System.out.println(c.toString());

	}

	/**	Pide valores para inicializar la matriz y el vector
	 * 
	 * @param filas
	 * @param columnas
	 */
	private static void introduceElementos(int filas, int columnas)
	{	for (int fil = 0; fil < filas; fil++)
			for (int col = 0; col < columnas; a[fil][col++] = sc.nextInt())
				System.out.print("Introduce valor para a[" + (fil + 1) + "][" + (col + 1) + "]: ");
		
		System.out.println("Hemos creado a. Ahora b:");
		
		for (int col = 0; col < columnas; b[col++] = sc.nextInt())
			System.out.print("Introduce valor para b[" + (col + 1) + "]: ");
	}

	/**	Genera numeros aleatorios para inicializar matiz y vector
	 * 
	 * @param filas
	 * @param columnas
	 */
	private static void generaAleatorio(int filas, int columnas)
	{
		for (int fil = 0; fil < filas; fil++)
			for (int col = 0; col < columnas; b[col++] = 1 + new Random().nextInt(9))
				a[fil][col] = 1 + new Random().nextInt(9);
	}
}
