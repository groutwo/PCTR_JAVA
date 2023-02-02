import java.rmi.*;
/**@author Ignacio */
public class cBonoloto
{
	/** @param args No se utilizan parámetros por línea de comandos*/
	public static void main(String[] args) throws Exception
	{
		int[] numeros = new int[6];
		iBonoloto iRemota = (iBonoloto) Naming.lookup("localhost");
		if (args.length > 0)
			for (int i = 0; i < 6; ++i)
				numeros[i] = Integer.parseInt(args[i]);
		else
			for (int i = 0; i < 6; ++i)
				numeros[++i] = (int) (Math.random() * 48) + 1;

		if (iRemota.comprobarNumeros(numeros)) 	System.out.println("Enhorabuena, has ganado!!!\n");
		else 									System.out.println("Más suerte la próxima vez...\n");
	}
}