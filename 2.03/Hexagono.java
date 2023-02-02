/**	@author Ignacio	*/
public class Hexagono extends Triangulo
{
	Triangulo[] conjuntoTriangulos = new Triangulo[6];

	/**	Construye un pentagono a partir de 3 triangulos, los cuales se ilustran
	 * en la siguiente imagen:
	 * 
	 * @see <a href= "https://goo.gl/XkB9kF"> </a>
	 * @param triangulos
	 */
	Hexagono(Triangulo[] triangulos)
	{	for (int i = 0; i < conjuntoTriangulos.length; i++)
			conjuntoTriangulos[i] = triangulos[i];
	}

	public double area()
	{	double area = 0;
		for (int i = 0; i < conjuntoTriangulos.length; i++)
			area += conjuntoTriangulos[i].area();
		return area;
	}

	public String toString()
	{	String cadena = "En el hexagono en cuestion:\n";
		for (int i = 0; i < vectorPuntos.length; i++)
			cadena += ("El punto " + (i + 1) + " es (" + vectorPuntos[i].getX() + "," + vectorPuntos[i].getY() + ")\n");
		return cadena;
	}

}
