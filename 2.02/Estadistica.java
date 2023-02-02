import java.util.Scanner;

/**
 * 
 * @author Ignacio
 *
 */
public class Estadistica
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int opcionSwitch;
		if (args.length != 1)
			System.out.println("Paso de parametros inadecuado");
		else
		{
			int longitud = Integer.parseInt(args[0]);
			if (longitud < 0)
				System.out.println("Valores inadecuados");
			else
			{
				float[] valores = new float[longitud];
				for (int i = 0; i < longitud; i++)
				{
					System.out.print("Para i= " + i + ", introduce elemento: ");
					valores[i] = sc.nextFloat();
				}

				do
				{
					System.out.println("\n¿Que deseas saber?");
					System.out.println("0.- Nada(Salir)");
					System.out.println("1.- Media");
					System.out.println("2.- Moda");
					System.out.println("3.- Varianza");
					System.out.println("4.- Desviacion Tipica");
					System.out.println("5.- Todo");
					System.out.print(">");
					opcionSwitch = sc.nextInt();

					switch (opcionSwitch)
					{
					case 0:
						System.out.println("Saliendo...");
						break;
					case 1:
						System.out.println("La media es: " + calculaMedia(valores));
						break;
					case 2:
						imprimeModa(valores);
						break;
					case 3:
						System.out.println("La varianza es: " + calculaVarianza(valores));
						break;
					case 4:
						System.out.println("La desviacion tipica es: " + calculaDesviaciontipica(valores));
						break;
					case 5:
						System.out.println("La media es: " + calculaMedia(valores));
						imprimeModa(valores);
						System.out.println("La varianza es: " + calculaVarianza(valores));
						System.out.println("La desviacion tipica es: " + calculaDesviaciontipica(valores));
						break;
					default:
						System.out.println("Opcion invalida");
					}
				} while (opcionSwitch != 0);
			}
		}
		sc.close();
	}

	/**
	 * 
	 * @param valores
	 * @return media de dichos valores
	 */
	static float calculaMedia(float[] valores)
	{
		float media = 0.0f;
		for (float i : valores)
			media += i;
		return (media / valores.length);
	}

	/**
	 * Muestra la moda de los valores del vector
	 * 
	 * @param valores
	 */
	static void imprimeModa(float[] valores)
	{
		int maximaVecesQueSeRepite = 0;
		float moda = 0;

		for (float i : valores)
		{
			int vecesQueSeRepiteActual = 0;
			for (float j : valores)
				if (i == j)
					vecesQueSeRepiteActual++;
			if (vecesQueSeRepiteActual > maximaVecesQueSeRepite)
			{
				moda = i;
				maximaVecesQueSeRepite = vecesQueSeRepiteActual;
			}
		}
		System.out.println("La moda es " + moda + " y se repitio " + maximaVecesQueSeRepite + " veces.");
	}

	/**
	 * 
	 * @param valores
	 * @return varianza de los parametros del vector
	 */
	static float calculaVarianza(float[] valores)
	{
		float varianza = 0;
		float media = calculaMedia(valores);
		for (float i : valores)
			varianza += (Math.pow(i - media, 2));
		return varianza;
	}

	/**
	 * 
	 * @param valores
	 * @return desviacion tipica de los parametros del vector
	 */
	static float calculaDesviaciontipica(float[] valores)
	{
		return (float) (Math.sqrt(calculaVarianza(valores)));
	}

}
