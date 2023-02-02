import java.util.ArrayList;
import java.util.concurrent.*;

public class intParaleloFutureCont2 implements Callable<Integer>
{
	static double numeroPuntos = 1000000, dentro = 0;
	int indice;
	static int tamPool;
	private Integer total = Integer.valueOf(0);
	static Object o=new Object();

	public intParaleloFutureCont2(int i)
	{
		indice = i;
	}

	public Integer call()
	{
		for (int i = 0; i < tamPool; i++)
		{
			double x = Math.random();
			double y = Math.random();
			if (x * x + y * y <= 1)
				synchronized (o)
				{	total++;	}
		}
		return total;
	}

	public static void main(String[] args)
	{
		int nNuc = Runtime.getRuntime().availableProcessors();
		double Cb = 0.85;// Float.parseFloat(args[0]);
		tamPool = (int) (nNuc / (1 - Cb));
		System.out.println("Con un pool de tamaño de " + tamPool);

		ArrayList<Future<Integer>> contParciales = new ArrayList<Future<Integer>>();

		ThreadPoolExecutor pool = new ThreadPoolExecutor(tamPool, tamPool, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());

		double tInicio = System.currentTimeMillis(), tFinal;
		for (int i = 0; i < numeroPuntos / tamPool; i++)
		{
			contParciales.add(pool.submit(new intParaleloFutureCont2(i)));
		}
		pool.shutdown();
		int dentro = 0;
		for (Future<Integer> iterador : contParciales)
			try
			{
				dentro += iterador.get();
			} catch (Exception e)
			{
			}
		tFinal = System.currentTimeMillis() - tInicio;

		System.out.println("El area es " + 4 * dentro / numeroPuntos);
		System.out.println("Concurrentemente, tarda: " + tFinal + " milisegundos");
	}

}
