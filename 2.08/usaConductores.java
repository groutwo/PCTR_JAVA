/**	@author Ignacio  */
public class usaConductores extends Conductores
{
	public static void main(String[] args)
	{
		Conductor c1 = new Conductor("dni", "nombre", "apellidos", 10);
		conductores.add(c1);
		c1.sumarPunto(3);
		c1.quitarPuntos(5);

		Conductor c2 = new Conductor("dni2", "nombre2", "apellidos2", 14);
		conductores.add(c2);
		c2.quitarPuntos(6);
		c2.sumarPunto(4);
		
		Conductor c3 = new Conductor("dni3", "nombre3", "apellidos3", 14);
		conductores.add(c3);
		
		System.out.println("\n"+conductores.toString());
				
		conductores.remove(c3);
		
		System.out.println("\n"+conductores.toString());
	    
	    System.out.println("fin");
	}
}
