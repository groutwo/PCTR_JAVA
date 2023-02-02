/**	@author Ignacio */

public class escalaVectorParalelo extends Thread
{
	private static double[] vec = new double[100000000];
	private int inicio, fin;
	static int nproc = Runtime.getRuntime().availableProcessors();
	static escalaVectorParalelo[] prin = new escalaVectorParalelo[nproc];
	
	public escalaVectorParalelo(int ini, int end)
	{ inicio = ini; fin = end; 	}

	/** Metodo que ejecuta/procesa los hilos que que se lanzan */
	public void run(){ for (int i = inicio; i < fin; vec[i++] *= 10);	}

	public static void main(String[] args)
	{	int inicioConcurrente, finConcurrente = 0;
		for (int i = 0; i < vec.length; vec[i++] = i*i);
		
		double tiempo = System.nanoTime();
		for (int i = 0; i < nproc; i++)
		{	inicioConcurrente = finConcurrente;
			if(i==nproc-1) finConcurrente= vec.length;
			else finConcurrente += vec.length / nproc;
			//System.out.println("i"+i+" ini"+inicioConcurrente+" fin"+finConcurrente);
			prin[i] = new escalaVectorParalelo(inicioConcurrente, finConcurrente);
			prin[i].start();
		}

		try {for (int i = 0; i < nproc; prin[i++].join());
		} catch (InterruptedException e) { }

		System.out.println("Version Concurrente: \n" + ((System.nanoTime() - tiempo) / 1000000) + " milisegundos");		
	}
}
