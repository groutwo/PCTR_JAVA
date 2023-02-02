import java.util.Scanner;
/**
 * 
 * @author Ignacio
 *
 */
public class desCesar
{
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
		String fraseCifrada, fraseADescifrar;
		int desplazamiento;

		System.out.print("Introduce una frase cifrada: ");
		fraseCifrada = myScanner.nextLine();
		System.out.print("Introduce un desplazamiento: ");
		desplazamiento = myScanner.nextInt();

		fraseADescifrar = descifrarFrase(fraseCifrada, desplazamiento);

		System.out.println("La frase descifrada es: " + fraseADescifrar);
		myScanner.close();
	}
	/**
	 * 
	 * @param fraseAntes -> frase a descifrar
	 * @param desplazamiento
	 * @return frase descifrada, de acuerdo al desplazamiento dado
	 */
	static String descifrarFrase(String fraseAntes, int desplazamiento)
	{
		desplazamiento*=-1;
		String fraseDespues = "";
		String asciiMin = "qwertyuiop`+asdfghjklñ´ç<zxcvbnm,.- ";
		String asciiMay = "QWERTYUIOP^*ASDFGHJKLÑ¨Ç>ZXCVBNM;:_ ";

		for (int i = 0; i < fraseAntes.length(); i++)
			for (int j = 0; j < asciiMin.length(); j++)
				/* Si el caracter actual es minuscula: */
				if (fraseAntes.charAt(i) == asciiMin.charAt(j))
					fraseDespues += asciiMin.charAt((j + desplazamiento) % asciiMin.length());
				/* Caracter actual mayuscula: */
				else  if(fraseAntes.charAt(i) == asciiMay.charAt(j))
					fraseDespues += asciiMay.charAt((j + desplazamiento) % asciiMay.length());
		return fraseDespues;
	}

}