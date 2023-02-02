import java.io.RandomAccessFile;

/** @author Ignacio*/
public class RWFileMonitor
{
	private int readers = 0;
	private boolean writing = false;
	private RandomAccessFile fichero;

	public RWFileMonitor()
	{	try{ fichero = new RandomAccessFile("datos.txt", "rw");
		} catch (Exception e) {	}
	}

	/** @param hilo Identificador del hilo */
	public synchronized void StartRead(int hilo)
	{	while (writing)
			try {wait(); } catch (InterruptedException e) { }
		++readers;
		System.out.println("Lector " + hilo + " inicia lectura");
		notifyAll();
		try { fichero.seek(fichero.length()-1);	int value = fichero.read();
			System.out.println("El lector " + hilo + " ha leido: " + value);
		}catch (Exception e) { }
	}

	/** @param hilo: Identificador del hilo */
	public synchronized void EndRead(int hilo)
	{	--readers;
		if (readers == 0) notifyAll();
		System.out.println("Lector " + hilo + " finaliza lectura");
	}

	/** @param hilo: Identificador del hilo
	 * @param value: valor que será escrito
	 */
	public synchronized void StartWrite(int hilo, int value)
	{ 	while (writing || readers != 0)
			try{ wait(); } catch (InterruptedException e) { }
		writing = true;
		System.out.println("Escritor " + hilo + " escribe un " + value);
		try { fichero.seek(fichero.length()); fichero.write(value);
		} catch (Exception e) { }
	}

	/** @param hilo Identificador del hilo  */
	public synchronized void EndWrite(int hilo)
	{	writing = false; 	notifyAll();
		System.out.println("Escritor " + hilo + " finaliza escritura");
	}
}
