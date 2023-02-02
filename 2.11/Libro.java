import java.io.Serializable;

/** @author Ignacio  */
public class Libro implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String codigo, nombre, autor;

	/** @param codigo 	código del libro
	 * 	@param nombre 	nombre del libro
	 * 	@param autor	autor del libro
	 */
	public Libro(String codigo, String nombre, String autor)
	{	this.codigo = codigo; this.nombre = nombre; this.autor = autor; }

	public String getCodigo()
	{ return codigo; }

	public String getNombre()
	{ return nombre; }

	public String getAutor()
	{ return autor; }
}