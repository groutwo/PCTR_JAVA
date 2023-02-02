/**
 * 
 * @author Ignacio
 *
 */
public class Paciente
{
	private String nombre, dni, direccion, compSeguro, razon, sexo;
	private int tlfn, edad, nss;
	private double peso;

	Paciente(String nombre, String dni, String direccion, String compSeguro, String razon,
			String sexo, int tlfn, int edad, int nss, double peso)
	{
		this.nombre = nombre; 			this.dni = dni;
		this.direccion = direccion;		this.compSeguro = compSeguro;
		this.razon = razon;				this.sexo = sexo;
		this.tlfn = tlfn;				this.edad = edad;
		this.nss = nss;					this.peso = peso;
	}
	
	public String getNombre()	{  	return nombre;	}
	public String getDni() 		{	return dni;		}
	public String getDireccion(){	return direccion;}
	public String getCompSeguro(){	return compSeguro;}
	public String getRazon()	{	return razon; 	}
	public String getSexo() 	{ 	return sexo; 	}
	public int getTlfn() 		{ 	return tlfn; 	}
 	public int getEdad() 		{ 	return edad; 	}
	public int getNss()			{ 	return nss;		}
	public double getPeso()		{ 	return peso; 	}

	public void setNombre(String nombre) 		{ this.nombre = nombre; }
	public void setDni(String dni) 				{ this.dni = dni; }
	public void setDireccion(String direccion) 	{ this.direccion = direccion; }
	public void setCompSeguro(String compSeguro){ this.compSeguro = compSeguro; }
	public void setRazon(String razon) 			{ 	this.razon = razon; }
	public void setSexo(String sexo) 			{ 	this.sexo = sexo; 	}
	public void setTlfn(int tlfn) 				{	this.tlfn = tlfn; 	}
	public void setEdad(int edad) 				{ 	this.edad = edad;  	}
	public void setNss(int nss) 				{ 	this.nss = nss; 	}
	public void setPeso(double peso) 			{ 	this.peso = peso; 	}
}