import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**	@author Ignacio	 */
public class algEisenbergMcGuire implements Runnable
{
	public enum Estado { IDLE, ESPERANDO, ACTIVO };

	// La variable flags (Bandera) de cada hilo se pone en estado ESPERANDO cada
	// vez que tiene intenci�n de entrar en la secci�n cr�tica. La variable
	// flags es inicializada en IDLE (Inactivo):
	static volatile Estado flags[];
	// A la variable turno se le asigna aleatoriamente un valor entre
	// 0 y n-1 al incio del algoritmo.
	static volatile int turno, cont = 0, n = 2;
	static volatile int MAX_VUELTAS = 100000;
	private int i = 0;

	/**	@param i Identificador del hilo	*/
	public algEisenbergMcGuire(int i) { this.i = i; }

	public void run()
	{ int indice,vuelta = 1;
		do
		{ 	do
			{	// Anunciar que necesitamos el recurso
				flags[i] = Estado.ESPERANDO;
				// Escanear los procesos partiendo desde el que posee el turno.
				// Repite hasta encontrar todos los procesos en IDLE
				indice = turno;
				while (indice != i)
					if (flags[indice] != Estado.IDLE)	indice = turno;
					else								indice = (indice + 1) % n;
				
				// Reclamamos temporalmente el recurso
				flags[i] = Estado.ACTIVO;
				// Encontrar el primer proceso activo adem�s de nosotros, si existe
				indice = 0;
				while ((indice < n) && ((indice == i) || (flags[indice] != Estado.ACTIVO)))
					indice++;

				// Si no hay otros procesos activos,y tenemos el turno,
				// o si todos todos los dem�s tienen estado IDLE, proceder,
				// en otro caso, repetir
			} while ((indice < n) && ((turno != i) || (flags[turno] != Estado.IDLE)));
			turno = i;

			/* INICIO SECCI�N CR�TICA */
			if (turno == 0) cont++;
			else cont--;
			/* reclamar el turno y proceder */
			// C�digo de Secci�n Cr�tica
			/* FIN de SECCI�N CR�TICA */

			/* Encuentra un proceso que no est� IDLE */
			/* (Si no hay otro nos encontraremos a nosotros mismos.) */
			indice = (turno + 1) % n;
			while (flags[indice] == Estado.IDLE)
				indice = (indice + 1) % n;
			// Dar el turno a una hebra que lo necesita, o mantenerlo
			turno = indice;
			// Hemos acabado
			flags[i] = Estado.IDLE;
			// Secci�n de restante
			System.out.println("Vuelta: " + vuelta + "  Valor de cont: " + cont);
			vuelta++;
		} while (vuelta <= MAX_VUELTAS);
	}

	public static void main(String[] args)
	{
		flags = new Estado[n];
		cont=0;
		int nProc = Runtime.getRuntime().availableProcessors();

		ExecutorService pool = Executors.newFixedThreadPool(nProc);

		pool.execute(new algEisenbergMcGuire(0));
		pool.execute(new algEisenbergMcGuire(1));

		pool.shutdown();
		while(!pool.isTerminated());

	}
}
