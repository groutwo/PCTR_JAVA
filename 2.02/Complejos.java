/**
 * 
 * @author Ignacio
 *
 */
public class Complejos
{
	private float c[] = new float[2];

	Complejos(float[] c)
	{ this.c[0] = c[0]; this.c[1] = (c[1] != 0? c[1]:1.0f); }

	float getReal()			{return c[0];	}
	float getImaginario()	{return c[1]; 	}

	Complejos conjudado()
	{
		float[] numeros = {getReal(),-1*getImaginario()};
		return new Complejos(numeros);
	}

	Complejos suma(Complejos a)
	{
		float c[] = {getReal() + a.getReal(), getImaginario() + a.getImaginario()};
		return new Complejos(c);
	}

	Complejos resta(Complejos a)
	{
		float c[] = {getReal() - a.getReal(),getImaginario() - a.getImaginario()};
		return new Complejos(c);
	}

	Complejos multiplica(Complejos complejo2)
	{// (a + bi) · (c + di) = (ac - bd) + (ad + bc)i
		float a = getReal(), b = getImaginario();
		float c = complejo2.getReal(), d = complejo2.getImaginario();
		float vec[] = {a * c - b * d, a * d + b * c};
		return new Complejos(vec);
	}

	Complejos divide(Complejos complejo2)
	{	/* a+bi........ac+bd.........bc-ad.. */
		/* ----....=...------..+....------ i */
		/* c+di........cc+dd.........cc+dd.. */
		float a = getReal(), b = getImaginario();
		float c = complejo2.getReal(), d = complejo2.getImaginario();
		float vec[] = {/**/(a * c + b * d) / (c * c + d * d)	,	(b * c - a * d) / (c * c + d * d)/**/};
		return new Complejos(vec);
	}

	float modulo()
	{/* |z|= raizde(x^2+y^2) */
		return (float) Math.sqrt(getReal() * getReal() + getImaginario() * getImaginario());
	}

}
