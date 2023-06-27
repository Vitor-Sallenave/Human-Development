class ValidaPessoa{
	
	public static boolean isAltura(float altura){
		return (altura > 0 && altura < 2.2f);
	}
	
	public static boolean isPeso(float peso){
		return (peso > 0 && peso < 400);
	}
	
	public static boolean isIdade(int idade){
		return (idade > 0 && idade <= 100);
	}
	
	public static boolean isGenero(String genero){
		return (genero.equals("mulher") || genero.equals("homem"));
	}
	
	public static boolean isNomeSobrenome(String nome){
		char c;
		
		for (int k = 0; k < nome.length(); k++){
			c = nome.charAt(k);
			if (Character.isDigit(c)){
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isPessoa(String genero, String nome, String sobreNome, int dia,
	int mes, int ano, String numCPF, float altura, float peso, int idade){
		boolean status = isGenero(genero) && isNomeSobrenome(nome)
		&& isNomeSobrenome(sobreNome) && ValidaData.isData(dia, mes, ano) &&
		ValidaCPF.isCPF(numCPF) && isAltura(altura) && isPeso(peso)
		&& isIdade(idade);
			
		return status;
	}
	
	public static boolean isPessoa(String genero, String nome, String sobreNome, int dia,
	int mes, int ano){
		boolean status = isGenero(genero) && isNomeSobrenome(nome)
		&& isNomeSobrenome(sobreNome) && ValidaData.isData(dia, mes, ano);
			
		return status;
	}
}