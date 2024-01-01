public class TituloTabela
{
	public TituloTabela(){}

	public String[] tituloAnalise()
	{
		String[] dados = new String[9];
		dados[0] = "Codigo";
		dados[1] = "Nome";
		dados[2]="Idade";
		dados[3]="Numero BI";
		dados[4]="Telefone";
		dados[5]="Genero";
		dados[6]="Tipo";
		dados[7]="Forma de Pagamento";
		dados[8]="Data";
		return dados;
	}

	public String[] tituloQuantidades()
	{
		String[] dados = new String[2];
		dados[0] = "Tipo";
		dados[1] = "Quantidades";
		return dados;
	}

	public String[] tituloValor()
	{
		String[] dados = new String[2];
		dados[0] = "Tipo";
		dados[1] = "Valor (mzn)";
		return dados;
	}

	public String[] tituloBioquimica()
	{
		String[] dados = new String[12];
		dados[0] = "Codigo";
		dados[1] = "Nome";
		dados[2]="Idade";
		dados[3]="Numero BI";
		dados[4]="Telefone";
		dados[5]="Genero";
		dados[6]="Tipo";
		dados[7]="Quantidade Glicose";
		dados[8]="Quantidade Colesterol";
		dados[9]="Funcao Cardiaca b/s";
		dados[10]="Funcao Renal";
		dados[11]="Data";
		return dados;
	}

	public String[] tituloHematologia()
	{
		String[] dados = new String[12];
		dados[0] = "Codigo";
		dados[1] = "Nome";
		dados[2]="Idade";
		dados[3]="Numero BI";
		dados[4]="Telefone";
		dados[5]="Genero";
		dados[6]="Tipo";
		dados[7]="Quantidade G.Vermelhos";
		dados[8]="Quantidade G.Brancos";
		dados[9]="Quantidade Plaquetas";
		dados[10]="Transporte de Amostra";
		dados[11]="Data";
		return dados;
	}

	public String[] tituloMicrobiologia()
	{
		String[] dados = new String[10];
		dados[0] = "Codigo";
		dados[1] = "Nome";
		dados[2]="Idade";
		dados[3]="Numero BI";
		dados[4]="Telefone";
		dados[5]="Genero";
		dados[6]="Tipo";
		dados[7] = "Bacterias Urina";
		dados[8] = "Bacterias Fezes";
		dados[9] = "Data";
		return dados;
	}

}