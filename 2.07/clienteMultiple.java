import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
/** @author Ignacio  */
public class clienteMultiple
{
	public static void main(String[] args)
	{
		for (int j = 1; j <= 10; j++)
			try
			{
				int i = (int) (Math.random() * 10);
				System.out.println("Realizando conexion...");
				Socket cable = new Socket("localhost", 2100);
				System.out.println("Realizada conexion a " + cable);
				PrintWriter salida = new PrintWriter(
						new BufferedWriter(new OutputStreamWriter(cable.getOutputStream())));
				salida.println(i);
				salida.flush();
				System.out.println("Cerrando conexion...");
				cable.close();
			} catch (Exception e) {  }
	}
}
