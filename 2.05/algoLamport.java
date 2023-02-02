import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**	@author Ignacio	*/
public class algoLamport implements Runnable
{
	static volatile int[] numero;
	static volatile boolean[] eligiendo;
	static volatile int n_proc = Runtime.getRuntime().availableProcessors();
	static volatile int MAX_VUELTAS = 10000;
	static volatile int variable;
	private int i;

	/**	@param i Identificador del hilo */
	public algoLamport(int i) { this.i = i; }

	public void run()
	{
		int vuelta = 1;
		do
		{	/* Calcula el número de turno */
			eligiendo[i] = true;
			numero[i] = 1 + max(numero);
			eligiendo[i] = false;
			/* Compara con todos los hilos */

			for (int j = 0; j < n_proc; j++)
			{	// Si el hilo j está calculando su número, espera a que termine 
				while (eligiendo[j]);
				/*
				 * Si el hilo j tiene más prioridad, espera a que ponga su n a 0
				 * j tiene + prioridad si su n de turno es más bajo que el de i,
				 * o bien si es el mismo número y además j es menor que i
				 */
				while ((numero[j] != 0) && ((numero[j] < numero[i]) || ((numero[j] == numero[i]) && j < i)));
			}

			/* Sección crítica */
			if (i % 2 == 0) variable++;
			else	variable--;
			/* Fin de sección crítica */

			numero[i] = 0;

			++vuelta;
		} while (vuelta <= MAX_VUELTAS);
	}

	/**
	 * @param v	Vector de enteros
	 * @return Máximo del vector
	 */
	private int max(int[] v)
	{	int max = v[0];
		for (int i = 1; i < v.length; i++)
			if (v[i] > max) max = v[i];
		return max;
	}

	public static void main(String[] args)
	{
		ExecutorService pool = Executors.newFixedThreadPool(n_proc);

		numero = new int[n_proc];
		eligiendo = new boolean[n_proc];
		algoLamport[] hilos = new algoLamport[n_proc];
		for (int i = 0; i < n_proc; pool.execute(hilos[i++]))
			hilos[i] = new algoLamport(i);

		pool.shutdown();
		while(!pool.isTerminated());
		System.out.println("Valor de la variable compartida: " + variable);
	}
}