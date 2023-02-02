import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Ignacio
 *
 */
public class resImagen
{
	public static int[][] matriz, mR;
	static Scanner sc = new Scanner(System.in);

	/**
	 * 
	 * @param matriz Aplica la propiedad indicada en el problema
	 */
	public static int[][] filtro(int[][] m0)
	{
		int [][] m1=new int[m0.length][m0[0].length];
		
		for(int i=0;i<m0.length;++i){
			for(int j=0;j<m0[0].length;++j){
				int aux=4*m0[i][j];
				if(i-1>=0) aux-=m0[i-1][j];
				if(j-1>=0) aux-=m0[i][j-1];
				if(i+1<=m0.length-1) aux-=m0[i+1][j];
				if(j+1<=m0.length-1) aux-=m0[i][j+1];
				m1[i][j]=aux/8;
			}
		}
		return m1;
	}

	/**
	 * 
	 * @param args no se usa
	 */
	public static void main(String[] args)
	{
		double t1 = 0, t2 = 0;
		System.out.println("Introduce el tamaño de las filas de la  matriz"); 	int filas = sc.nextInt();
		System.out.println("Introduce el tamaño de las columnas de la  matriz");int columnas = sc.nextInt();
		matriz = new int[filas][columnas];
		matriz = inicializarMatriz(matriz);
		System.out.println("Iniciamos el cronometro");
		
		t1 = System.currentTimeMillis();
		matriz = filtro(matriz);
		t2 = System.currentTimeMillis() - t1;
		
		if (t2 < 1000) 	System.out.println("Ha tardado " + t2 + " milisegundos");
		else			System.out.println("Ha tardado " + t2 / 1000 + " segundos");

		if (filas < 30 && columnas < 30) System.out.println(Arrays.deepToString(matriz));
	}

	/**
	 * 
	 * @param matriz
	 * @return la matriz inicializada con valores aleatorios
	 */
	public static int[][] inicializarMatriz(int[][] matriz)
	{ 	Random rand = new Random(System.nanoTime());

		for (int i = 0; i < matriz.length; ++i)
			for (int j = 0; j < matriz[0].length; matriz[i][j++] = 100 + rand.nextInt(1000));
		return matriz;
	}

	/**
	 * 
	 * @param matriz imprime la matriz que recibe
	 */
	public static void imprimirMatriz(int[][] matriz)
	{	for (int i = 0; i < matriz.length; ++i)
		{
			System.out.print("[ ");
			for (int j = 0; j < matriz[0].length; ++j)
				System.out.print(matriz[i][j] + " ");
			System.out.println("]");
		}
	}
}
