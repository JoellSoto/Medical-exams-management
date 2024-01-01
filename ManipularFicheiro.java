import java.io.*;
import java.util.*;

public class ManipularFicheiro
{
	public ManipularFicheiro(){}

	
	//METODOS DE SALVAMENTO
	//Grava dados no ficheiro do tipo txt
	public String gravar(String nomeF,Vector v)
	{
		try
		{
			FileWriter fw = new FileWriter(nomeF);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String linha = "";
			Analise a;
			Bioquimica b;
			Hematologia h;
			Microbiologia m;
			
			for(int i=0;i<v.size();i++)
			{
				a = (Analise)v.elementAt(i);
				if(a instanceof Bioquimica)
				{
					b = (Bioquimica)a;
					linha = b.toString();
				}
				else if(a instanceof Hematologia)
				{
					h = (Hematologia)a;
					linha = h.toString();
				}
				else
				{
					m = (Microbiologia)a;
					linha = m.toString();
				}
				bw.write(linha);
				if(i<v.size()-1)
					bw.newLine();
			}
			bw.close();
			return "Ficheiro de texto gravado!!";
		}
		catch(IOException i)
		{return "Erro ao gravar ficheiro de texto!!";}
	}

	//Grava dados no ficheiro de Objecto
	public String gravarObjecto(String nomeOb,Vector v)
	{
		try
		{
			FileOutputStream fo = new FileOutputStream(nomeOb);
			ObjectOutputStream ob = new ObjectOutputStream(fo);
			ob.writeObject(v);
			ob.close();
			return "Ficheiro de objecto gravado!!";
		}
		catch(IOException i){return "Erro ao gravar ficheiro de objecto!!";}
	}
	//FIM	

}