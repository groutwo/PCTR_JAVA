/**	@author Ignacio	*/
public class Pentagono extends Triangulo
{
	Triangulo[] conjuntoTriangulos = new Triangulo[3];
	
	/**	Construye un pentagono a partir de 3 triangulos, los cuales se ilustran
	 * en la siguiente imagen:
	 * 
	 * @see <a href= "https://goo.gl/H4g1zk"> </a>
	 * @param triangulos
	 */
	Pentagono(Triangulo[] triangulos)
	{	conjuntoTriangulos[0] = triangulos[0];
		conjuntoTriangulos[1] = triangulos[1];
		conjuntoTriangulos[2] = triangulos[2];
	}

	public double area()
	{	double area = 0;
		for (int i = 0; i < conjuntoTriangulos.length; i++)
			area += conjuntoTriangulos[i].area();
		return area;
	}

	public String toString()
	{	String cadena = "En el pentagono en cuestion:\n";
		for (int i = 0; i < conjuntoTriangulos.length; i++)
		{	cadena+=("\tEn el triangulo "+(i+1)+":\n");
			for (int j = 0; j < conjuntoTriangulos.length; j++)
				cadena += ("El punto " + (i + 1) + " es " /***/
						+ "(" + conjuntoTriangulos[i].vectorPuntos[j].x/***/
						+ "," + conjuntoTriangulos[i].vectorPuntos[j].y/***/
						+ ")\n");
		}
		return cadena;
	}
}
