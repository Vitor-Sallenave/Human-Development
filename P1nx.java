import java.util.Scanner;

public class P1nx{
	
	public static void linha(){
		System.out.println("\n=======================================================");
	}
	
	public static void main(String[] args){
		
		// Obs.: Leitor de entrada padrão do programa
		Scanner teclado = new Scanner(System.in);
		
		// Printando os argumentos de linha de comando
		System.out.println("\n-- Seus argumentos de linha de comando foram:\n");
		for (String s: args) {
            System.out.println("-> " + s);
        }
		linha();
		
		// Convertendo os argumentos para inteiro caso seja preciso
		int arg3 = Integer.parseInt(args[3]);
		int arg4 = Integer.parseInt(args[4]);
		int arg5 = Integer.parseInt(args[5]);
		float arg7 = Float.parseFloat(args[7]);
		float arg8 = Float.parseFloat(args[8]);
		int arg9 = Integer.parseInt(args[9]);
		
		// Verificando se os argumentos sao validos
		boolean valido = ValidaPessoa.isPessoa(args[0], args[1], args[2], arg3, arg4,
				arg5, args[6], arg7, arg8, arg9);
		
		if (valido){
			if (args[0].equals("homem")){
				Homem m = new Homem(args[1], args[2], arg3, arg4,
				arg5, args[6], arg7, arg8, arg9);
				System.out.print(m.toString());
			} else{
				Mulher m = new Mulher(args[1], args[2], arg3, arg4,
				arg5, args[6], arg7, arg8, arg9);
				System.out.print(m.toString());
			}
		} else{
			System.out.print("\nOs dados digitados na linha de comando sao invalidos\n");
		}
		
		// Verificando a quantidade de objetos adicionais
		linha();
		System.out.println("\nQuantos objetos adicionais voce deseja?");
		int n = teclado.nextInt();
		if (n < 0){
			System.out.println("O número digitado nao e valido");
			n = 0;
		}
		linha();
		
		// Criando o vetor de objetos Mulher/Homem
		Pessoa[] array;
		array = new Pessoa[n];
		
		// Dados
		String gen, nome, sobrenome, numCPF; 
		float altura, peso;
		int idade, i;
		boolean status;
		char resp;
	
		// Armazenando os objetos adicionais
		for (i = 0; i < n; i++){
			
			// Limpando o buffer
			teclado.nextLine();
			
			// Nome
			System.out.printf("\nDigite o nome do objeto (%d): ", i+1);
			nome = teclado.nextLine();
			
			// Sobrenome
			System.out.printf("Digite o sobrenome de %s: ", nome);
			sobrenome = teclado.nextLine();
			
			// Data de Nascimento
			System.out.printf("Digite o dia, mes e ano do nascimento de %s:\n", nome);
			int dia = teclado.nextInt();
			int mes = teclado.nextInt();
			int ano = teclado.nextInt();
			teclado.nextLine();
			
			// CPF
			System.out.printf("Digite o CPF de %s: ", nome);
			numCPF = teclado.nextLine();
			
			// Altura
			System.out.printf("Digite a altura (m) de %s: ", nome);
			altura = teclado.nextFloat();
			teclado.nextLine();
		
			// Peso
			System.out.printf("Digite o peso (kg) de %s: ", nome);
			peso = teclado.nextFloat();
			teclado.nextLine();
			
			// Idade
			System.out.printf("Digite a idade de %s: ", nome);
			idade = teclado.nextInt();
			teclado.nextLine();
			linha();
			
			// Classificacao da pessoa
			System.out.println();
			System.out.printf("%s se classifica como homem ou mulher? ", nome);
			gen = teclado.nextLine();
			linha();
			
			// Verificando os dados digitados
			status = ValidaPessoa.isPessoa(gen, nome, sobrenome, dia, mes, ano, numCPF,
			altura, peso, idade);
			
			if (status){
				// Uma vez que os dados estao todos certos,
				// Temos duas possibilidades:
				if(gen.equals("homem")){
					array[i] = new Homem(nome, sobrenome, dia, mes, ano,
					numCPF, altura, peso, idade);
				} else if (gen.equals("mulher")){
					array[i] = new Mulher(nome, sobrenome, dia, mes, ano,
					numCPF, altura, peso, idade);
				} 
				System.out.printf("\nEntendido! O objeto (%d) (%s) foi criado\n", i+1, gen);
				linha();
			} else{
				// Como os dados estao inconsistentes,
				// alertaremos o usuario e nao adicionaremos
				// nenhuma informacao a posicao atual i do array
				System.out.println("\nERRO! Dados invalidos!");
				linha();
				i--;
			}
			
			// Verificando se o usuario deseja continuar
			if (i != n-1){
				System.out.print("\nQuer continuar [s/n] ? ");
				resp = teclado.next().charAt(0);
				if (resp == 'n'){
					break;
				}
			}
			linha();
			
		}
		
		// Mostrando o vetor completo
		System.out.println("\n--------  OBJETOS CRIADOS  --------\n");
		System.out.printf("Ao total, foram criadas %d pessoas.\n", Pessoa.numPessoas());
		System.out.printf("Dentre as pessoas criadas, temos %d homens e %d mulheres\n", Homem.numHomens(), Mulher.numMulheres());
		linha();
		for (int j = 0; j < Pessoa.numPessoas() - 1; j++){
			System.out.printf("\n---- OBJETO (%d) ----\n\n", j+1);
			System.out.print((array[j]).toString());
			
			linha();
		}
		
	}
}