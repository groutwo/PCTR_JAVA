import java.net.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/** @author Ignacio  */
public class reentrantServer implements Runnable
{	static final ReentrantLock cerrojo = new ReentrantLock();
	static int contador = 1;
	private Socket enchufe;
	private int hilo;

	/** @param enchufe Socket a conectar
	 * @param hilo Identificador del hilo
	 */
	public reentrantServer(Socket enchufe, int hilo)
	{ this.enchufe = enchufe; this.hilo = hilo; }

	public void run()
	{ cerrojo.lock();
		try{ System.out.println("Hilo del servidor " + hilo + " conectado a " + enchufe + "...");
			contador++; } finally { cerrojo.unlock(); }
	}

	/** @return Número de hilos a crear */
	private static int Subramanian()
	{ 	int nNuc = Runtime.getRuntime().availableProcessors();	double CB = 0.85;
		return (int) (nNuc / (1 - CB));
	}

	/** @param args No se utilizan parámetros por línea de comandos */
	public static void main(String[] args)
	{
		int i = 1, puerto = 2002, n_hilos = Subramanian();
		ThreadPoolExecutor pool = new ThreadPoolExecutor(n_hilos, n_hilos, 0L,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		try
		{	ServerSocket server = new ServerSocket(puerto, 3000);
			while (true)
			{	System.out.println("\nS.ReentrantLock esperando solicitud ...");
				Socket cable = server.accept();
				System.out.println("\nRecibida solicitud de conexión...");
				pool.execute(new reentrantServer(cable, i));
				i++;
			}
		} catch (Exception e)
		{ System.out.println("\nError en sockets...\n"); }
		}
}