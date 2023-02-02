/**
 * 
 * @author Ignacio
 *
 */
public class Elipse
{
	private float x, y;

	Elipse(float x, float y)
	{	this.x = Math.abs(x); this.y = Math.abs(y); }

	/**
	 * 
	 * @param a
	 *            coordenada x de un punto
	 * @param b
	 *            coordenada y de un punto
	 * @return booleano que nos indica si dicho punto está contentida en dicha
	 *         elipse
	 */
	boolean pertenece(float a, float b)
	{	return (a <= x && a >= -1 * x && b <= y && b >= -1 * y); }
}
