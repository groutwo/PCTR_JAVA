import java.util.Scanner;

/**
 * 
 * @author Ignacio
 *
 */
public class usaElipse
{
	/**
     * @param args no se usa
     */
	public static void main(String[] args)
	{
		Elipse elipse;
		float auxX, auxY;
		Scanner sc = new Scanner(System.in);
		int op = 1;
		
		System.out.print("Introduce el valor de la x para la elipse: "); auxX = sc.nextFloat();
		System.out.print("Introduce el valor de la y para la elipse: "); auxY = sc.nextFloat();
			elipse = new Elipse(auxX, auxY);
		do
		{
			System.out.print("\nIntroduce ahora la coordenada x de un punto: "); auxX = sc.nextFloat();
			System.out.print("\nIntroduce ahora la coordenada y de un punto: "); auxY = sc.nextFloat();

			if (elipse.pertenece(auxX, auxY)) 	System.out.println("El punto introducido si pertenece a la elipse");
			else 			     				System.out.println("El punto introducido no pertenece a la elipse");
			
			System.out.println("Introduce 0 para salir");
			op = sc.nextInt();
			
		} while (op != 0);
		sc.close();
		System.out.println("Fin del programa");
	}
}
