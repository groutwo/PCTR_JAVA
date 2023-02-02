import java.util.Scanner;
/**
 * 
 * @author Ignacio
 *
 */
public class Biblioteca
{	static final int tamMax = 10;
	static int tamActual = 0;

	public static void main(String[] args)
	{ menu(); }

	static void menu()
	{ Scanner s = new Scanner(System.in);
		int op;
		Paciente[] conjuntoPacientes = new Paciente[tamMax];
		do
		{ 	System.out.println("Elige una opcion:");
			System.out.println("0.- Salir.");
			System.out.println("1.- Insertar.");
			System.out.println("2.- Borrar.");
			System.out.println("3.- Consultar.");
			op = s.nextInt();
			switch (op)
			{	case 1: 	insertar(conjuntoPacientes); 		break;
				case 2: 	borrar(conjuntoPacientes); 			break;
				case 3: 	consultar(conjuntoPacientes); 		break;
				default:	System.out.println("Opcion inválida.");
			}
		} while (op != 0);
		System.out.println("Saliendo del programa");
		s.close();
	}
	
	/**
	 * Inserta un elemento en el vector de objetos de tipo paciente
	 * 
	 * @param vectorDePacientes
	 */
	static void insertar(Paciente[] vectorDePacientes)
	{	if (tamActual < tamMax)  vectorDePacientes[tamActual] = recogeDatos();
		else 		System.out.println("Consulta completa.");
		System.out.println("Saliendo del método insertar");
	}

	/**
	 * Elimina, si es posible el paciente que se desee
	 * 
	 * @param vectorDePacientes
	 */

	static void borrar(Paciente[] vectorDePacientes)
	{	Scanner s = new Scanner (System.in);
		if (tamActual == 0)
			System.out.println("Como no hay Pacientes todavia, no se puede borrar ninguno");
		else
		{	int pacienteABorrar;
			System.out.print("Introduce el indice del Paciente a eliminar: ");
			pacienteABorrar = s.nextInt();
			if (pacienteABorrar < 0 || pacienteABorrar >= tamActual)
				System.out.println("No se puede acceder a dicho indice");
			else
			{	int pacienteSiguiente = pacienteABorrar + 1;
				while (pacienteSiguiente != tamActual)
				{	vectorDePacientes[pacienteABorrar] = vectorDePacientes[pacienteSiguiente];
					pacienteABorrar++;
					pacienteSiguiente++;
				}
				vectorDePacientes[tamActual] = null;
				tamActual--;
			}
		}
		s.close();
	}

	/**
	 * Se permiten realizar diversas operaciones con respecto a dichos pacientes
	 * 
	 * @param conjuntoPacientes
	 */

	static void consultar(Paciente[] vectorDePacientes)
	{	Scanner s = new Scanner(System.in);
		int op; String string = ""; int entero = 0; float flotante = 0.0f;

		System.out.println("Elige el filtro de busqueda:");
		System.out.println("0 .- Consultar todo");

		System.out.println("1 .- Nombre");
		System.out.println("2 .- DNI");
		System.out.println("3 .- Direccion");
		System.out.println("4 .- Compannia de seguros");
		System.out.println("5 .- Razon");
		System.out.println("6 .- Sexo");

		System.out.println("7 .- Telefono");
		System.out.println("8 .- Edad");
		System.out.println("9 .- Numero de la Seguridad Social");

		System.out.println("10.- Peso");

		System.out.println("11.-Salir");
		op = s.nextInt();
		
		if(op==0) 	muestraTodo(vectorDePacientes);
		else		buscaDato(vectorDePacientes,op,string,entero,flotante);
		s.close();
		
	}


