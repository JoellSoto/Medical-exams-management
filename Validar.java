public class Validar
{
	public Validar()
	{}
	
	public String validarNumeroTelefone(int numeroTelefone){
		if(numeroTelefone>800000000&&numeroTelefone<899999999)
			return "";
		return "Numero de telemovel invalido!";
	}

	public String validarNumeroBI(String numeroBI){
		if(numeroBI.length()==13)
			return "";	
		return "Numero de BI invalido!";		
	}

	public String validarNome(String nome){
		if(nome.length()>=6)
			return "";
		return "Preencha o nome correctamente!";
	}

	public String validarIdade(byte idade){
		if(idade>=0||idade<120)
			return "";
		return "Preencha a idade correctamente!";
	}

	public String validarQuantidadeGlicose(float qG){
		if(qG>0)
			return "";
		return "Preencha correctamente a quantidade de Glicose!";
	}

	public String validarQuantidadeColesterol(float qG){
		if(qG>0)
			return "";
		return "Preencha correctamente a quantidade de Colesterol!";
	}

	public String validarFuncaoCardiaca(float qG){
		if(qG>0)
			return "";
		return "Preencha correctamente a funcao Cardica!";
	}

	public String validarFuncaoRenal(float qG){
		if(qG>0)
			return "";
		return "Preencha correctamente a funcao Renal!";
	}

	public String validarQuantidadeGVermelhos(int quant){
		if(quant>0)
			return "";
		return "Preencha correctamente a quantidade de Globolos Vermelhos!";
	}

	public String  validarQuantidadeGBrancos(int quant){
		if(quant>0)
			return "";
		return "Preencha correctamente a quantidade de Globolos Brancos!";
	}

	public String validarQuantidadePlaquetas(int quant){
		if(quant>0)
			return "";
		return "Preencha correctamente a quantidade de Plaquetas!";
	}
}