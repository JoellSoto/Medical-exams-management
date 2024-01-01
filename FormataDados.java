import java.util.*;
import java.text.DecimalFormat;

public class FormataDados
{
	public FormataDados(){}

	public String formatarLucroPrejuizo(double val)
	{
		DecimalFormat moeda = new DecimalFormat("###,###.00 MZN");
		String msg;
		if(val<0)
			msg = "Prejuizo: ";
		else 
			msg = "Lucro: ";
		return msg+moeda.format(val);
	}

	public String[][] formatarDadoElementoAnalise(Analise a)
	{
		String[][] dados = new String[1][9];
		dados[0][0] = ""+a.getCodigo();
		dados[0][1] = a.getNome();
		dados[0][2]=""+a.getIdade();
		dados[0][3]=a.getNumeroBI();
		dados[0][4]=""+a.getNumeroTelefone();
		dados[0][5]=a.getGenero();
		dados[0][6]=a.getTipoAnalise();
		dados[0][7]=a.getFormaPagamento();
		dados[0][8]=a.getData();
		return dados;
	}

	public String[][] formatarQuantidades(int b, int h, int m)
	{
		String[][] dados = new String[4][2];
		dados[0][0] = "Bioquimica"; 
		dados[0][1] = ""+b;
		dados[1][0]="Hematologia";
		dados[1][1] = ""+h;
		dados[2][0] = "Microbiologia";
		dados[2][1] = ""+m;
		dados[3][0]="TOTAL";
		dados[3][1]=""+(b+h+m);
		return dados;
	}

	public String[][] formatarTodasAnalises(Vector vector)
	{
		Analise a;
		String[][] dados = new String[vector.size()][9];
		for(int i=0;i<vector.size();i++)
		{
			a = (Analise)vector.elementAt(i);
			dados[i][0] = ""+a.getCodigo();
			dados[i][1] = a.getNome();
			dados[i][2]=""+a.getIdade();
			dados[i][3]=a.getNumeroBI();
			dados[i][4]=""+a.getNumeroTelefone();
			dados[i][5]=a.getGenero();
			dados[i][6]=a.getTipoAnalise();
			dados[i][7]=a.getFormaPagamento();
			dados[i][8]=a.getData();
		}
		return dados;
	}

	public String[][] formatarValorGanho(double b, double h, double m)
	{
		DecimalFormat moeda = new DecimalFormat("###,###.00");
		String[][] dados = new String[4][2];
		double total = b+h+m;
		dados[0][0] = "Bioquimica"; 
		dados[0][1] = moeda.format(b);
		dados[1][0]="Hematologia";
		dados[1][1] = moeda.format(h);
		dados[2][0] = "Microbiologia";
		dados[2][1] = moeda.format(m);
		dados[3][0]="TOTAL";
		dados[3][1]=moeda.format(total);
		return dados;
	}

	public String[][] formatarTodasBioquimica(Vector vector, int quant)
	{
		Bioquimica b;
		Analise a;
		String[][] dados = new String[quant][12];
		int i=0,o=0;
		while(i<quant&&i<vector.size())
		{
			a = (Analise)vector.elementAt(o);
			if(a instanceof Bioquimica)
			{
				b=(Bioquimica)a;
				dados[i][0] = ""+b.getCodigo();
				dados[i][1] = b.getNome();
				dados[i][2]=""+b.getIdade();
				dados[i][3]=b.getNumeroBI();
				dados[i][4]=""+b.getNumeroTelefone();
				dados[i][5]=b.getGenero();
				dados[i][6]=b.getTipoAnalise();
				dados[i][7]=""+b.getQuantidadeGlicose();
				dados[i][8]=""+b.getQuantidadeColesterol();
				dados[i][9]=""+b.getFuncaoCardiaca();
				dados[i][10]=""+b.getFuncaoRenal();
				dados[i][11]=b.getData();
				i++;
			}
			o++;
		}
		return dados;
	}

	public String[][] formatarTodasHematologia(Vector vector,int quant)
	{
		Hematologia b;
		Analise a;
		String[][] dados = new String[quant][12];
		int i=0,o=0;
		while(i<quant&&i<vector.size())
		{
			a = (Analise)vector.elementAt(o);
			if(a instanceof Hematologia)
			{
				b=(Hematologia)a;
				dados[i][0] = ""+b.getCodigo();
				dados[i][1] = b.getNome();
				dados[i][2]=""+b.getIdade();
				dados[i][3]=b.getNumeroBI();
				dados[i][4]=""+b.getNumeroTelefone();
				dados[i][5]=b.getGenero();
				dados[i][6]=b.getTipoAnalise();
				dados[i][7]=""+b.getQuantidadeGBrancos();
				dados[i][8]=""+b.getQuantidadeGVermelhos();
				dados[i][9]=""+b.getQuantidadePlaquetas();
				if(b.getTransporteAmostra()==true)
					dados[i][10]="Sim";
				else
					dados[i][10]="Nao";
				dados[i][11]=b.getData();
				i++;
			}
			o++;
		}
		return dados;
	}

