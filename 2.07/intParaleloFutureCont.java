import java.util.ArrayList;
import java.util.concurrent.*;

public class intParaleloFutureCont implements Callable<Integer>
{
	int indice;
	private Integer total = Integer.valueOf(0);
	
	static double Cb = 0.85; //Float.parseFloat(args[0]);
	static double numeroPuntos = 4000000, dentro = 0;
	static int nNuc = Runtime.getRuntime().availableProcessors();
	static int tamPool = (int) (nNuc / (1 - Cb));
	static Object o=new Object();

	public intParaleloFutureCont(int i)	{	indice = i; }

	public Integer call()
	{	for (int i = 0; i < tamPool; i++)
		{	double x = Math.random(), y = Math.random();
			if (Math.sin(x) <= y)
				synchronized (o)
				{	++total; }
		}
		return total;
	}

	public static void main(String[] args)
	{	System.out.println("Con un pool de tamaño de " + tamPool);

		ArrayList<Future<Integer>> contParciales = new ArrayList<Future<Integer>>();

		ThreadPoolExecutor pool = new ThreadPoolExecutor(tamPool, tamPool, 0L,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

		double tInicio = System.currentTimeMillis(), tFinal;
		for (int i = 0; i < numeroPuntos / tamPool; i++)
			contParciales.add(pool.submit(new intParaleloFutureCont(i)));
		pool.shutdown();
		int dentro = 0;
		for (Future<Integer> iterador : contParciales)
			try	{	dentro += iterador.get();} catch (Exception e)	{	}
		tFinal = System.currentTimeMillis() - tInicio;

		System.out.println("El area es " + dentro / numeroPuntos);
		System.out.println("Concurrentemente, tarda: " + tFinal + " milisegundos");
	}

}
