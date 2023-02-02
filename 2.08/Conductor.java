/** @author Ignacio */
public class Conductor {
	private String dni, nombre, apellidos;
	private int puntos;

	/**
	 * @param dni: 		DNI del conductor
	 * @param nombre: 	Nombre del conductor
	 * @param apellidos:Apellidos del conductor
	 * @param puntos: 	Puntos restantes del conductor
	 */
	public Conductor(String dni, String nombre, String apellidos, int puntos) 
	{	this.dni = dni;				this.nombre = nombre;
		this.apellidos = apellidos;	this.puntos = puntos;
	}
////////////////////////////////////////////////////////////////////////////////////////
	/** @return DNI del conductor */
	public String getDni() { return dni; }
 
	/** @return nombre del conductor */
	public String getNombre() {	return nombre; }

	/** @return apellidos del conductor */
	public String getApellidos() { return apellidos; }

	/** @return puntos restantes del conductor */
	public int getPuntos() { return puntos; }
////////////////////////////////////////////////////////////////////////////////////////	
	/** @param dni: Nuevo DNI del conductor  */
	public void setDni(String dni) { this.dni = dni; }

	/** @param nombre: Nuevo nombre del conductor  */
	public void setNombre(String nombre) { this.nombre = nombre; }

	/** @param apellidos: Nuevos apellidos del conductor */
	public void setApellidos(String apellidos) { this.apellidos = apellidos; }

	/** @param puntos: Puntos restantes del conductor */
	public void setPuntos(int puntos) { this.puntos = puntos; }
////////////////////////////////////////////////////////////////////////////////////////
	/** @param puntos: Cantidad de puntos a suamar */
	public void sumarPunto(int puntos) { this.puntos += puntos; }

	/** @param puntos: Cantidad de puntos a quitar */
	public void quitarPuntos(int puntos) { this.puntos -= puntos; }

	public String toString() 
	{ return nombre + " " + apellidos + " cuyo dni es " + dni + " tiene " + puntos + " puntos\n"; }
}