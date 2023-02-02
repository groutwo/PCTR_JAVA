/**	@author Ignacio	 */
public class Poligono extends Punto
{
	Punto[] vectorPuntos = new Punto[10];

	/**	Constructor pasandole un vector de puntos
	 * 
	 * @param datos: vector de puntos
	 */
	Poligono(Punto[] datos)
	{	vectorPuntos = new Punto[datos.length];
		for (int i = 0; i < datos.length; i++)
			vectorPuntos[i] = datos[i];
	}

	/**	Constructor para crear objetos poligono vacios	*/
	Poligono() { 	}

	/**	Dado un poligono cualquiera, obtenemos su perimetro Nota: Sea por ejemplo
	 * un triangulo con tres puntos, p0,p1 y p2, si en el bucle no tiene el
	 * modulo, primero sumará la diferencia del 0 con el 1, luego del 1 con el
	 * 2, y luego el 2 con el 3. Como no hay punto 3, pero su longitud es 3, al
	 * hacer el modulo conseguimos sumar el ultimo punto con el primero.
	 * 
	 * @return perimetro del poligono en cuestion
	 */
	double perimetro()
	{	double perimetro = 0;
		System.out.println("perimetro antes del bucle con "+vectorPuntos.length+" puntos");
		for (int i = 0; i < vectorPuntos.length; i++)
			System.out.println("p: "+(perimetro+=vectorPuntos[i].distancia(vectorPuntos[(i+1)%vectorPuntos.length])));
		System.out.println("fin del bucle del calculo del perimetro");
		return perimetro;
	}

	/**	Iguala la lista de puntos que se le pasa al objeto activo
	 * 
	 * @param ListaPuntos
	 */

	void setListaPuntos(Punto[] ListaPuntos)
	{	vectorPuntos = new Punto[ListaPuntos.length];
		for (int i = 0; i < ListaPuntos.length; i++) this.vectorPuntos[i] = ListaPuntos[i];
	}

	/**	Obtenemos la lista de puntos del objeto
	 * 
	 * @return El vector que contiene los puntos del objeto
	 */
	Punto[] getListaPuntos() { return vectorPuntos; }

	/**	Movemos el poligono las coordenadas que se le pasan
	 * 
	 * @param x
	 * @param y
	 */
	void moverPoligono(double x, double y)
	{	for (int i = 0; i < vectorPuntos.length; vectorPuntos[i].y += y, i++)
		vectorPuntos[i].x += x;	
	}

	/**	Ampliamos en poligono en el factor dado
	 * 
	 * @param escala
	 */

	void zoomPoligono(double escala)
	{	for (int i = 0; i < vectorPuntos.length;vectorPuntos[i].y *= escala, i++)
		vectorPuntos[i].x *= escala;
	}

	/**	Metodo a sobreescribir en cada especializacion
	 * 
	 * @return nada, ya que llegamos acá cuando no es poligono regular
	 */
	public double area() 
	{ System.out.println("Como no es un poligono regular, no se le calcula el area");
		return 0;
	}

	public void tipo() { System.out.println("Poligono"); }

	/**	Generamos una lista que contiene los puntos del poligono	*/

	public String toString()
	{
		String cadena = "En poligono en cuestion:\n";

		for (int i = 0; i < vectorPuntos.length; i++)
			cadena += ("El punto " + (i + 1) + " es (" + vectorPuntos[i].getX() + "," + vectorPuntos[i].getY() + ")\n");
		return cadena;
	}

	public void moverEn(double dimX, double dimY)
	{	for (int i = 0; i < vectorPuntos.length; vectorPuntos[i++].x+=dimX)
			vectorPuntos[i].y+=dimY;
	}
}
