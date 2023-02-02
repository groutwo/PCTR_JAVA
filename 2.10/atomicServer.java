import java.net.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

/**@author Ignacio */
public class atomicServer implements Runnable
{
	static AtomicLong contador = new AtomicLong(1);
	private Socket enchufe;
	private int hilo;

	/** @param enchufe Socket a conectar
	 * 	@param hilo Identificador del hilo
	 */
	public atomicServer(Socket enchufe, int hilo)
	{ this.enchufe = enchufe; this.hilo = hilo; }

	public void run()
	{	
		System.out.println("Hilo del servidor " + hilo + " conectado a " + enchufe + "...");
		contador.incrementAndGet();
	}

	/** @return Número de hilos a crear */
	private static int Subramanian()
	{	int nNuc = Runtime.getRuntime().availableProcessors();	double CB = 0.85;
		return (int) (nNuc / (1 - CB));
	}

	/** @param args No se usa */
	public static void main(String[] args)
	{
		int i = 1, puerto = 2001, n_hilos = Subramanian();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(n_hilos, n_hilos, 0L,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		try
		{	ServerSocket servidor = new ServerSocket(puerto, 3000);
			while (true)
			{	System.out.println("\nS.AtomicLong esperando solicitud ...");
				Socket cable = servidor.accept();
				System.out.println("\nRecibida solicitud de conexión...");
				pool.execute(new atomicServer(cable, i));
				i++; 
			}
		} catch (Exception e)
		{ System.out.println("\nError en sockets...\n"); }
	}
}