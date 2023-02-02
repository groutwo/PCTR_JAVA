import java.rmi.*;
import java.util.Scanner;
/** @author Ignacio  */
public class cLibros
{
	private static final Scanner S = new Scanner(System.in);

	/** @param servidor Objeto remoto */
	private static void introducir_libro(iLibros servidor) throws Exception
	{
		String codigo, nombre, autor;
		System.out.println("\nIntroducir datos libro->\n");
		System.out.print("Código del libro: "); codigo = S.nextLine();
		System.out.print("Nombre del libro: "); nombre = S.nextLine();
		System.out.print("Autor del libro: "); 	autor = S.nextLine();
		servidor.nuevoLibro(new Libro(codigo, nombre, autor));
	}

	/** @param servidor Objeto remoto */
	private static void mostrar_libros(iLibros servidor) throws Exception
	{ System.out.println("\nListado de libros:\n");
		Libro[] libros = servidor.obtenerLibros();
		for (int i = 0; i < libros.length; i++)
			System.out.println("- " + libros[i].getNombre());
	}

	/** @param servidor Objeto remoto */
	private static void mostrar_libro(iLibros servidor) throws Exception
	{
		System.out.println("\nSeleccione un libro:\n");
		int libro;
		Libro[] libros = servidor.obtenerLibros();
		Libro libro_seleccionado;
		do
		{
			for (int i = 0; i < libros.length; i++)
				System.out.println("(" + i + ") - " + libros[i].getNombre());
			System.out.print("\nLibro: "); libro = S.nextInt();
		} while (libro < 0 || libro >= libros.length);
		libro_seleccionado = servidor.obtenerLibro(libro);
		System.out.println("\nLibro - " + libro_seleccionado.getNombre() + " -\n");
		System.out.println("Codigo: " + libro_seleccionado.getCodigo());
		System.out.println("Nombre: " + libro_seleccionado.getNombre());
		System.out.println("Autor: " + libro_seleccionado.getAutor());
	}

	/** @param args No se utilizan parámetros por línea de comandos */
	public static void main(String[] args) throws Exception
	{
		iLibros libros_obj = (iLibros) Naming.lookup("localhost");
		int op;
		while (true)
		{
			System.out.print("\nIntroduce una opción:\n\n"
					+ "(1) - Introducir libro\n"
					+ "(2) - Ver lista de libros\n"
					+ "(3) - Consultar libro\n\nOpción: ");
			op = S.nextInt();
			S.nextLine();
			switch (op)
			{
				case 1: introducir_libro(libros_obj); 	break;
				case 2: mostrar_libros(libros_obj);		break;
				case 3: mostrar_libro(libros_obj);		break;
			}
		}
	}
}