/**
 * 
 * @author Ignacio
 *
 */
public class Circulo {
	final static double pi = Math.PI;

	public static void main(String[] args) {
		double diametro = 14.2, altura = 20;
		double radio = diametro / 2;

		double volumen = (pi * radio * radio * altura) / 3;
		System.out.println("El volumen es: " + volumen + "cm^3");

	}
}