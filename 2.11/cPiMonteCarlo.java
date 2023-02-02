import java.rmi.*;
import java.util.Scanner;

/** @author Igancio */
public class cPiMonteCarlo
{
	private static final Scanner S = new Scanner(System.in);

	/** @param objRemoto Objeto remoto */
	private static void aportarPuntos(iPiMonteCarlo objRemoto) throws Exception
	{
		int n_puntos;
		System.out.print("\nCuantos puntos quieres lanzar: ");
		n_puntos = S.nextInt();
		objRemoto.contribuir(n_puntos);
	}

	/** @param args No se utilizan parámetros por línea de comandos */
	public static void main(String[] args) throws Exception
	{
		iPiMonteCarlo objRemoto = (iPiMonteCarlo) Naming.lookup("localhost");
		int op;
		while (true)
		{
			System.out.print("\nQue deseas hacer?\n\n"
							+ "(1) - Aportar puntos\n"
							+ "(2) - Resetear servidor\n\nrespuesta: ");
			op = S.nextInt();
			if (op == 1) aportarPuntos(objRemoto);
			else 				objRemoto.reset();
		}
	}
}
