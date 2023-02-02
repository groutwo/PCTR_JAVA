/**	@author Ignacio */
public class Cajero // Nombre de la clase
{
	private int Codigo_Cuenta; // Codigo Cuenta Cliente
	private double Saldo_Cuenta; // Saldo Actual
	
	/**	Constructor sin parametros	*/
	////public Cajero() {}
	
	/**	Constructor con dos parametros
	 * 
	 * @param id
	 * @param disponible
	 */
	public Cajero(int id, double disponible) // constructor
	{ Codigo_Cuenta = id; Saldo_Cuenta = disponible; }
	
	/** @return saldo de la cuenta */
	public double Saldo() // observador
	{ return Saldo_Cuenta; }
	
	/** Añade cantidad
	 * @param Cantidad
	 */
	public void Deposito(double Cantidad) // modificador
	{	if (Saldo_Cuenta > 0) Saldo_Cuenta += Cantidad; }

	/** retira cantidad
	 * @param Cantidad
	 * @return si es posible
	 */
	public boolean Reintegro(double Cantidad) // modificador
	{	if ((Cantidad <= 0) || (Cantidad > Saldo_Cuenta)) return false;
		else Saldo_Cuenta -= Cantidad; return true;
	}

	/** @return el codigo de la cuenta */
	public int Codigo() // observador
	{ return Codigo_Cuenta; }
}