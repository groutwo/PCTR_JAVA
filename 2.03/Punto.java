/**	@author Ignacio	*/

public class Punto
{	double x, y; // Variables de instancia

	public Punto(double x, double y)
	{ this.x = x; this.y = y; }

	/**	Construye un objeto punto vacio	 */
	public Punto()	{ 	}

	/** Mueve el punto tantas unidades como se le pasen
	 * 
	 * @param dx permite mover la coordenada x
	 * @param dy permite mover la coordenada y
	 */
	public void moverEn(double dx, double dy)
	{x += dx; y += dy; }

	/**	Forma una cadena con las coordenadas del punto en cuestion */
	public String toString() { return "(" + x + "," + y + ")"; }

	public double getX() 		{ return x; }
	public void setX(double dx) {	x = dx; }
	public double getY() 		{ return y; }
	public void setY(double dy)	{ 	y = dy; }

	/**	Permite obtener la distancia de dicho punto con respecto al punto (0,0)
	 * 
	 * @return Distancia con el origen
	 */
	public double distanciaOrigen() { return Math.sqrt(x * x + y * y); }

	/**	Dados dos puntos, obtenemos la distancia que los separan
	 * 
	 * @param p el segundo punto; el primero se le pasa implicitamente
	 * @return Distancia entre ambos puntos
	 */
	public double distancia(Punto p) { return Math.hypot(x - p.x , y - p.y); }

	/**	Dados dos puntos, obtenemos la distancia que los separan
	 * 
	 * @param p1
	 * @param p2
	 * @return Distancia entre ambos puntos
	 */
	public double distancia(Punto p1, Punto p2) { return Math.hypot(p1.x - p2.x, p1.y - 2 - y); }

	/**	Obtenemos el cuadrante al que pertenece el punto
	 * 
	 * @return Un entero que representa el cuadrante al que pertenece el punto
	 */

	public int cuadrante()
	{	int cuadrante;
		if (x >= 0 && y >= 0) cuadrante = 1;
		if (x > 0 && y < 0)   cuadrante = 4;
		if (x < 0 && y > 0)	  cuadrante = 2;
		else 				  cuadrante = 3;
		return cuadrante;
	}
}
