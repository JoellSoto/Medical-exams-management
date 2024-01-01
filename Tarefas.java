import java.io.*;
import java.util.*;

public class Tarefas implements ConstrutorTabela{	
	private Vector vector;
	private int quantidadeBioquimica, 
				quantidadeHematologia,
				quantidadeMicrobiologia;

	public Tarefas()
	{
		quantidadeBioquimica =0;
		quantidadeHematologia = 0;
		quantidadeMicrobiologia =0;
		vector = new Vector();
	}

	//METODOS DE LEITURA E GRAVACAO
		//Gravacao
	public String salvarFicheiroTexto(String nomeF)
	{
		ManipularFicheiro mp  = new ManipularFicheiro();
		return mp.gravar(nomeF,vector);
	}

	public String salvarFicheiroObjecto(String nomeF)
	{
		ManipularFicheiro mp  = new ManipularFicheiro();
		return mp.gravarObjecto(nomeF,vector);
	}

		//Leitura
	public String lerFicheiroObjecto(String nomeF)
	{
		try
		{
			FileInputStream fi = new FileInputStream(nomeF);
			ObjectInputStream ob = new ObjectInputStream(fi);
			vector = (Vector)ob.readObject();
			ob.close();
			contarAnalises();
			return"Dados carregados!!";
		}
		catch(FileNotFoundException fl){return "Ficheiro nao encontrado!";}
		catch(ClassNotFoundException i){return "Erro Critico!";}
		catch(IOException io){return "Erro";}
	}

	private void contarAnalises()
	{
		Analise a;
		for(int i=0;i<vector.size();i++)
		{
			a = (Analise)vector.elementAt(i);
			if(a instanceof Microbiologia)
				quantidadeMicrobiologia++;
			else if(a instanceof Hematologia)
				quantidadeHematologia++;
			else
				quantidadeBioquimica++;
		}
			
	}

	public String lerFicheiroTexto(String nomeF)
	{
		try
		{
			FileReader fr = new FileReader(nomeF);
			BufferedReader z = new BufferedReader(fr);
			StringTokenizer tk; 

			int codigo, numeroT, qGVermelhos, 
				qGBrancos, qPlaquetas;
			byte ida;
			String numeroBI, nome, genero, data, fPagamento,
					tipo, transA, bUrina, bFezes;
			double vp;
			float qGlicose, qColesterol, fCardiaca, fRenal;

			String linha  = z.readLine();
			while(linha!=null)
			{
				//Dados gerais
				tk = new StringTokenizer(linha,";");

				codigo = Integer.parseInt(tk.nextToken());
				numeroT = Integer.parseInt(tk.nextToken());
				numeroBI = tk.nextToken();
				nome = tk.nextToken();
				ida = Byte.parseByte(tk.nextToken());
				genero = tk.nextToken();
				data = tk.nextToken();
				fPagamento = tk.nextToken();
				vp = Double.parseDouble(tk.nextToken());
				tipo  =tk.nextToken();

				if(tipo.equals("Bioquimica"))
				{
					qGlicose = Float.parseFloat(tk.nextToken());
					qColesterol = Float.parseFloat(tk.nextToken());
					fCardiaca = Float.parseFloat(tk.nextToken());
					fRenal = Float.parseFloat(tk.nextToken());
					adicionarBioquimica(codigo,numeroT,numeroBI,nome,genero,data,fPagamento,ida,
						vp,qGlicose,qColesterol,fCardiaca,fRenal);
				}
				else if(tipo.equals("Hematologia"))
				{
					qGVermelhos = Integer.parseInt(tk.nextToken());
					qGBrancos = Integer.parseInt(tk.nextToken());
					qPlaquetas = Integer.parseInt(tk.nextToken());
					transA = tk.nextToken();
					adicionarHematologia(codigo,numeroT,numeroBI,nome,genero,data,fPagamento,
						ida,vp,qGVermelhos,qGBrancos,qPlaquetas,transA);
				}
				else
				{
					bUrina = tk.nextToken();
					bFezes = tk.nextToken();
					adicionarMicrobiologia(codigo,numeroT,numeroBI,nome,genero,data,
						fPagamento,ida,vp,bUrina,bFezes);
				}
				
				linha = z.readLine();
			}
			z.close();
			return "Dados carregados!!";
		}
		catch(FileNotFoundException a){return "Dados nao Encontrados!";}
		catch(IOException b){return "Erro!";}
	}

