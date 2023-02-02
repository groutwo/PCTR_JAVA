import java.rmi.*;

/**  @aIgnacio */
public interface iBonoloto extends Remote
{
	/**  	@param nums Números a comprobar
	 * 		@return true si los números coinciden; false en caso contrario */
	public boolean comprobarNumeros(int[] nums) throws RemoteException;
}
