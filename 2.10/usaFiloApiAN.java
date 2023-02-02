import java.util.concurrent.*;

/** @author Ignacio  */
public class usaFiloApiAN implements Runnable
{
	private static filoApiAN monitor = new filoApiAN();
	private int hilo;

	/** @param hilo Identificador del hilo */
	public usaFiloApiAN(int hilo)
	{ this.hilo = hilo; }

	public void run()
	{ while (true)
			try
			{	monitor.takeForks(hilo);
				Thread.sleep(300);
				monitor.releaseForks(hilo);
				Thread.sleep(500);
			} catch (Exception e) { }
	}

	/** @param args No se utilizan parámetros por línea de comandos */
	public static void main(String[] args)
	{ 	usaFiloApiAN[] hilos = new usaFiloApiAN[5];
		ExecutorService pool = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 5; pool.execute(hilos[i++]))
			hilos[i] = new usaFiloApiAN(i);
	}
}