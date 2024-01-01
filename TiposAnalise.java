class Bioquimica extends AnaliseBioquimica
{
	private float quantidadeGlicose, quantidadeColesterol,
					funcaoCardiaca, funcaoRenal;

	public Bioquimica(int cod, int nT, String nB, String nome, String gene, String data, String pa, byte ida, double vp,
		float qGlicose, float qColesterol, float fCardiaca, float fRenal)
	{
		super(cod,nT,nB,nome,gene,data,pa,ida,vp);
		quantidadeGlicose = qGlicose;
		quantidadeColesterol = qColesterol;
		funcaoCardiaca = fCardiaca;
		funcaoRenal = fRenal;
	}
	public Bioquimica()
	{
		this(0,0,"","","","00/00/0000","",(byte)0,0,0f,0f,0f,0f);
	}

	//Metodo da interface
	public double calcular()
	{
		return (valorAnalise*IVA)+valorAnalise;
	}

	//gets
	public float getQuantidadeGlicose(){return quantidadeGlicose;}
	public float getQuantidadeColesterol(){return quantidadeColesterol;}
	public float getFuncaoCardiaca(){return funcaoCardiaca;}
	public float getFuncaoRenal(){return funcaoRenal;}

	//sets
	public void setQuantidadeGlicose(float qG){
		if(qG>0)
			quantidadeGlicose = qG;
	}
	public void setQuantidadeColesterol(float qG){
		if(qG>0)
			quantidadeColesterol = qG;
	}
	public void setFuncaoCardiaca(float qG){
		if(qG>0)
			funcaoCardiaca = qG;
	}
	public void setFuncaoRenal(float qG){
		if(qG>0)
			funcaoRenal = qG;
	}

	public String toString()
	{
		return super.toString()+quantidadeGlicose+
				";"+quantidadeColesterol+
				";"+funcaoCardiaca+
				";"+funcaoRenal+";";
	}
}

//////////////////////////////////////////////
class Hematologia extends AnaliseHematologia
{
	private int quantidadeGVermelhos, quantidadeGBrancos, quantidadePlaquetas;
	private boolean transporteAmostra;

	public Hematologia(int cod, int nT, String nB, String nome, String gene, String data, String pa, byte ida, double vp,
		int qGVer, int qGBra, int qPla, boolean trans)
	{
		super(cod,nT,nB,nome,gene,data,pa,ida,vp);
		quantidadeGVermelhos = qGVer;
		quantidadeGBrancos = qGBra;
		quantidadePlaquetas = qPla;
		transporteAmostra = trans;
	}
	public Hematologia()
	{
		this(0,0,"","","","00/00/0000","",(byte)0,0,0,0,0,false);
	}

	//Metodo da interface
	public double calcular()
	{
		double vp =  (valorAnalise*IVA)+valorAnalise;
		if(idade>50)
			vp = vp-vp*0.2;
		return vp;
	}

	//gets
	public int getQuantidadeGVermelhos(){return quantidadeGVermelhos;}
	public int getQuantidadeGBrancos(){return quantidadeGBrancos;}
	public int getQuantidadePlaquetas(){return quantidadePlaquetas;}
	public boolean getTransporteAmostra(){return transporteAmostra;}
	
	//sets
	public void setQuantidadeGVermelhos(int quant){
		if(quant>0)
			quantidadeGVermelhos = quant;
	}
	public void setQuantidadeGBrancos(int quant){
		if(quant>0)
			quantidadeGBrancos = quant;
	}
	public void setQuantidadePlaquetas(int quant){
		if(quant>0)
			quantidadePlaquetas = quant;
	}
	public void setTransporteAmostra(boolean tf){
		if(tf==false&&transporteAmostra==true)
		{
			valorAnalise = valorAnalise-500;
			transporteAmostra = tf;
		}
		else if(tf==true&&transporteAmostra==false)
		{
			valorAnalise = valorAnalise+500;
			transporteAmostra = tf;
		}
	}

	public String toString(){
		String trans;
		if(transporteAmostra==true)
			trans = "Sim";
		else
			trans = "Nao";
		return super.toString()+quantidadeGVermelhos+
				";"+quantidadeGBrancos+
				";"+quantidadePlaquetas+
				";"+trans+";";
	}
}

//////////////////////////////////////////
class Microbiologia extends AnaliseMicrobiologia
{
	private boolean bacteriasUrina, bacteriasFezes;

	public Microbiologia(int cod, int nT, String nB, String nome, String gene, String data, String pa, byte ida, double vp,
		boolean bu, boolean bf)
	{
		super(cod,nT,nB,nome,gene,data,pa,ida,vp);
		bacteriasUrina = bu;
		bacteriasFezes = bf;
	}
	public Microbiologia()
	{
		this(0,0,"","","","00/00/0000","",(byte)0,0,false,false);
	}

	//Metodo da interface
	public double calcular()
	{
		return (valorAnalise*IVA)+valorAnalise;
	}

	//gets
	public boolean getBacteriasUrina(){return bacteriasUrina;}
	public boolean getBacteriasFezes(){return bacteriasFezes;}

	//sets
	public void setBacteriasUrina(boolean tf){
		bacteriasUrina = tf;
	}
	public void setBacteriasFezes(boolean tf){
		bacteriasFezes = tf;
	}

	public String toString(){
		String bf, bu;
		if(bacteriasUrina==true)
			bu = "Sim";
		else
			bu = "Nao";
		if(bacteriasFezes==true)
			bf = "Sim";
		else
			bf = "Nao";
		return super.toString()+bu+
				";"+bf+";";
	}
	
}