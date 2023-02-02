/**	@author Ignacio	 */
public class Triangulo extends Poligono
{
	////////////Punto[] vectorPuntos = new Punto[10];

	/**	Como un triangulo tiene 3 puntos, le pasamos al ctor estos 3, que deben de ser distintos */
	Triangulo(Punto[] a)
	{	vectorPuntos = new Punto[3];
		vectorPuntos[0] = a[0];
		vectorPuntos[1] = a[1];
		vectorPuntos[2] = a[2];
	}

	Triangulo(){ }

	Triangulo(Poligono p)
	{	vectorPuntos[0] = p.vectorPuntos[0];
		vectorPuntos[1] = p.vectorPuntos[0];
		vectorPuntos[2] = p.vectorPuntos[0];
	}

	/**	Compara las distancias de los puntos para distinguir segun sus lados */
	public void tipo()
	{	Punto a = vectorPuntos[0], b = vectorPuntos[1], c = vectorPuntos[2];
		System.out.print("El triangulo es ");
		if (a.distancia(b) == b.distancia(c) && a.distancia(b) == a.distancia(c)) 		System.out.println("equilatero");
		else if (a.distancia(b) != b.distancia(c) && a.distancia(b) != a.distancia(c))	System.out.println("escaleno");
		else																			System.out.println("isosceles");
	}

	/**	 Dado un triangulo, devuelve el area del mismo
	 * 		@return Area del triangulo
	 */
	public double area()
	{	Punto a = vectorPuntos[0];
		Punto b = vectorPuntos[1];
		Punto c = vectorPuntos[2];

		System.out.print("punto1:  x: "+a.x); System.out.println(" y: "+a.y);
		System.out.print("punto2:  x: "+b.x); System.out.println(" y: "+b.y);
		System.out.print("punto3:  x: "+c.x); System.out.println(" y: "+c.y);
		
		Punto intermedio = new Punto(((a.x + b.x) / 2),((a.y + b.y) / 2));
		double base = a.distancia(b);
		double altura = intermedio.distancia(c);
		return base * altura / 2;
	}

	/**	Muestra por pantalla las coordenadas de los tres puntos del triangulo	*/
	public String toString()
	{	String cadena = "En el triangulo en cuestion:\n";
		for (int i = 0; i < vectorPuntos.length; i++)
			cadena += ("El punto " + (i + 1) + " es (" + vectorPuntos[i].getX() + "," + vectorPuntos[i].getY() + ")\n");
		return cadena;
	}

}