	static void buscaDato(Paciente[] vectorDePacientes, int op, String string, int entero, float flotante)
	{	Scanner s = new Scanner (System.in);
		boolean encontrado = false;
		System.out.print("Introduce la(s) ocurrencia(s) que quieres encontrar: ");
		if(op>=1 || op<=6) 				string=s.nextLine();
		else if(op>=7||op<=9) 			entero = s.nextInt();
		else if(op==10) 				flotante = s.nextFloat();
		else System.out.println("Filtro de busqueda inexistente");
		for (int i = 0; i < tamActual; i++)
			if 	(	esta(vectorDePacientes, i ,op, string, entero, flotante)		)
			{
				System.out.println("El paciente en el indice" + (i + 1) + " cumple con los requisitos solicitados");
				encontrado = true;
			}
		if (!encontrado)
			System.out.println("No se ha encontrado ningun usuario con dicha caracteristica");	
		s.close();
	}
 
	 static boolean esta(Paciente[] vectorDePacientes,int i, int op, String string, int entero, float flotante)
	 {	return (	op==1 && vectorDePacientes[i].getNombre() 		== string ||
					op==2 && vectorDePacientes[i].getDni() 			== string ||
					op==3 && vectorDePacientes[i].getDireccion() 	== string ||
					op==4 && vectorDePacientes[i].getCompSeguro() 	== string ||
					op==5 && vectorDePacientes[i].getRazon() 		== string ||
					op==6 && vectorDePacientes[i].getSexo() 		== string
				)
				||
				(	op==7 && vectorDePacientes[i].getTlfn() 		== entero ||
					op==8 && vectorDePacientes[i].getEdad() 		== entero ||
					op==9 && vectorDePacientes[i].getNss()			== entero
				)
				||
				(op==10 && vectorDePacientes[i].getPeso() == flotante);
	}

	/**
	 * Añade un paciente al vector
	 * 
	 * @return el paciente en cuestión
	 */
	static Paciente recogeDatos()
	{	String nombre = null, dni = null, direccion = null, compSeguro = null, razon = null, sexo = null;
		int tlfn = 0, edad = 0, numSeguridadSocial = 0;
		float peso = 0;
		Scanner dato = new Scanner(System.in);
		System.out.println("Introduzca los datos: ");
			System.out.print("Nombre(String): ");						nombre = dato.nextLine();
			System.out.print("DNI(String): "); 							dni = dato.nextLine();
			System.out.print("Direccion(String): "); 					direccion = dato.nextLine();
			System.out.print("Compannia de seguros(String): "); 		compSeguro = dato.nextLine();
			System.out.print("Razon(String): ");						razon = dato.nextLine();
			System.out.print("Sexo(String): ");							sexo = dato.nextLine();
			System.out.print("Telefono(int): ");						tlfn = dato.nextInt();
			System.out.print("Edad(int): ");							edad = dato.nextInt();
			System.out.print("Numero de la Seguridad Social(int): ");	numSeguridadSocial = dato.nextInt();
			System.out.print("Peso(double(con coma, no punto)): ");		peso = dato.nextFloat();

		tamActual++;
		dato.close();
		return new Paciente(nombre, dni, direccion, compSeguro, razon,
				sexo, tlfn, edad, numSeguridadSocial, peso);
	}
	
	/**
	 * muestra todos los datos de todos los pacientes
	 * 
	 * @param todos
	 */
	static void muestraTodo(Paciente[] todos)
	{	if (tamActual == 0) System.out.println("No hay nada que mostrar, porque no hay ningun paciente en la consulta");
		else
		{	System.out.println("El listado de los Pacientes es el siguiente:");
			for (int i = 0; i < tamActual; i++)
				System.out.println("Indice: " 				+ (i + 1) 
						+"\n\t Nombre: " 						+ todos[i].getNombre() 
						+"\n\t DNI: " 							+ todos[i].getDni() 
						+"\n\t Direccion: " 					+ todos[i].getDireccion() 
						+"\n\t Compannia de Seguros: " 			+ todos[i].getCompSeguro() 
						+ "\n\t Razon: " 						+ todos[i].getRazon() 
						+ "\n\t Sexo: " 						+ todos[i].getSexo()
						+ "\n\t Telefono: " 					+ todos[i].getTlfn() 
						+ "\n\t Edad: " 						+ todos[i].getEdad()
						+ "\n\t Numero de la Seguridad Social: "+ todos[i].getNss() 
						+ "\n\t Peso: " 						+ todos[i].getPeso());
		}
	}
}
