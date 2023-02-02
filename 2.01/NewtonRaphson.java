import java.util.*;
/**
 * 
 * @author Ignacio
 *
 */
public class NewtonRaphson {
	public static double f(double x) 
	{ return (Math.cos(x) - x * x * x); }

	public static double fPrima(double x)
	{ return (-Math.sin(x) - 3 * x * x); }

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Aproximacion inicial: ");
		double x0 = s.nextDouble();
		double xi = x0;
		System.out.print("nIteraciones: ");
		int nIter = s.nextInt();

		for (int i = 0; i < nIter; i++)
			if (fPrima(xi) != 0)
			{
				xi = xi - (f(xi) / fPrima(xi));
				System.out.println("Iteracion: " + i + " Aproximacion: " + xi);
			}
		System.out.println("Resultado: " + xi);
		s.close();
	}
}
