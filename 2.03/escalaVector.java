/** @author Ignacio  */

public class escalaVector
{
	private static double[] vec = new double[100000000];


	public static void main(String[] args)
	{	for (int i = 0; i < vec.length; vec[i++] = i*i);
		double tiempo = System.nanoTime();
		for (int i = 0; i < vec.length; vec[i++] *= 10);
		System.out.println("Version NO concurrente:\n" + ((System.nanoTime() - tiempo) / 1000000) + " milisegundos");
	}
}
