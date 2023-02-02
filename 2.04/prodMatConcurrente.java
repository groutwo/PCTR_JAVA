/** @author Ignacio */
public class prodMatConcurrente extends Thread
{
	int filasA, columnasA, filasB, columnasB;
	int[][] a, b, c;

	public prodMatConcurrente(int[][] a, int[][] b, int[][] c, int filasA, int columnasA, int filasB, int columnasB)
	{	this.filasA = filasA; this.columnasA = columnasA;
		this.filasB = filasB; this.columnasB = columnasB;
		this.a = a;		this.b = b;		this.c = c;
	}

	public void run()
	{	for (int columnaB = 0; columnaB < columnasB; columnaB++)
			for (int columnaA = 0; columnaA < columnasA; columnaA++)
				c[filasA][columnaB] += a[filasA][columnaA] * b[columnaA][columnaB];
	}

}