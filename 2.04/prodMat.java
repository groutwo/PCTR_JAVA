import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/**	@author Ignacio	 */
public class prodMat
{
	static int[][] a, b, c;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
		System.out.print("Introduce el numero de filas de la matriz A: "); 		int filasA = sc.nextInt();
		System.out.print("Introduce el numero de columnas de la matriz A: ");	int columnasA = sc.nextInt();
		int filasB = columnasA;
		System.out.println("El numero de filas de la matriz B es " + filasB);
		System.out.print("Introduce el numero de columnas de la matriz B: ");	int columnasB = sc.nextInt();
		
		a = new int[filasA][columnasA];		b = new int[filasB][columnasB];		c = new int[filasA][columnasB];
		
		System.out.println("\nElije una opcion: "
				+ "\n1: Introducir elementos."
				+ "\nOtro:	Generar numeros aleatorios.");
		if (sc.nextInt() == 1) 	introduceElementos(filasA, columnasA, columnasB);
		else			generaAleatorio(filasA, columnasA, columnasB);

		System.out.println("Vamos ahora con la medicion de tiempos:");
		contarTiempo(filasA, columnasA, columnasB);
		
		System.out.println("Si quieres mostrar por pantalla el resultado, pulsa 1:");
		if(sc.nextInt() == 1)
			System.out.println(Arrays.deepToString(c));
		
		sc.close();
		System.out.println("Fin");
    	
	}

	/** Indica, en milisegundos, el tiempo que tarda en ejecutar las operaciones secuencialmente
	 * 
	 * @param filasA
	 * @param columnasA
	 * @param columnasB
	 */
	private static void contarTiempo(int filasA, int columnasA, int columnasB)
	{//		recordemos que filasB = columnasA;
		double tInicio = System.nanoTime(), tFinal;
		for (int fila = 0; fila < filasA; fila++)
			for (int columnaB = 0; columnaB < columnasB; columnaB++)
				for (int columnaA = 0; columnaA < columnasA; columnaA++)
					c[fila][columnaB] += a[fila][columnaA] * b[columnaA][columnaB];

		tFinal = System.nanoTime() - tInicio;
		System.out.println("Secuencialmente, tarda: " + tFinal / 1000000 + " milisegundos");
	}

	/** Método que permite inicializar las matrices manualmente
	 * 
	 * @param filasA
	 * @param columnasA
	 * @param columnasB
	 */
	private static void introduceElementos(int filasA, int columnasA, int columnasB)
	{//		recordemos que filasB = columnasA;
		System.out.println("Creamos la matriz A: ");
		for (int fila = 0; fila < filasA; fila++)
			for (int columna = 0; columna < columnasA; columna++)
			{
				System.out.print("Introduce valor para a[" + (fila + 1) + "][" + (columna + 1) + "]: ");
				a[fila][columna] = sc.nextInt();
			}
		System.out.println("Creamo la matriz B: ");

		for (int fila = 0; fila < columnasA; fila++)
			for (int columna = 0; columna < columnasB; columna++)
			{
				System.out.print("Introduce valor para b[" + (fila + 1) + "][" + (columna + 1) + "]: ");
				b[fila][columna] = sc.nextInt();
			}
	}
	
	/**	Método que permite inicializar la matriz aleatoriamente
	 * 
	 * @param filasA
	 * @param columnasA
	 * @param columnasB
	 */
	private static void generaAleatorio(int filasA, int columnasA, int columnasB)
	{//		recordemos que filasB = columnasA;
		for (int fil = 0; fil < filasA; fil++)
			for (int col = 0; col < columnasA; col++)
				a[fil][col] = 1 + new Random().nextInt(9);
		
		for (int fil = 0; fil < columnasA; fil++)
			for (int col = 0; col < columnasB; col++)
				b[fil][col] = 1 + new Random().nextInt(9);
	}
}