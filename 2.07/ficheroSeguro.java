import java.io.*;
import java.util.concurrent.*;

public class ficheroSeguro implements Runnable
{
	static int nNucleos = Runtime.getRuntime().availableProcessors();
	static ExecutorService pool = Executors.newFixedThreadPool(nNucleos);
	static RandomAccessFile fichero;
	static String cad = "123456789";
	int pos;

	public ficheroSeguro(int pos)	{	this.pos = pos;	}

	public void run()
	{	
		synchronized(fichero) {
			System.out.println(pos+1);
			try	{	fichero.write(cad.charAt(pos));} catch (IOException e)	{ }
		}
	}

	public static void main(String[] args) 
	{	try {fichero = new RandomAccessFile("prueba.txt", "rw");	} catch (FileNotFoundException e) {	}
	
		for (int pos = 0; pos < cad.length(); pool.execute(new ficheroSeguro(pos++)));
		pool.shutdown();	while (!pool.isTerminated());
		System.out.println("Fin");

		try {fichero.close();} catch (IOException e) {	}
	}
}
