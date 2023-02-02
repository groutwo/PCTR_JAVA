import java.util.ArrayList;
import java.util.Iterator;
/** @author Ignacio  */
public class Conductores
{
	static ArrayList<Conductor> conductores = new ArrayList<Conductor>();

	public Conductores() { conductores = new ArrayList<Conductor>(); }

	/** @param i: �ndice del conductor en el ArrayList */
	public synchronized Conductor obtenerConductor(int i)
	{ return conductores.get(i); }

	/** @param conductor: Nuevo conductor a a�adir */
	public synchronized void agregarConductor(Conductor conductor)
	{ conductores.add(conductor); }

	/** @param conductor:Conductor a eliminar */
	public synchronized void eliminarConductor(Conductor conductor)
	{ conductores.remove(conductor); }

	/** @param conductor: Conductor al que se le sumar� puntos
	 * 	@param puntos: Cantidad de puntos a a�adir
	 */	public synchronized void sumarPuntoConductor(Conductor conductor, int puntos)
	{ conductores.get(conductores.indexOf(conductor)).sumarPunto(puntos); }

	/** @param conductor: Conductor al que se le quitar� puntos
	 * 	@param puntos: Cantidad de puntos a quitar
	 */
	public synchronized void eliminarPuntosConductor(Conductor conductor, int puntos)
	{ conductores.get(conductores.indexOf(conductor)).quitarPuntos(puntos); }

	public String toString()
	{ 	String cad = new String();
		Iterator <Conductor> conductorActual = conductores.iterator();
	    while (conductorActual.hasNext ())
	    { cad+=conductorActual.toString(); conductorActual.next(); }
	    return cad;
	}
}