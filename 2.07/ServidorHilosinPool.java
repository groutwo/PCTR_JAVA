import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/** @author Ignacio  */
public class ServidorHilosinPool implements Runnable
{	
	Socket enchufe;
	//Aqui va el calculo de nucleos
	
	public ServidorHilosinPool(Socket s)	{	enchufe = s; }

	public void run()
	{ double tInicio = System.currentTimeMillis(), tFinal;
		try
		{	BufferedReader entrada = new BufferedReader(new InputStreamReader(enchufe.getInputStream()));
			String datos = entrada.readLine();
			int j, i = Integer.valueOf(datos).intValue();
			for (j = 1; j <= 20; j++)
			{	System.out.println("El hilo " + Thread.currentThread().getName() +
					" escribiendo el dato " + i);	Thread.sleep(1000);
			}
			enchufe.close();
			System.out.println("El hilo " + Thread.currentThread().getName() + " cierra su conexion...");
		} catch (Exception e){System.out.println("Error en " + Thread.currentThread().getName());}
		tFinal = System.currentTimeMillis() - tInicio;
		System.out.println(tFinal + " milisegundos");
	}
	
	public static void main(String[] args)
	{	
		int puerto = 2100;// Tiene que ser mayor que 2024
		//creacion del pool
		try
		{	//El 3000 es para que no se produzca ataques, para que se deje de aceptar peticiones
			ServerSocket chuff = new ServerSocket(puerto, 3000);
			while (true)
			{	System.out.println("Esperando solicitud de conexion...");
				Socket cable = chuff.accept();
				// Aqui se queda bloqueado hasta que se produzca una peticion de dicho socket
				System.out.println("Recibida solicitud de conexion...");
				/*Aqui la diferencia*/ new Thread(new ServidorHilosinPool(cable)).start();
				chuff.close();
			}
		} catch (Exception e)	{	System.out.println("Error en sockets...");}
	}
}