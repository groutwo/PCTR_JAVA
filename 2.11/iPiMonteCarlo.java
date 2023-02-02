import java.rmi.*;

/** @author Igancio */
public interface iPiMonteCarlo extends Remote
{
	/** @param puntos N�mero de puntos de apoyo */
	public void contribuir(int puntos) throws RemoteException;

	/** Reinicia datos */
	public void reset() throws RemoteException;
}