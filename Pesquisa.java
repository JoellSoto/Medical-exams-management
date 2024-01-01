import java.util.*;

public class Pesquisa
{
	public Pesquisa(){}

	public int pesquisarAnalise(Vector vector, int id)
	{
		Analise a;
		for(int i=0;i<vector.size();i++)
		{
			a = (Analise) vector.elementAt(i);
			if(a.getCodigo()==id)
				return i;
		}
		return -1;
	}
	public int pesquisarBi(Vector v, String id)
	{
		Analise a;
		for(int i=0;i<v.size();i++)
		{
			a=(Analise)v.elementAt(i);
			if(a.getNumeroBI().equalsIgnoreCase(id))
				return i;
		}return -1;
	}
	
	public int pesquisarNome(Vector v, String nome)
	{
		Analise a;
		for(int i=0;i<v.size();i++)
		{
			a=(Analise)v.elementAt(i);
			if(a.getNome().equalsIgnoreCase(nome))
				return i;
		}return -1;
	}
}