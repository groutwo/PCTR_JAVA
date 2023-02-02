import java.rmi.*;
import java.rmi.server.*;

/** @author Ignacio */
public class sPiMonteCarlo extends UnicastRemoteObject implements iPiMonteCarlo
{
	private double puntos_dentro;
	private double puntos_total;
	Object cerrojo = new Object();
	public sPiMonteCarlo() throws RemoteException
	{
		super();
		puntos_dentro = 0;
		puntos_total = 0;
	}

	public void contribuir(int puntos) throws RemoteException
	{
		double x, y, distancia;
		synchronized (cerrojo)
		{puntos_total += puntos; }
		for (int i = 0; i < puntos; i++)
		{
			x = Math.random(); y = Math.random();
			distancia = Math.sqrt((x * x) + (y * y));
			if (distancia < 1) synchronized (cerrojo) {++puntos_dentro;}
		}
		System.out.println("Un cliente ha contribuido con " + puntos + " puntos.\n"
				+ "Integral definida en [0,1] actual: " + (puntos_dentro / puntos_total) + ".");
	}

	public void reset() throws RemoteException
	{
		puntos_dentro = 0.0;
		puntos_total = 0.0;
		System.out.println("Uno de los clientes ha reseteado la aproximación...");
	}

	/** @param args No se utilizan parámetros por línea de comandos */
	public static void main(String[] args) throws Exception
	{
		sPiMonteCarlo objRemoto = new sPiMonteCarlo();
		Naming.rebind("localhost", objRemoto);
		System.out.println("Servidor remoto preparado");
	}
}