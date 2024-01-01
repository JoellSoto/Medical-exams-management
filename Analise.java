import java.io.*;
public abstract class Analise implements Calculo, Serializable
{
	protected int codigo, numeroTelefone, ano;
	protected String numeroBI, nome, genero, dataAnalise, formaPagamento, tipoAnalise;
	protected byte idade, dia, mes;
	protected double valorAnalise;

	public Analise(int cod, int nT, String nB, String nome, String gene, String data,String pa, String tipo,byte ida, double vp)
	{
		codigo = cod;
		numeroTelefone = nT;
		numeroBI = nB;
		this.nome = nome;
		genero = gene;
		setData(data);
		formaPagamento = pa;
		tipoAnalise = tipo;
		idade = ida;
		valorAnalise = vp;
	}

	public Analise()
	{
		this(0,0,"","","","00/00/0000","","",(byte)0,0);
	}

	//gets
	public int getCodigo(){return codigo;}
	public int getNumeroTelefone(){return numeroTelefone;}
	public String getNumeroBI(){return numeroBI;}
	public String getNome(){return nome;}
	public String getGenero(){return genero;}
	
	public String getData()
	{
		String date="";		
		if(dia<10) date+="0"+dia+"/";
		else date+=dia+"/";
		if(mes<10) date+="0"+mes+"/";
		else date+=mes+"/";
		date+=ano;
		return date;
	}
	public byte getDia(){return dia;}
	public byte getMes(){return mes;}
	public int getAno(){return ano;}

	public String getFormaPagamento(){return formaPagamento;}
	public byte getIdade(){return idade;}
	public double getValorAnalise(){return valorAnalise;}
	public String getTipoAnalise(){return tipoAnalise;}

	//sets
	public void setCodigo(int codigo){
		if(codigo>0)
			this.codigo = codigo;
	}
	public void setNumeroTelefone(int numeroTelefone){
		if(numeroTelefone>800000000&&numeroTelefone<899999999)
			this.numeroTelefone = numeroTelefone;
	}
	public void setNumeroBI(String numeroBI){
		if(numeroBI.length()!=0)
			this.numeroBI = numeroBI;
	}
	public void setNome(String nome){
		if(nome.length()!=0)
			this.nome = nome;
	}
	public void setGenero(String genero){
		if(genero.length()!=0)
			this.genero = genero;
	}
	public void setData(String date)
	{
		dia = Byte.parseByte(date.substring(0,2));
		mes = Byte.parseByte(date.substring(3,5));
		ano = Integer.parseInt(date.substring(6,10));
	}
	public void setFormaPagamento(String formaPagamento){
		if(formaPagamento.length()!=0)
			this.formaPagamento =formaPagamento;
	}
	public void setTipo(String tipoAnalise){
		if(tipoAnalise.length()!=0)
			this.tipoAnalise = tipoAnalise;
	}
	public void setIdade(byte idade){
		if(idade>0)
			this.idade =idade;
	}
	public void setValorAnalise(double valorAnalise){
		if(valorAnalise>0)
			this.valorAnalise =valorAnalise;
	}

	public String toString(){
		return codigo+
				";"+numeroTelefone+
				";"+numeroBI+
				";"+nome+
				";"+idade+
				";"+genero+
				";"+getData()+
				";"+formaPagamento+
				";"+valorAnalise+
				";"+tipoAnalise+";";
	}
}