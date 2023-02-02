/**
 * 
 * @author Ignacio
 *
 */
public class Aleatorio
{
	public static void main(String[] args)
	{
		int cantidad = Integer.parseInt(args[0]);
		System.out.println("Generacion de numeros aleatorios: \n");
		if (args.length == 1)
			for (int i = 0; i < cantidad; i++)
				System.out.println("Numero " + (i + 1) + ": " + Math.random());
		else
			System.out.println("Debes introducir la cantidad de numeros que deseas generar.");
	}
}
