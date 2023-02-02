import java.util.Scanner;

/**
 * 
 * @author Ignacio
 *
 */
public class usaComplejos
{
	static Scanner sc = new Scanner(System.in);
	static int op;
	static Complejos c1 = null;
	static Complejos c2 = null;
	static Complejos c3 = null;


	public static void main(String[] args)
	{
		float[] numeros = new float [2];
		do
		{
			System.out.println("Elige la operacion que deseas realizar con numeros complejos:"
					+ "\n0.- Salir\n1.- Suma\n2.- Resta\n3.- Modulo\n4.- Producto\n5.- Cociente");
			op = sc.nextInt();
			if (op == 3)
			{	System.out.println("Introduce el numero complejo para calcularle el modulo:");
			
				System.out.print("Parte real: "); 				numeros[0]=sc.nextFloat();
				System.out.print("Parte imaginaria: ");			numeros[1]=sc.nextFloat();
				c1= new Complejos(numeros);
				System.out.println("El modulo de dicho complejo es" + c1.modulo());
			}
			else if(op>0 && op <6)
			{
				recogeComplejos();	
				switch (op)
				{
					case 1: c3 = c1.suma(c2);  		break;
					case 2: c3 = c1.resta(c2); 		break;
					case 4: c3 = c1.multiplica(c2);	break;
					case 5: c3 = c1.divide(c2);		break;
					default: System.out.println("Opcion inválida.");
				}
				System.out.println("El complejo resultante es: (" + c3.getReal() + " , " + c3.getImaginario() + ")\n\n");
				//sc.nextLine();sc.nextLine();
			}
		} while (op != 0);
		sc.close();
		System.out.println("Fin del programa");
	}

	/**
	 * Da valores a los complejos, que son variables de clase, al ser de tipo static
	 */
	static void recogeComplejos()
	{
		float[] numeros = new float [2];
		
		System.out.println("Introduce el primer numero complejo:");
			System.out.print("Parte real: "); 			numeros[0]=sc.nextFloat();
			System.out.print("Parte imaginaria: "); 	numeros[1]=sc.nextFloat();
				c1 = new Complejos(numeros);
		System.out.println("Introduce el segundo numero complejo:");
			System.out.print("Parte real: "); 			numeros[0]=sc.nextFloat();
			System.out.print("Parte imaginaria: "); 	numeros[1]=sc.nextFloat();
				c2 = new Complejos(numeros);
	}
}
