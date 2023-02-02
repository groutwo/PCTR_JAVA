import java.net.*;

/** @author Ignacio */
public class clienteContador
{ 	public static void main(String[] args)
	{	int puertoAtomic = 2001,puertoReentrant=2002, peticiones = Integer.parseInt(args[0]);
		try
		{	for (int i = 0; i < peticiones; i++)
			{	System.out.println("Realizando conexión " + i + "...");
			Socket cable1 = new Socket("localhost", puertoAtomic);
			Socket cable2 = new Socket("localhost", puertoReentrant);
			System.out.println("Realizada la conexión a " + cable1 + "...");
			System.out.println("Realizada la conexión a " + cable2 + "...");
			}
		} catch (Exception e)
		{ System.out.println("\nError de sockets...\n"); }
		System.out.println("Saliendo del cliente");
	}
}
