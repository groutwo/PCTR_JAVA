import java.util.concurrent.locks.*;

/** @author Ignacio */
public class RWMonitorAN
{
	static Monitor monitor = new Monitor();

	static class Monitor
	{
		private final ReentrantLock cerrojo = new ReentrantLock();
		private final Condition hayEscritor = cerrojo.newCondition();
		private final Condition hayEscritorYLector = cerrojo.newCondition();
		private int readers = 0;
		private boolean writing = false;

		/** @param hilo Identificador del hilo */
		public void StartRead(int hilo) throws InterruptedException
		{	cerrojo.lock();
			try
			{	while (writing)
				{	System.out.println("Lector " + hilo + " esperando para leer.");
					hayEscritor.await();
				}
				System.out.println("Lector " + hilo + " comienza a leer.");
				readers++;
				hayEscritorYLector.signal();
			} finally
			{ cerrojo.unlock(); }
		}

		/** @param hilo Identificador del hilo */
		public void EndRead(int hilo) throws InterruptedException
		{ cerrojo.lock();
			try
			{	System.out.println("Lector " + hilo + " deja de leer.");
				readers--;
				if (readers == 0)	hayEscritorYLector.signal();
			} finally
			{ cerrojo.unlock(); }
		}

		/** @param hilo Identificador del hilo */
		public void StartWrite(int hilo) throws InterruptedException
		{ 	cerrojo.lock();
			try
			{	while (writing || readers == 0)
				{	System.out.println("Escritor " + hilo + " esperando para escribir.");
					hayEscritorYLector.await();
				}
				System.out.println("Escritor " + hilo + " comienza a escribir.");
				writing = true;
			} finally
			{ 	cerrojo.unlock();	}
		}

		/** @param hilo Identificador del hilo */
		public void EndWrite(int hilo) throws InterruptedException
		{ cerrojo.lock();
			try
			{	System.out.println("Escritor " + hilo + " deja de escribir.");
				writing = false;
				hayEscritor.signal();
			} finally
			{	cerrojo.unlock(); }
		}
	}

	static class Reader extends Thread
	{	private int hilo;

		/** @param hilo Identificador del hilo */
		public Reader(int hilo)
		{ this.hilo = hilo; }

		public void run()
		{ while (true)
				try
				{ monitor.StartRead(hilo);
					sleep(500);
					monitor.EndRead(hilo);
				} catch (Exception e) { }
		}
	}

	static class Writer extends Thread
	{ private int hilo;

		/** @param hilo Identificador del hilo */
		public Writer(int hilo)
		{ this.hilo = hilo; }

		public void run()
		{	while (true)
				try
				{ monitor.StartWrite(hilo);
					sleep(800);
					monitor.EndWrite(hilo);
				} catch (Exception e) { }
		}
	}

	/** @param args No se utilizan parámetros por línea de comandos */
	public static void main(String[] args)
	{
		new Writer(0).start(); new Writer(1).start();
		
		new Reader(0).start(); new Reader(1).start();
		new Reader(2).start(); new Reader(3).start();
	}
}