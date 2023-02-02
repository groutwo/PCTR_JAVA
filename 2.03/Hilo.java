/**	@author Ignacio	 */
public class Hilo extends Thread {
	private boolean tipoHilo;
	private static int n = 0; // variable de clase
	private int nVueltas;

	/**	Constructor
	 * 
	 * @param nVueltas
	 * @param tipoHilo
	 */
	public Hilo(int nVueltas, boolean tipoHilo)
	{	this.nVueltas = nVueltas; this.tipoHilo = tipoHilo; }
	
	/**Si no se pone, salta "Implicit super constructor Hilo() is undefined
	 *  for default constructor. Must define an explicit constructor"
	 */
	public Hilo() {}

	public void run() 
	{	if (tipoHilo) 	for (int i = 0; i < nVueltas; ++n, ++i);
		else 			for (int i = 0; i < nVueltas; --n, ++i);
	}
	/**
	 * 
	 * @return el valor de la variable n
	 */
	public static int getN() { return n; }

}
