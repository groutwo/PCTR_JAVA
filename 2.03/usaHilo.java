/**	@author Ignacio	*/
public class usaHilo extends Hilo
{	public static void main(String[] args)
	{	int n = 10000000;
		for (int i = 0; i < 3; i++)
		{	Hilo p = new Hilo(n, false), q = new Hilo(n, true);
			
			p.start();
			q.start();
			
			try { p.join(); q.join();
			} catch (InterruptedException e) { }
			
			System.out.println(getN());
		}
	}
}
