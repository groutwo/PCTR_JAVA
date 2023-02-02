import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

/**  @author Ignacio  */
public class sLibros extends UnicastRemoteObject implements iLibros
{
	private static final long serialVersionUID = 1L;
	private ArrayList<Libro> libros;

	public sLibros() throws RemoteException
	{ super(); libros = new ArrayList<Libro>(); }

	public void nuevoLibro(Libro libro) throws RemoteException
	{ libros.add(libro); }

	public Libro[] obtenerLibros() throws RemoteException
	{ return libros.toArray(new Libro[libros.size()]); 	}

	public Libro obtenerLibro(int index) throws RemoteException
	{ return libros.get(index); }

	/** @param args No se utilizan parámetros por línea de comandos */
	public static void main(String[] args) throws Exception
	{
		sLibros objServidor = new sLibros();
		objServidor.nuevoLibro(new Libro("AADE50", "El Quijote", "Cervantes"));
		objServidor.nuevoLibro(new Libro("AADE90", "Juego de Tronos", "George R. R. Martin"));
		objServidor.nuevoLibro(new Libro("AADE32", "Divergente", "Veronica Roth"));
		Naming.bind("localhost", objServidor);
		System.out.println("\nServidor remoto preparado...\n");
	}
}