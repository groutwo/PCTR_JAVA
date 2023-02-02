/**	@author Ignacio */
public class UsaRWFileMonitor extends Thread
{
	private static RWFileMonitor monitor = new RWFileMonitor();
	private int hilo;
	private boolean escritor;

	/** @param hilo: Identificador del hilo
	 * @param e:	 Booleano que indica si es esctritor(true) o lector(false)
	 */
	public UsaRWFileMonitor(int hilo, boolean e)
	{ this.hilo = hilo; escritor = e; }

	public void run()
	{	while (true)
			if (escritor)
				try
				{	int value = (int) (Math.random() * 9);
					monitor.StartWrite(hilo, value); sleep(300);
					monitor.EndWrite(hilo);			 sleep(50);
				} catch (Exception e) {}
			else
				try
				{	monitor.StartRead(hilo); sleep(200);
					monitor.EndRead(hilo);	 sleep(200);
				} catch (Exception e) {}
	}

	/** @param args: No se utilizan parámetros por línea de comandos */
	public static void main(String[] args)
	{	new UsaRWFileMonitor(1, true).start();
		new UsaRWFileMonitor(1, false).start();
		new UsaRWFileMonitor(2, true).start();
		new UsaRWFileMonitor(2, false).start();
	}
}