	private void adicionarHematologia(int cod, int nT, String nB, String nome, String gene,
	 String data,String pa, byte ida, double vp, int qV,int qB,int qP,String tA)
	{
		Hematologia a = new Hematologia();
		a.setCodigo(cod);
		a.setNumeroTelefone(nT);
		a.setNumeroBI(nB);
		a.setNome(nome);
		a.setGenero(gene);
		a.setData(data);
		a.setFormaPagamento(pa);
		a.setIdade(ida);
		a.setValorAnalise(vp);
		a.setQuantidadeGVermelhos(qV);
		a.setQuantidadeGBrancos(qB);
		a.setQuantidadePlaquetas(qP);
		if(tA.equals("Sim"))
			a.setTransporteAmostra(true);
		else
			a.setTransporteAmostra(false);
		adicionarAnalise(a);
	}

	private void adicionarBioquimica(int cod, int nT, String nB, String nome, String gene,
	 String data,String pa, byte ida, double vp,float qGli, float qCo,float fCardi, float fRenal)
	{
		Bioquimica a = new Bioquimica();
		a.setCodigo(cod);
		a.setNumeroTelefone(nT);
		a.setNumeroBI(nB);
		a.setNome(nome);
		a.setGenero(gene);
		a.setData(data);
		a.setFormaPagamento(pa);
		a.setIdade(ida);
		a.setValorAnalise(vp);
		a.setQuantidadeGlicose(qGli);
		a.setQuantidadeColesterol(qCo);
		a.setFuncaoCardiaca(fCardi);
		a.setFuncaoRenal(fRenal);
		adicionarAnalise(a);
	}

	private void adicionarMicrobiologia(int cod, int nT, String nB, String nome, String gene,
	 String data,String pa, byte ida, double vp,String bU, String bF)
	{
		Microbiologia a = new Microbiologia();
		a.setCodigo(cod);
		a.setNumeroTelefone(nT);
		a.setNumeroBI(nB);
		a.setNome(nome);
		a.setGenero(gene);
		a.setData(data);
		a.setFormaPagamento(pa);
		a.setIdade(ida);
		a.setValorAnalise(vp);
		if(bU.equals("Sim"))
			a.setBacteriasUrina(true);
		else
			a.setBacteriasUrina(false);

		if(bF.equals("Sim"))
			a.setBacteriasFezes(true);
		else
			a.setBacteriasFezes(false);
		adicionarAnalise(a);
	}
	//fim metodos de leitura e gravacao

	//ADAPTADORES//

		//Metodos da Interface ContrutorTabela
	public int pesquisarAnaliseT(int id)
	{
		return pesquisarCodigo(id);
	}

		//ordenar por data
	public void ordenarPorData()
	{
		Ordenar o = new Ordenar();
		vector = o.ordenarPorData(vector);
	}

	public String[][] dadosDoElementoT(int posicao)
	{
		FormataDados f = new FormataDados();
		Analise a = (Analise)vector.elementAt(posicao);
		return f.formatarDadoElementoAnalise(a);
	}

	public String lucroPrejuizo()
	{
		Valores val = new Valores();
		FormataDados f = new FormataDados();
		double total, somaB,somaH,somaM;
		somaB = val.valorGanhoBioquimica(vector);
		somaH = val.valorGanhoHematologia(vector);
		somaM = val.valorGanhoMicrobiologia(vector);
		return f.formatarLucroPrejuizo(val.lucroPrejuizo(somaM,somaH,somaB));
	} 

	public String[][] quantidades()
	{
		FormataDados f = new FormataDados();
		return f.formatarQuantidades(quantidadeBioquimica,
			quantidadeHematologia,quantidadeMicrobiologia);
	}

	public String[][] todasAnalises()
	{
		FormataDados f = new FormataDados();
		return f.formatarTodasAnalises(vector);
	}

	public String[][] valorGanho()
	{
		Valores val = new Valores();
		FormataDados f = new FormataDados();
		double total, somaB,somaH,somaM;
		somaB = val.valorGanhoBioquimica(vector);
		somaH = val.valorGanhoHematologia(vector);
		somaM = val.valorGanhoMicrobiologia(vector);

		return f.formatarValorGanho(somaB,somaH,somaM);
	}

