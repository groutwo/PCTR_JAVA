import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class intParalelomultiCont implements Runnable
{
	static double Cb = 0.85; //Float.parseFloat(args[0]);
	static double numeroPuntos = 4000000, dentro = 0;
	static int nNuc = Runtime.getRuntime().availableProcessors();
	static int tamPool = (int) (nNuc / (1 - Cb));
	
	static int[] vector = new int[tamPool];
	int indice;

	public intParalelomultiCont(int i) { indice = i; }

	public void run()
	{	for (int i = 0; i < tamPool; i++)
		{	double x = Math.random(),y = Math.random();
			if (Math.sin(x) <= y) vector[i]++;
		}
	}

	public static void main(String[] args)
	{	System.out.println("Con un pool de tamaño de " + tamPool);
	
		ThreadPoolExecutor pool = new ThreadPoolExecutor(tamPool, tamPool, 0L,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
		
		double tInicio = System.currentTimeMillis();
		for (int i = 0; i < numeroPuntos / tamPool; )
			pool.execute(new intParalelomultiCont(i++));
		pool.shutdown();	while (!pool.isTerminated());
		double tFinal = System.currentTimeMillis() - tInicio;
		
		for (int i = 0; i < vector.length; dentro += vector[i++]);
		
		System.out.println("El area es " + dentro / numeroPuntos);
		System.out.println("Concurrentemente, tarda: " + tFinal + " milisegundos");
	}
}
