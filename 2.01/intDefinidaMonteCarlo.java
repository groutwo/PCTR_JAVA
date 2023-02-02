import java.util.*;
/**
 * 
 * @author Ignacio
 *
 */
public class intDefinidaMonteCarlo
{
	///static int radio=1, superficie = radio * radio;

	/**
	 * MonteCarlo usando Math.random()
	 * @param n
	 */
	public static void MonteCarlo1(double n)
	{//version segura pero menos eficiente concurrentemente,
		//ya que se llama a metodos estaticos
		double contador_exitos1 = 0, contador_exitos2=0 ;
		for(int i  = 0 ; i < n; ++i)
		{
			double cx_ = Math.random();
			double cy_ = Math.random();
			if(cy_ <= Math.sin(cx_)) contador_exitos1++;
			if(cy_<= cx_)	contador_exitos2++;
		}
		System.out.println("Integral aprox con Math.Random(), con la funcion f(x) = sin(x): "+(double)(contador_exitos1/n));
		System.out.println("Integral aprox con Math.Random(), con la funcion f(x) = x: "+(double)(contador_exitos2/n));
		System.out.println("");
	}
	/**
	 * Montecarlo usando un objeto de la clase Random
	 * @param n
	 */
	public static void MonteCarlo2(double n)
	{//como no se llama a metodos estaticos, los hilos no
		//se quedan esperando a que el hilo acabe de generarlo
		Random r = new Random();
		double contador_exitos1 = 0, contador_exitos2=0 ;
		for(int i = 0 ; i < n; ++i)
		{
			double cx_ = r.nextDouble();
			double cy_ = r.nextDouble();
			if(cy_ <= Math.sin(cx_)) contador_exitos1++;
			if(cy_<= cx_)	contador_exitos2++;
		}
		System.out.println("Integral aprox con un objeto de la clase Random, con la funcion f(x) = sin(x): "+(double)(contador_exitos1/n));
		System.out.println("Integral aprox con un objeto de la clase Random, con la funcion f(x) = x: "+(double)(contador_exitos2/n));
		System.out.println("");
	}

	public static void main(String[] args)
	{
		MonteCarlo1(100000);
		MonteCarlo2(100000);
	}
}