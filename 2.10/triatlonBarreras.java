import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**@author Ignacio */
public class triatlonBarreras implements Runnable
{
	static int n_competidores = 100;
	private static int[] tiempos = new int[n_competidores];
	private int hilo;
	private static CyclicBarrier barrera1 = new CyclicBarrier(n_competidores);
	private static CyclicBarrier barrera2 = new CyclicBarrier(n_competidores);
	private Random r = new Random();
	/** @param hilo Identificador del hilo 	 */
	public triatlonBarreras(int hilo)
	{ this.hilo = hilo; }

	public void run()
	{	int tiempo;
		try
		{	
			tiempos[hilo] = (tiempo = r.nextInt(500) + 500);
			System.out.println("El hilo " +(hilo<9? "0":"") + (hilo + 1) + " ha terminado la carrera de natación en " + tiempo + " ms.");
			barrera1.await();
			
			tiempos[hilo] += (tiempo = r.nextInt(300) + 500);

			System.out.println("El hilo " +(hilo<9? "0":"") + (hilo + 1) + " ha terminado la carrera ciclista en " + tiempo + " ms.");
			barrera2.await();
			
			tiempos[hilo] += (tiempo = r.nextInt(400)+500);
			System.out.println("El hilo " +(hilo<9? "0":"") + (hilo + 1) + " ha terminado la carrera a pie en " + tiempo + " ms.");
			
		} catch (Exception e){}
	}

	/** @param args No se utilizan parámetros por línea de comandos */
	public static void main(String[] args) throws Exception
	{
		Thread[] hilos_thread = new Thread[n_competidores];
		
		for (int i = 0; i < n_competidores; hilos_thread[i++].start())
			hilos_thread[i] = new Thread(new triatlonBarreras(i));
		
		for (int i = 0; i < n_competidores; i++)
			hilos_thread[i].join();
		
		System.out.println("\nYa ha terminado el triatlon.\n");
		int tiempoGanador = 999999999;
		int ganador = -1;
		for (int i = 0; i < n_competidores; i++)
			if (tiempos[i] < tiempoGanador)
			{
				tiempoGanador = tiempos[i];
				ganador = i;
			}

		System.out.println("El ganador ha sido el " + ganador + " con " + tiempoGanador + " ms!!");
		System.out.println("\nFin de la ejecución...\n");
	}
}