	public String[][] valorGanhoSeguros()
	{
		Valores val = new Valores();
		FormataDados f = new FormataDados();
		double total, somaB,somaH,somaM;

		somaB = val.valorGanhoSegurosB(vector);
		somaH = val.valorGanhoSegurosH(vector);
		somaM = val.valorGanhoSegurosM(vector);

		return f.formatarValorGanho(somaB,somaH,somaM);
	}

	public String[][] todasBioquimica()
	{
		FormataDados f = new FormataDados();
		return f.formatarTodasBioquimica(vector,quantidadeBioquimica);
	}
	public String[][] colesterolAlto()
	{
		FormataDados f = new FormataDados();
		return f.formatarColesterolAlto(vector,quantidadeBioquimica);
	}

	public String[][] todasHematologia()
	{
		FormataDados f = new FormataDados();
		return f.formatarTodasHematologia(vector,quantidadeHematologia);
	}
	public String[][] anemia()
	{
		FormataDados f = new FormataDados();
		return f.formatarAnemia(vector,quantidadeHematologia);
	}

	public String[][] todasMicrobiologia()
	{
		FormataDados f = new FormataDados();
		return f.formatarTodasMicrobiologia(vector,quantidadeMicrobiologia);
	}

	public String[][] infeccao()
	{
		FormataDados f = new FormataDados();
		return f.formatarInfeccao(vector,quantidadeMicrobiologia);
	}
		//fim de Metodos da Interface ContrutorTabela

		//Pesquisas
	public int pesquisarCodigo(int codigo)
	{
		Pesquisa p = new Pesquisa();
		return p.pesquisarAnalise(vector,codigo);
	}

	public int pesquisarNome(String nome)
	{
		Pesquisa p = new Pesquisa();
		return p.pesquisarNome(vector,nome);
	}

	public int pesquisarBI(String bi)
	{
		Pesquisa p = new Pesquisa();
		return p.pesquisarBi(vector,bi);
	}
		
		//Remover analise
	public void removerAnalise(int posi)
	{
		vector.removeElementAt(posi);
		vector.trimToSize();
	}

		//Alterar
	public void alterarAnalise(Analise a, int posi)
	{vector.setElementAt(a,posi);}

		//pega analise
	public Analise getAnalise(int posi)
	{
		return (Analise) vector.elementAt(posi);
	}

	//Validacao de Analise
	public String validarAnalise(Analise a)
	{	
		Validar v = new Validar();
		String erro="";
		erro+=v.validarNumeroTelefone(a.getNumeroTelefone());
		erro+="\n"+v.validarNumeroBI(a.getNumeroBI());
		erro+="\n"+v.validarNome(a.getNome());
		erro+="\n"+v.validarIdade(a.getIdade());

		if(a instanceof Hematologia)
			erro+=validarHematologia((Hematologia)a,erro);
		else if(a instanceof Bioquimica)
			erro+=validarBioquimica((Bioquimica)a,erro);
		
		if(erro.length()<=12)
			erro = "Analise Valida!";
		return erro;
	}

	private String validarBioquimica(Bioquimica a, String msg)
	{
		Validar v = new Validar();
		String erro = msg;
		erro+="\n"+v.validarQuantidadeGlicose(a.getQuantidadeGlicose());
		erro+="\n"+v.validarQuantidadeColesterol(a.getQuantidadeColesterol());
		erro+="\n"+v.validarFuncaoCardiaca(a.getFuncaoCardiaca());
		erro+="\n"+v.validarFuncaoRenal(a.getFuncaoRenal());
		return erro;
	}

	private String validarHematologia(Hematologia a, String msg)
	{
		Validar v = new Validar();
		String erro=msg;
		erro+="\n"+v.validarQuantidadeGVermelhos(a.getQuantidadeGVermelhos());
		erro+="\n"+v.validarQuantidadeGBrancos(a.getQuantidadeGBrancos());
		erro+="\n"+v.validarQuantidadePlaquetas(a.getQuantidadePlaquetas());
		return erro;
	}


		//Adicao de analise
	public void adicionarAnalise(Analise a)
	{
		if(a instanceof Microbiologia)
			quantidadeMicrobiologia++;
		else if(a instanceof Hematologia)
			quantidadeHematologia++;
		else
			quantidadeBioquimica++;
		vector.addElement(a);
		vector.trimToSize();
	}

	public int novoCodigo()
	{
		return 10000 +totalDeAnalises();
	}

	public int totalDeAnalises(){
		return quantidadeBioquimica+quantidadeHematologia+quantidadeMicrobiologia;
	}
}