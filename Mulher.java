class Mulher extends PessoaIMC{
	private int idade;
	private static int contagemM = 0;
	
	// Construtor 1
	Mulher(String nome, String sobreNome, int dia, int mes, int ano,
	float altura, float peso, int idade)){
		super(nome, sobreNome, dia, mes, ano, altura, peso);
		this.idade = idade;
		contagemM++;
	}
	
	// Construtor 2
	Mulher(String nome, String sobreNome, int dia, int mes, int ano,
	String numCPF, int idade){
		super(nome, sobreNome, dia, mes, ano, numCPF, altura, peso);
		this.idade = idade;
		contagemM++;
	}
	
	public String resultIMC(){
		float IMC = calculaIMC(this.peso, this.altura);
		if (IMC < 19){
			return "Abaixo do peso ideal";
		} else if (IMC <= 25.8){
			return "Peso ideal";
		} else{
			return "Acima do peso ideal";
		}
	}
	
	// Formato de saida padrao
	public String toString(){
		String str = super.toString();
		str += ("\nGenero: Mulher\nIdade: " + idade + "\nIMC: " +
		resultIMC() + "\n");
		return str;
	}
	
	
	// Contagem do numero de objetos criados
	static int numMulheres(){
		return contagemM;
	}
}
