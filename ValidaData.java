class ValidaData{
	
	// 1. Valida dia (Consideraremos que todos os meses tem 30 dias)
	static boolean isDia(int dia){
		return (dia >= 1 && dia <= 30);
	}
	
	static boolean isDia(String dia){
		int d = Integer.parseInt(dia);
		return (d >= 1 && d <= 30);
	}
	
	
	// 2. Valida mes
	static boolean isMes(int mes){
		return (mes >= 1 && mes <= 12);
	}
	
	static boolean isMes(String mes){
		// Padronizando a entrada em minuscula
		String mesMin = mes.toLowerCase();
		
		// Meses disponiveis
		String[] meses = {"janeiro", "fevereiro", "marco", "abril", "maio",
		"junho", "julho", "agosto", "setembro", "outubro", "novembro",
		"dezembro"};
		
		for (String m: meses){
			if (m.equals(mesMin)){
				return true;
			}
		}	
		
		return false;
	}
	
	
	// 3. Valida ano (consideraremos a idade máxima como 100 anos)
	static boolean isAno(int ano){
		int anoAtual = 2023, idadeMax = 100;
		int anoMaxNascimento = 2023 - idadeMax;
		return (ano >= anoMaxNascimento && ano <= anoAtual);
	}
	
	static boolean isAno(String ano){
		int anoAtual = 2023, idadeMax = 100;
		int anoMaxNascimento = 2023 - idadeMax;
		int a = Integer.parseInt(ano);
		return (a >= anoMaxNascimento && a <= anoAtual);
	}
	
	
	// 4. Valida a data completa
	static boolean isData(int dia, int mes, int ano){
		return ValidaData.isAno(ano) &&
		ValidaData.isMes(mes) &&
		ValidaData.isDia(dia);
	}
	
	static boolean isData(String dia, String mes, String ano){
		int anoInt = Integer.parseInt(ano);
		int mesInt = Integer.parseInt(mes);
		int diaInt = Integer.parseInt(dia);
		
		return isData(diaInt, mesInt, anoInt);
	}
	
	// 5. Imprime a data completa
	static String imprimeData(int dia, int mes, int ano){
		return (dia + "/" + mes + "/" + ano); 
	}
	
}