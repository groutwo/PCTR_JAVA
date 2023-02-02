import java.util.Random;
/** @author Ignacio */
public class Usa_Cajero implements Runnable
{
	private double cantidad;
	private boolean ingresar;
	private Cajero cuentaAOPerar;
	static double Saldo_Cuenta1 = 1000, Saldo_Cuenta2 = 2000;
	static int cantidadOperaciones = 10000;
	/**
	 * Constructor con todos los parametros
	 * @param cant
	 * @param ingresa
	 * @param cuenta
	 */
	Usa_Cajero(double cant, boolean ingresa, Cajero cuenta)
	{ cantidad = cant; ingresar = ingresa; cuentaAOPerar = cuenta; }

	public void run()
	{	
		System.out.println("Entramos con "+ cantidad + " con ingresar a "
		+ ingresar +" a la cuenta "+ cuentaAOPerar.Codigo());
		if (ingresar) cuentaAOPerar.Deposito(cantidad);
		else if (!cuentaAOPerar.Reintegro(cantidad))
			System.out.println("No se ha podido extraer correctamente");
		System.out.println("Hay "+cuentaAOPerar.Saldo()+" en la cuenta "+ cuentaAOPerar.Codigo());
	} 

	public static void main(String[] args)
	{	int id1 = 1, id2 = 2;

		Cajero cajero1 = new Cajero(id1,Saldo_Cuenta1);
		Cajero cajero2 = new Cajero(id2,Saldo_Cuenta2);
		Thread[] myThreadQueSumaCuenta1_ = new Thread[cantidadOperaciones];
		Thread[] myThreadQueRestaCuenta1 = new Thread[cantidadOperaciones];
		Thread[] myThreadQueSumaCuenta2_ = new Thread[cantidadOperaciones];
		Thread[] myThreadQueRestaCuenta2 = new Thread[cantidadOperaciones];
		
		double cantidad;
		for (int i = 0; i < cantidadOperaciones; i++)
		{
			cantidad = new Random().nextDouble();
			Runnable myRunnableQueSuma1_ = new Usa_Cajero(cantidad, true,cajero1);
			Runnable myRunnableQueResta1 = new Usa_Cajero(cantidad, false,cajero1);
			
			cantidad = new Random().nextDouble();
			Runnable myRunnableQueSuma2_ = new Usa_Cajero(cantidad, true,cajero2);
			Runnable myRunnableQueResta2 = new Usa_Cajero(cantidad, false,cajero2);

			myThreadQueSumaCuenta1_[i] = new Thread(myRunnableQueSuma1_);
			myThreadQueRestaCuenta1[i] = new Thread(myRunnableQueResta1);
			myThreadQueSumaCuenta2_[i] = new Thread(myRunnableQueSuma2_);
			myThreadQueRestaCuenta2[i] = new Thread(myRunnableQueResta2);
			
			myThreadQueSumaCuenta1_[i].start();
			myThreadQueRestaCuenta1[i].start();
			myThreadQueSumaCuenta2_[i].start();
			myThreadQueRestaCuenta2[i].start();
		}
		
		for (int i = 0; i < cantidadOperaciones; i++) 
			try { 	myThreadQueSumaCuenta1_[i].join();
					myThreadQueRestaCuenta1[i].join();
					myThreadQueSumaCuenta2_[i].join();
					myThreadQueRestaCuenta2[i].join();	
			} catch (InterruptedException e) { }

	}
}