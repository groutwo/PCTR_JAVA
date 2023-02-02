public class monitorImpresion
{
	private static int nImpresoras = 3;
	private int impresorasDisponibles;
	private boolean[] impresoras = new boolean[nImpresoras];

	/** @param n_procesos Número de procesos */
	public monitorImpresion(int n_procesos)
	{	impresorasDisponibles = nImpresoras;
		for (int i = 0; i < impresoras.length; impresoras[i++] = true);
	}

	/**	@param hilo Identificador del hilo 	 */
	public synchronized int pedir_impresora()
	{	while (impresorasDisponibles == 0)
			try
			{	wait();} catch (InterruptedException e) { }
		int n = 0;
		while (!impresoras[n]) n++;
		--impresorasDisponibles;
		impresoras[n] = false;
		System.out.println(Thread.currentThread().getName() + " ha cogido a"
				+ " la impresora " + (n+1));
		return n;
	}

	/**	@param hilo Identificador del hilo */
	public synchronized void dejar_impresora(int n)
	{	impresoras[n] = true;
		++impresorasDisponibles;
		System.out.println(Thread.currentThread().getName()+" suelta la impresora "+(n+1));
		notifyAll();
	}
}