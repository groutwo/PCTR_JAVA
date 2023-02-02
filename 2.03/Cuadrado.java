/**	@author Ignacio	 */
public class Cuadrado extends Poligono
{
	/**	Constructor de la clase cuadrado, la cual hereda de Poligono
	 * 
	 * @param a
	 * @param b
	 */
	Cuadrado(Punto a, Punto b)
	{	vectorPuntos[0] = a;
		vectorPuntos[1] = b;
		vectorPuntos[2] = new Punto(a.x, a.y + a.distancia(b));
		vectorPuntos[3] = new Punto(b.x, b.y + a.distancia(b));
	}

	/**	Crea un cuadrado a partir de un lado
	 * 
	 * @param lado
	 */
	Cuadrado(double lado)
	{	vectorPuntos = new Punto[4];
		vectorPuntos[0] = new Punto(0, 0);
		vectorPuntos[1] = new Punto(0, lado);
		vectorPuntos[2] = new Punto(lado, lado);
		vectorPuntos[3] = new Punto(lado, 0);
	}

	/**	Metodo que devuelve el area del cuadrado que le llama
	 * 
	 * @return el area de dicho cuadrado
	 */
	public double area() {	return Math.pow(vectorPuntos[0].distancia( vectorPuntos[1]), 2);	}

	public String toString()
	{	String cadena = "En el cuadrado en cuestion:\n";
		for (int i = 0; i < vectorPuntos.length; i++)
			cadena += ("El punto " + (i + 1) + " es (" + vectorPuntos[i].getX() + "," + vectorPuntos[i].getY() + ")\n");
		return cadena;
	}
}
