import java.rmi.*;

/**  @author Ignacio */
public interface iLibros extends Remote
{
	/** @param libro nuevo libro a insertar */
	public void nuevoLibro(Libro libro) throws RemoteException;

	/** @return array de libros almacenados */
	public Libro[] obtenerLibros() throws RemoteException;

	/** @param index índice del libro en el array de libros
	 * @return libro solicitado */
	public Libro obtenerLibro(int index) throws RemoteException;
}
