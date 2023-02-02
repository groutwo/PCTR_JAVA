public class usalectorEscritor
{
	private static lectorEscritor monitor = new lectorEscritor();

	/** @author Ignacio */
	static class LectorEsctitor extends Thread
	{
		private int hilo;
		boolean escritor;

		/** @param hilo: Identificador del hilo
		 * @param escritor: Booleano que indica si el hilo es escritor(true) o lector(false)
		 */
		public LectorEsctitor(int hilo, boolean escritor)
		{ this.hilo = hilo; this.escritor = escritor; }

		public void run()
		{	while (true)
				try
				{	if (escritor) 	monitor.inicia_escritura(hilo);
					else			monitor.inicia_lectura(hilo);
					sleep(600);
					if (escritor)	monitor.fin_escritura(hilo);
					else			monitor.fin_lectura(hilo);
					sleep(200);
				} catch (InterruptedException e) {	}
		}
	}

	/** @param args: No se utilizan parámetros por linea de comandos */
	public static void main(String[] args)
	{for (int i = 0; i < 10; new LectorEsctitor(i++, false).start())
			new LectorEsctitor(i, true).start();
	}
}