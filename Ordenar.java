import java.util.*;

public class Ordenar
{
	public Ordenar(){}

	public Vector ordenarPorData(Vector v)
	{return selectionSort(v);}

	//Ordena
	private Vector selectionSort(Vector v)
	{
		Analise ind;
		int num = v.size()-1;
		for(int i=0;i<num;i++)
		{ 
			ind = (Analise)v.elementAt(i);
				v=trocar(v,i,indiceMax(v,i,num));
		}
		return v;
	}

	private Vector trocar(Vector v, int a, int b)
	{
		Analise aux = (Analise)v.elementAt(a);
		v.setElementAt(v.elementAt(b),a);
		v.setElementAt(aux,b);

		v.trimToSize();
		return v;
	}
	
	private int indiceMax(Vector v, int inicio, int fim)
	{	
		Analise ind;
		int min=inicio;
		for(int i=inicio+1;i<=fim;i++)
		{
			ind = (Analise)v.elementAt(i);
				min = antigO((Analise)v.elementAt(min),(Analise)v.elementAt(i),min,i);
		}
		return min;
	}

	//Retorna a posicao da anlise mais antiga
	private int antigO(Analise um, Analise dois, int p1, int p2)
	{
		//tem dois if's, para tentar provar o inverso
		if(um.getAno()>dois.getAno())
			return p2;
		else if(um.getAno()<dois.getAno())
			return p1;
		else
		{
			if(um.getMes()>dois.getMes())
				return p2;
			else if(um.getMes()<dois.getMes())
				return p1;
			else
			{
				if(um.getDia()>dois.getDia())
					return p2;
				else
					return p1;
			}
		}
	}

}
