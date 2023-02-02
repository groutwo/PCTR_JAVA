import java.rmi.*;

/** @author Igancio */
public interface iPiMonteCarlo extends Remote
{
	/** @param puntos Número de puntos de apoyo */
	public void contribuir(int puntos) throws RemoteException;

	/** Reinicia datos */
	public void reset() throws RemoteException;
}