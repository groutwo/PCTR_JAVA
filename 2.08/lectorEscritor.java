public class lectorEscritor
{
	private int n;
	private boolean escribiendo;

	public lectorEscritor()
	{	n = 0;	escribiendo = false;	}

	/**	@param i:	Identificador del hilo */
	public synchronized void inicia_lectura(int i)
	{	while (escribiendo)
			try
			{	System.out.println("Lector " + i + " esperando...");
				wait();
			} catch (InterruptedException e) { }
		++n;
		System.out.println("Lector " + i + " leyendo...");
	}

	/** @param i Identificador del hilo */
	public synchronized void fin_lectura(int i)
	{	--n;  System.out.println("Lector " + i + " deja de leer...");
		notifyAll();
	}

	/**	@param i Identificador del hilo */
	public synchronized void inicia_escritura(int i)
	{	while (n > 0 || escribiendo)
			try
			{	System.out.println("Escritor " + i + " esperando...");
				wait();
			} catch (InterruptedException e) { }
		escribiendo = true;
		System.out.println("Escritor " + i + " escribiendo...");
	}

	/** @param i Identificador del hilo */
	public synchronized void fin_escritura(int i)
	{	escribiendo = false; System.out.println("Escritor " + i + " deja de escribir...");
		notifyAll();
	}
}