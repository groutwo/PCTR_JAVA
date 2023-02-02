/**
 * 
 * @author Ignacio
 *
 */
public class Ack
{
	/**
	 * 
	 * @param args
	 *            Dos valores para calcular el valor de la funcion de Ackerman para éstos
	 */
	public static void main(String[] args)
	{
		if (args.length != 2) System.out.println("Paso de parametros inadecuado");
		else
		{
			int m = Integer.parseInt(args[0]);
			int n = Integer.parseInt(args[1]);
			if (n < 0 || m < 0)
				System.out.println("Los valores han de ser positivos");
			else
				System.out.println("La funcion de Ackerman con m = " + m + " y n = " + n + " es " + A(m, n));
		}
	}

	/**
	 * Calculo de la funcion Ackerman para los valores dados
	 * 
	 * @param m
	 * @param n
	 * @return El valor de la funcion con los parametros indicados
	 */
	static int A(int m, int n)
	{ return m==0?n+1:A(m-1,n==0?1:A(m,n-1));}
}
