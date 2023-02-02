import java.util.Scanner;
/**
 * 
 * @author Ignacio
 *
 */
public class Cesar
{
	public static void main(String[] args)
	{
		Scanner myScanner = new Scanner(System.in);
		String fraseACifrar, fraseCifrada;
		int desplazamiento;

		System.out.print("Introduce una frase a cifrar: ");
		fraseACifrar = myScanner.nextLine();
		System.out.print("Introduce un desplazamiento: ");
		desplazamiento = myScanner.nextInt();

		fraseCifrada = cifrarFrase(fraseACifrar, desplazamiento);
		System.out.println("La frase cifrada es: " + fraseCifrada);
		myScanner.close();
	}
/**
 * 
 * @param fraseAntes -> frase a cifrar
 * @param desplazamiento
 * @return frase cifrada, de acuerdo al desplazamiento dado
 */
	static String cifrarFrase(String fraseAntes, int desplazamiento)
	{
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