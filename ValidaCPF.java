import java.util.InputMismatchException;

class ValidaCPF{
	
	// 1. Verifica se representa um CPF. Formato String:
	static boolean isCPF(String CPFstr){
		
		// Extrai apenas os digitos de CPF
		String CPF = "";
		char c;

		for (int k = 0; k < CPFstr.length(); k++){
			c = CPFstr.charAt(k);
			if (Character.isDigit(c)){
				CPF += c;
			}
		}
		
		// O CPF possui 11 digitos, os quais nao podem ser todos iguais
		boolean expression = CPF.equals("00000000000")
			|| CPF.equals("11111111111") || CPF.equals("22222222222")
			|| CPF.equals("33333333333") || CPF.equals("44444444444")
			|| CPF.equals("55555555555") || CPF.equals("66666666666")
			|| CPF.equals("77777777777") || CPF.equals("88888888888")
			|| CPF.equals("99999999999") || (CPF.length() != 11);
			
		if (expression){
			return (false);
		}
		
		// Calculo dos DVs
		try{
			// Calculo do primeiro DV
			int i, peso = 10, num = 0, soma = 0, calculo;
			char dv1;
			
			for(i = 0; i < 9; i++){
				num = (int)(CPF.charAt(i) - 48);
				soma += peso*num;
				peso --;
			}
			
			calculo = 11 - (soma % 11);
			if (calculo == 10 || calculo == 11) {
				dv1 = '0';
			} else{
				dv1 = (char)(calculo + 48);
			}
			
			// Calculo do segundo DV
			peso = 11; num = 0; soma = 0; calculo = 0;
			char dv2;
			
			// 48 corresponde a posicao do caracter '0'
			for(i = 0; i < 10; i++){
				num = (int)(CPF.charAt(i) - 48);
				soma += peso*num;
				peso --;
			}
			
			calculo = 11 - (soma % 11);
			if (calculo == 10 || calculo == 11) {
				dv2 = '0';
			} else{
				dv2 = (char)(calculo + 48);
			}
			
			// Verificando se os DVs estao corretos
			if ((CPF.charAt(9) == dv1) &&
			(CPF.charAt(10) == dv2)){
				return (true);
			} else{
				return (false);
			}
		} catch(InputMismatchException erro){
			return (false);
		}
		
	}
	
	// Method Overloading em isCPF. Formato Long:
	static boolean isCPF(long CPF){
		String CPFstr = Long.toString(CPF);
		return isCPF(CPFstr);
	}
	
	
	// 2. Imprime o CPF no formato padrao:
	static String imprimeCPF(String CPFstr) {
		// Extrai apenas os digitos de CPF
		String CPF = "";
		char c;

		for (int k = 0; k < CPFstr.length(); k++){
			c = CPFstr.charAt(k);
			if (Character.isDigit(c)){
				CPF += c;
			}
		}
		
        return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
            CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
        }
		
	static String imprimeCPF(long CPF){
		String s = Long.toString(CPF);
		return imprimeCPF(s);
	}
		
	
	// 3. Converte o CPF, string, para Long:
	static long toLongCPF(String CPFstr){
		// Extrai apenas os digitos de CPF
		String CPF = "";
		char c;

		for (int k = 0; k < CPFstr.length(); k++){
			c = CPFstr.charAt(k);
			if (Character.isDigit(c)){
				CPF += c;
			}
		}
		
		return Long.parseLong(CPF);
	}
}