	public String[][] formatarTodasMicrobiologia(Vector vector, int quant)
	{
		Microbiologia b;
		Analise a;
		String[][] dados = new String[quant][10];
		int i=0,o=0;
		while(i<quant&&i<vector.size())
		{
			a = (Analise)vector.elementAt(o);
			if(a instanceof Microbiologia)
			{
				b=(Microbiologia)a;
				dados[i][0] = ""+b.getCodigo();
				dados[i][1] = b.getNome();
				dados[i][2]=""+b.getIdade();
				dados[i][3]=b.getNumeroBI();
				dados[i][4]=""+b.getNumeroTelefone();
				dados[i][5]=b.getGenero();
				dados[i][6]=b.getTipoAnalise();
				if(b.getBacteriasUrina()==true)
					dados[i][7]="Sim";
				else
					dados[i][7]="Nao";
				if(b.getBacteriasFezes()==true)
					dados[i][8]="Sim";
				else
					dados[i][8]="Nao";
				dados[i][9]=b.getData();
				i++;
			}
			o++;
			
		}
		return dados;
	}

	public String[][] formatarColesterolAlto(Vector vector, int quant)
	{
		Bioquimica b;
		Analise a;
		String[][] dados = new String[quant][12];
		int i=0,o=0;
		while(i<quant&&i<vector.size())
		{
			a = (Analise)vector.elementAt(o);
			if(a instanceof Bioquimica)
			{
				b=(Bioquimica)a;
				if(b.getQuantidadeColesterol()>15)
				{
					dados[i][0] = ""+b.getCodigo();
					dados[i][1] = b.getNome();
					dados[i][2]=""+b.getIdade();
					dados[i][3]=b.getNumeroBI();
					dados[i][4]=""+b.getNumeroTelefone();
					dados[i][5]=b.getGenero();
					dados[i][6]=b.getTipoAnalise();
					dados[i][7]=""+b.getQuantidadeGlicose();
					dados[i][8]=""+b.getQuantidadeColesterol();
					dados[i][9]=""+b.getFuncaoCardiaca();
					dados[i][10]=""+b.getFuncaoRenal();
					dados[i][11]=b.getData();
				}
				i++;
			}
			o++;
		}
		return dados;
	}

	public String[][] formatarAnemia(Vector vector,int quant)
	{
		Hematologia b;
		Analise a;
		String[][] dados = new String[quant][12];
		int i=0,o=0;
		while(i<quant&&i<vector.size())
		{
			a = (Analise)vector.elementAt(o);
			if(a instanceof Hematologia)
			{
				b=(Hematologia)a;
				if(b.getQuantidadeGVermelhos()<14)
				{
					dados[i][0] = ""+b.getCodigo();
					dados[i][1] = b.getNome();
					dados[i][2]=""+b.getIdade();
					dados[i][3]=b.getNumeroBI();
					dados[i][4]=""+b.getNumeroTelefone();
					dados[i][5]=b.getGenero();
					dados[i][6]=b.getTipoAnalise();
					dados[i][7]=""+b.getQuantidadeGBrancos();
					dados[i][8]=""+b.getQuantidadeGVermelhos();
					dados[i][9]=""+b.getQuantidadePlaquetas();
					if(b.getTransporteAmostra()==true)
						dados[i][10]="Sim";
					else
						dados[i][10]="Nao";
					dados[i][11]=b.getData();
				}
				i++;
			}
			o++;
		}
		return dados;
	}

	public String[][] formatarInfeccao(Vector vector, int quant)
	{
		Microbiologia b;
		Analise a;
		String[][] dados = new String[quant][11];
		int i=0,o=0;
		while(i<quant&&i<vector.size())
		{
			a = (Analise)vector.elementAt(o);
			if(a instanceof Microbiologia)
			{
				b=(Microbiologia)a;
				if(b.getBacteriasUrina()==true||b.getBacteriasFezes()==true)
				{
					dados[i][0] = ""+b.getCodigo();
					dados[i][1] = b.getNome();
					dados[i][2]=""+b.getIdade();
					dados[i][3]=b.getNumeroBI();
					dados[i][4]=""+b.getNumeroTelefone();
					dados[i][5]=b.getGenero();
					dados[i][6]=b.getTipoAnalise();
					if(b.getBacteriasUrina()==true)
						dados[i][7]="Sim";
					else
						dados[i][7]="Nao";
					if(b.getBacteriasFezes()==true)
						dados[i][8]="Sim";
					else
						dados[i][9]="Nao";
					dados[i][10]=b.getData();
				}
				i++;
			}
			o++;
		}
		return dados;
	}






}