import java.util.Calendar;
import java.util.GregorianCalendar;

class Pessoa{
	
	// Campos
	private String nome, sobreNome, numCPF;
	private GregorianCalendar dataNasc;
	private float altura, peso;
	private static int contagem = 0;
	
	// Construtor 1
	Pessoa(String nome, String sobreNome, int dia, int mes, int ano){
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.dataNasc = new GregorianCalendar(ano, mes, dia);
		contagem++;
	}
	
	// Construtor 2
	Pessoa(String nome, String sobreNome, int dia, int mes, int ano,
	String numCPF, float altura, float peso){
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.dataNasc = new GregorianCalendar(ano, mes, dia);
		this.numCPF = numCPF;
		this.altura = altura;
		this.peso = peso;
		contagem++;
	}
	
	// Setters
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public void setSobrenome(String sobreNome){
		this.sobreNome = sobreNome;
	}
	
	public void setDataNasc(int dia, int mes, int ano){
		this.dataNasc = new GregorianCalendar(ano, mes, dia);
	}
	
	public void setNumCpf(String CPF){
		this.numCPF = CPF;
	}
	
	public void setAltura(float altura){
		this.altura = altura;
	}
	
	public void setPeso(float peso){
		this.peso = peso;
	}
	
	// Getters
	public String getNome(){
		return nome;
	}
	
	public String getSobrenome(){
		return sobreNome;
	}
	
	public GregorianCalendar getDataNasc(int dia, int mes, int ano){
		return dataNasc;
	}
	
	public String getNumCpf(){
		return numCPF;
	}
	
	public float getAltura(){
		return altura;
	}
	
	public float getPeso(){
		return peso;
	}
	
	// Formato de saida padrao
	public String toString(){
		String str = "INFOS\n=======================================================\n\nNome: "
		+ nome + "\n"
		+ "Sobrenome: " + sobreNome + "\n"
		+ "Data de Nascimento: " +
		ValidaData.imprimeData(dataNasc.get(Calendar.DATE),
		dataNasc.get(Calendar.MONTH), dataNasc.get(Calendar.YEAR)) + "\n"
		+ "CPF: " + ValidaCPF.imprimeCPF(numCPF) + "\n"
		+ "Altura: " + altura + "\n"
		+ "Peso: " + peso;
		
		return str;
	}
	
	// Contagem do numero de objetos criados
	static int numPessoas(){
		return contagem;
	}
	
}