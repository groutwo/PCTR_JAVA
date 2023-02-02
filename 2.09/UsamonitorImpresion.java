/** @author Ignacio */
public class UsamonitorImpresion extends Thread
{
	private static monitorImpresion monitor;

	static int nNuc = Runtime.getRuntime().availableProcessors();
	static double Cb = 0.5;
	static int n_hilos = (int) (nNuc / (1 - Cb));

	public void run()
	{ 
		int impresora;
		do
		{ try 	{	
				impresora = monitor.pedir_impresora();	sleep(300);
				monitor.dejar_impresora(impresora);	sleep(150);
				} catch (InterruptedException e){ }
		} while (true);
	}

	/** @param args: No se utilizan parámetros por línea de comandos */
	public static void main(String[] args)
	{

		// UsamonitorImpresion[] hilos = new UsamonitorImpresion[n_hilos];
		monitor = new monitorImpresion(n_hilos);
		for (int i = 0; i < n_hilos;i++,new UsamonitorImpresion().start());
	}
}