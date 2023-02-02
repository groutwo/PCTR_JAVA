public class drakkarVikingo implements Runnable
{
	static int tamMax = 10;
	private boolean vikingo;
	private static int marmita = tamMax;
	private static Object cerrojo = new Object();

	public drakkarVikingo(boolean vikingo)
	{	this.vikingo = vikingo; 	}

	public void run()
	{	while (true)
		{	if (vikingo)
				synchronized (cerrojo)
				{	if (marmita > 0)
					{	marmita--;
						System.out.println("Soy "+Thread.currentThread().getName()+" y quedan " + marmita + " anguilas");
						try	{	Thread.sleep(100);	} catch (InterruptedException e) { }
					}
					cerrojo.notifyAll();
				}
			else
				synchronized (cerrojo)
				{	while (marmita == 0)
					{	marmita = tamMax;	System.out.println("Soy el cocinero y quedan " + marmita + ".");
						cerrojo.notifyAll();
					}
					try	{ cerrojo.wait(); } catch (Exception e) { }
				}
		}
	}

	public static void main(String[] args)
	{	Thread[] hilos = new Thread[marmita];

		for (int i = 0; i < hilos.length; i++)
		{	Runnable runableVikingoConsumidor = new drakkarVikingo(true);
			hilos[i] = new Thread(runableVikingoConsumidor);
			hilos[i].start();
		}

		Runnable runableVikingoCocinero = new drakkarVikingo(false);
		Thread productor = new Thread(runableVikingoCocinero);
		productor.start();

		try	{	for (int i = 0; i < hilos.length; hilos[i++].join()) ;
			productor.join(); } catch (Exception e) { }
	}
}
