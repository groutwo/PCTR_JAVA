import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/** @author Ignacio  */
public class matVector
{
	static int[][] a;
	static int[] b, c;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
		System.out.print("Introduce el numero de filas: "); 	int filas = sc.nextInt();
		System.out.print("Introduce el numero de columnas: "); 	int columnas = sc.nextInt();
		
		a = new int[filas][columnas];	b = new int[columnas]; 	c = new int[filas];
		
		System.out.println("\nElije una opcion: "
				+ "\n1: Introducir elementos."
				+ "\nOtro:	Generar numeros aleatorios.");
		if (sc.nextInt() == 1) 	introduceElementos(filas, columnas);
		else					generaAleatorio(filas, columnas);

		System.out.println("Vamos ahora con la medicion de tiempos:");
		contarTiempo(filas, columnas);
		
		System.out.println("Si quieres mostrar por pantalla el resultado, pulsa 1:");
		if(sc.nextInt() == 1)
			System.out.println(Arrays.toString(c));
		
		sc.close();
		System.out.println("Fin");
	}

	/** Indica, en milisegundos, el tiempo que tarda en ejecutar las operaciones secuencialmente
	 * 
	 * @param filas
	 * @param columnas
	 */
	private static void contarTiempo(int filas, int columnas)
	{	double tInicio = System.nanoTime(), tFinal;
	
		for (int fil = 0; fil < filas; fil++)
			for (int col = 0; col < columnas; col++)
				c[fil] += a[fil][col] * b[col];

		tFinal = System.nanoTime() - tInicio;
		System.out.println("Secuencialmente, tarda: " + tFinal / 1000000 + " milisegundos");
	}

	/**	Método que permite inicializar los vectores manualmente
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
	
	/**	Método que permite inicializar los vectores aleatoriamente
	 * 
	 * @param filas
	 * @param columnas
	 */
	private static void generaAleatorio(int filas, int columnas)
	{	for (int fil = 0; fil < filas; fil++)
			for (int col = 0; col < columnas; col++)
			{
				a[fil][col] = 1 + new Random().nextInt(9);
				b[col] = 1 + new Random().nextInt(9);
			}

	}
}