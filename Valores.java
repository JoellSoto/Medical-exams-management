import java.util.*;

public class Valores
{
	public Valores(){}

	public double lucroPrejuizo(double val1, double val2, double val3)
	{
		return val1+val2+val3 - 100000;
	}

	public double valorGanhoHematologia(Vector vector)
	{
		double soma=0;
		Calculo c;

		for(int i=0;i<vector.size();i++)
		{
			c = (Calculo)vector.elementAt(i);
			if(c instanceof Hematologia)
				soma+=c.calcular();
		}
		return soma;
	}

	public double valorGanhoBioquimica(Vector vector)
	{
		double soma=0;
		Calculo c;

		for(int i=0;i<vector.size();i++)
		{
			c = (Calculo)vector.elementAt(i);
			if(c instanceof Bioquimica)
				soma+=c.calcular();
		}
		return soma;
	}

	public double valorGanhoMicrobiologia(Vector vector)
	{
		double soma=0;
		Calculo c;

		for(int i=0;i<vector.size();i++)
		{
			c = (Calculo)vector.elementAt(i);
			if(c instanceof Microbiologia)
				soma+=c.calcular();
		}
		return soma;
	}

	public double valorGanhoSegurosB(Vector vector)
	{
		double soma=0;
		Analise a;
		Calculo c;
		for(int i=0;i<vector.size();i++)
		{
			a = (Analise)vector.elementAt(i);
			if(a.getFormaPagamento().equalsIgnoreCase("Seguro"))
			{
				if(a instanceof Bioquimica)
				{
					c = (Calculo)a;
					soma+=c.calcular();
				}
			}
		}
		return soma;
	}

	public double valorGanhoSegurosH(Vector vector)
	{
		double soma=0;
		Analise a;
		Calculo c;
		for(int i=0;i<vector.size();i++)
		{
			a = (Analise)vector.elementAt(i);
			if(a.getFormaPagamento().equalsIgnoreCase("Seguro"))
			{
				if(a instanceof Hematologia)
				{
					c = (Calculo)a;
					soma+=c.calcular();
				}
			}
		}
		return soma;
	}

	public double valorGanhoSegurosM(Vector vector)
	{
		double soma=0;
		Analise a;
		Calculo c;
		for(int i=0;i<vector.size();i++)
		{
			a = (Analise)vector.elementAt(i);
			if(a.getFormaPagamento().equalsIgnoreCase("Seguro"))
			{
				if(a instanceof Microbiologia)
				{
					c = (Calculo)a;
					soma+=c.calcular();
				}
			}
		}
		return soma;
	}


}