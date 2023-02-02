import java.util.Scanner;
/** @author Ignacio */
public class usaTodo
{
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		int op;
		Poligono PoligonoAOperar = new Poligono();
		do
		{
			System.out.println("Elija que desea crear\n");
			System.out.println("0.- Salir");
			System.out.println("1.- Triangulo");
			System.out.println("2.- Cuadrado");
			System.out.println("3.- Pentagono");
			System.out.println("4.- Hexagono");
			op = sc.nextInt();
			switch (op)
			{
				case 0:		System.out.println("Saliendo del programa..."); break;
				case 1:		System.out.println("Creando un triangulo..."); 	PoligonoAOperar = creaTriangulo(); 	break;
				case 2:		System.out.println("Creando un cuadrado...");	PoligonoAOperar = creaCuadrado(); 	break;
				case 3:		System.out.println("Creando un pentagono...");	PoligonoAOperar = (Pentagono) creaOtro(true); 	break;
				case 4: 	System.out.println("Creando un hexagono...");	PoligonoAOperar = (Hexagono) creaOtro(false);	break;
			}
			if (op != 0)
				do
				{
					System.out.println("\tElija que desea hacer con el poligono creado"
							+ "\n0.- Salir"		
							+ "\n1.- Saber el area"
							+ "\n2.- Saber el perimetro"
							+ "\n3.- Saber el valor de los puntos que lo componen"
							+ "\n4.- Moverlo"
							+ "\n5.- Ampliarlo/hacerle zoom"
							+ "\n6.- Tipo de triangulo"
							+ "\n7.- Jugar con otro poligono");

					op = sc.nextInt();
					System.out.println("El poligono tiene "+PoligonoAOperar.vectorPuntos.length+" puntos");
					switch (op)
					{
						case 0:		System.out.println("Saliendo del programa...");	break;
						case 1:		System.out.println(PoligonoAOperar.area()); 	break;
						case 2:		System.out.println(PoligonoAOperar.perimetro());break;
						case 3:		System.out.println(PoligonoAOperar.toString());break;
						case 4:
									System.out.printf("¿En cuanto quieres mover la coordenada x? "); double dimX = sc.nextDouble();
									System.out.printf("¿En cuanto quieres mover la coordenada y? "); double dimY = sc.nextDouble();
									PoligonoAOperar.moverEn(dimX, dimY);	break;
						case 5:
									System.out.println("Indica el zoom que le quieres hacer al poligono: ");
									double zoom = sc.nextDouble();
									PoligonoAOperar.zoomPoligono(zoom);
						case 6:
									PoligonoAOperar.tipo();
					}
					System.out.println("\n\n");
				} while (op != 0 && op!=7 );
		} while (op != 0);
		sc.close();
		System.out.println("Fin del programa");
	}

	private static Poligono creaOtro(boolean pentagono)
	{
		Punto[] pes = new Punto[3];
		Triangulo[] tes;
		double coordenadaTemp;
		if (pentagono == true)	tes = new Triangulo[3];
		else					tes = new Triangulo[6];
		for (int t = 0; t < tes.length; t++)
		{// 1- Le damos valores a las coordenadas x e y de 3 puntos:
			System.out.println("Sea el triangulo " + (t + 1));
			for (int p = 0; p < pes.length; p++)
			{
				pes[p] = new Punto();
				System.out.print("\nValor de x para el punto "+(p+1)+": "); coordenadaTemp = sc.nextDouble(); pes[p].setX(coordenadaTemp);
				System.out.print("\nValor de y para el punto "+(p+1)+": "); coordenadaTemp = sc.nextDouble();pes[p].setY(coordenadaTemp);
			}
			// 2- Una vez tenemos los 3 puntos, creamos un triangulo a partir de estos:
			tes[t] = new Triangulo();
			tes[t].setListaPuntos(pes);
		}
		// 3- Una vez salimos del bucle externo, tenemos en vector "tes" un conjunto (en este caso 6) de triangulos
		Poligono p;
		if (pentagono == true) p = new Pentagono(tes);
		else p = new Hexagono(tes);
		return p;
	}

	private static Cuadrado creaCuadrado()
	{	System.out.print("Dame el lado del cuadrado: ");
		return new Cuadrado(sc.nextDouble());
	}

	private static Triangulo creaTriangulo()
	{	Punto[] puntos = new Punto[3];
		double coord;
		for (int i = 0; i < puntos.length; i++)
		{	puntos[i] = new Punto();
			System.out.print("Introduce la coordenada x para el punto " + (i + 1) + ": "); coord = sc.nextDouble(); puntos[i].setX(coord);
			System.out.print("Introduce la coordenada y para el punto " + (i + 1) + ": "); coord = sc.nextDouble();	puntos[i].setY(coord);
		}
		return new Triangulo(puntos);
	}
}
