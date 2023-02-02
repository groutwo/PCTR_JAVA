import java.util.concurrent.locks.*;

/** @author Igancio */
public class filoApiAN
{
	private final ReentrantLock cerrojo;
	private final Condition[] OKtoEat = new Condition[5];
	private int[] fork = new int[5];

	public filoApiAN()
	{ 	cerrojo = new ReentrantLock();
		for (int i = 0; i < OKtoEat.length; fork[i++]=2)
			OKtoEat[i]  = cerrojo.newCondition();
	}
	/** @param hilo Identificador del hilo */
	public void takeForks(int hilo)
	{	cerrojo.lock();
		try
		{ 
			while (fork[hilo] !=2 )
		{ 	System.out.println("El filósofo " + hilo + " intenta comer pero no puede");
			OKtoEat[hilo].await();
		}
			--fork[(hilo+1)%5]; --fork[hilo==0?4:hilo-1];
		System.out.println("El filósofo " + hilo + " empieza a comer");
		} catch (Exception e) { System.out.println("Error"); }
		finally { cerrojo.unlock(); }
	}

	/** @param hilo Identificador del hilo */
	public void releaseForks(int hilo)
	{	cerrojo.lock();
		try
		{	
			++fork[(hilo+1)%5];++fork[hilo==0?4:hilo-1];
			if(fork[(hilo+1)%5]			== 2)	OKtoEat[(hilo+1)%5].signal();
			if(fork[hilo==0?4:hilo-1] 	== 2)	OKtoEat[hilo==0?4:hilo-1].signal();
			System.out.println("El filósofo " + hilo + " termina de comer y se pone a pensar");

		} finally { cerrojo.unlock(); }
	}

}