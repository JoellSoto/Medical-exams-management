abstract class AnaliseBioquimica extends Analise
{
	public AnaliseBioquimica(int cod, int nT,String nB,String nome,String gene,String data,String pa,byte ida,double vp)
	{super(cod,nT,nB,nome,gene,data,pa,"Bioquimica",ida,vp);}
}

abstract class AnaliseHematologia extends Analise
{
	public AnaliseHematologia(int cod, int nT,String nB,String nome,String gene,String data,String pa,byte ida,double vp)
	{super(cod,nT,nB,nome,gene,data,pa,"Hematologia",ida,vp);}
}

abstract class AnaliseMicrobiologia extends Analise
{
	public AnaliseMicrobiologia(int cod, int nT,String nB,String nome,String gene,String data,String pa,byte ida,double vp)
	{super(cod,nT,nB,nome,gene,data,pa,"Microbiologia",ida,vp);}
}

