class Homem extends PessoaIMC{
	private int idade;
	private static int contagemh = 0;
	
	// Construtor 1
	Homem(String nome, String sobreNome, int dia, int mes, int ano,
	float altura, float peso, int idade){
		super(nome, sobreNome, dia, mes, ano, altura, peso);
		this.idade = idade;
		contagemh++;
	}
	
	// Construtor 2
	Homem(String nome, String sobreNome, int dia, int mes, int ano,
	String numCPF, float altura, float peso, int idade){
		super(nome, sobreNome, dia, mes, ano, numCPF, altura, peso);
		this.idade = idade;
		contagemh++;
	}
	
	// Resultado do IMC
	public String resultIMC(){
		float IMC = calculaIMC(this.peso, this.altura);
		if (IMC < 20.7){
			return "Abaixo do peso ideal";
		} else if (IMC <= 26.4){
			return "Peso ideal";
		} else{
			return "Acima do peso ideal";
		}
	}
	
	// Formato de saida padrao
	public String toString(){
		String str = super.toString();
		str += ("\nGenero: Homem\nIdade: " + idade + "\nIMC: " +
		resultIMC() + "\n");
		return str;
	}
	
	// Contagem do numero de objetos criados
	static int numHomens(){
		return contagemh;
	}
} 
