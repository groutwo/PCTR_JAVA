import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class intParalelauniCont implements Runnable
{
	static double Cb = 0.85; //Float.parseFloat(args[0]);
	static double numeroPuntos = 4000000, dentro = 0;
	static int nNuc = Runtime.getRuntime().availableProcessors();
	static int tamPool = (int) (nNuc / (1 - Cb));
	static Object o=new Object();


	public void run()
	{	double x = Math.random(), y = Math.random();
		if (Math.sin(x) <= y)
			synchronized (o)
			{	dentro++; }
	}

	public static void main(String[] args)
	{	System.out.println("Con un pool de tamaño de " + tamPool);
		
		ThreadPoolExecutor pool = new ThreadPoolExecutor(tamPool, tamPool, 0L,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		
		double tInicio = System.currentTimeMillis(), tFinal;
		
		for (int i = 0; i < numeroPuntos; i++)	pool.execute(new intParalelauniCont());
		
		pool.shutdown();
		while (!pool.isTerminated());

		tFinal = System.currentTimeMillis() - tInicio;
		System.out.println("El area es " + dentro / numeroPuntos);
		System.out.println("Concurrentemente, tarda: " + tFinal + " milisegundos");
	}

}
