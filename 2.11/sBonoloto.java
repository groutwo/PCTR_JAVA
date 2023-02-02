import java.rmi.*;
import java.rmi.server.*;

/** @author Ignacio */
public class sBonoloto extends UnicastRemoteObject implements iBonoloto
{
	private static int[] numeros = new int[6];

	public sBonoloto() throws RemoteException
	{
		super();
		for (int i = 0; i < 6; i++)
			numeros[i] = (int) (Math.random() * 48) + 1;
		
		for (int i = 0; i < 6; i++)
			for (int j = i + 1; j < 6; j++)
				if (numeros[j] < numeros[i])//swap
				{ int aux = numeros[j]; numeros[j] = numeros[i]; numeros[i] = aux; }
		System.out.println("\nSe han generado los siguientes números:\n");
		for (int i = 0; i < 6; System.out.print(numeros[i++] + " "));
	}

	public boolean comprobarNumeros(int[] nums) throws RemoteException
	{
		int aux;
		boolean iguales = true;
		for (int i = 0; i < 6; i++)
			for (int j = i + 1; j < 6; j++)
				if (nums[j] < nums[i])
				{ aux = nums[j]; nums[j] = nums[i]; nums[i] = aux; }
		System.out.println("\nSe ha recibido los siguientes números:\n");
		for (int i = 0; i < 6; System.out.print(nums[i++] + " "));
		
		for (int i = 0; i < 6 && iguales; i++)
			if (nums[i] != numeros[i])
				iguales = false;
		return iguales;
	}

	/** @param args No se utilizan parámetros por línea de comandos */
	public static void main(String[] args) throws Exception
	{ sBonoloto objServidor = new sBonoloto();
		Naming.bind("localhost", objServidor);
		System.out.println("\n\nServidor remoto preparado.\n");
	}
}