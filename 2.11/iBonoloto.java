import java.rmi.*;

/**  @aIgnacio */
public interface iBonoloto extends Remote
{
	/**  	@param nums N�meros a comprobar
	 * 		@return true si los n�meros coinciden; false en caso contrario */
	public boolean comprobarNumeros(int[] nums) throws RemoteException;
}
