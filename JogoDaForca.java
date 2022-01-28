import java.util.Scanner;
import java.util.Random;

public class JogoDaForca {
	
	Scanner ler = new Scanner(System.in);
	static String [][] tp = new String [51][51];
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//temas e palavras padrões
		tp[0][0] = "carros";
		tp[0][1] = "Corola";
		tp[0][2] = "Celta";
		tp[0][3] = "Polo";
		tp[0][4] = "Gol";
		tp[0][5] = "Palio";
		tp[1][0] = "animais";
		tp[1][1] = "cachorro";
		tp[1][2] = "galinha";
		tp[1][3] = "cavalo";
		tp[1][4] = "macaco";
		tp[1][5] = "tartaruga";
		tp[2][0] = "elementos";
		tp[2][1] = "carbono";
		tp[2][2] = "hidrogenio";
		tp[2][3] = "ferro";
		tp[2][4] = "cobre";
		tp[2][5] = "zinco";
		tp[3][0] = "cidades";
		tp[3][1] = "Brasilia";
		tp[3][2] = "Santos";
		tp[3][3] = "Roma";
		tp[3][4] = "Moscou";
		tp[3][5] = "Toquio";
		tp[4][0] = "paises";
		tp[4][1] = "Alemanha";
		tp[4][2] = "Espanha";
		tp[4][3] = "Italia";
		tp[4][4] = "Brasil";
		tp[4][5] = "Mexico";
		tp[5][0] = "frutas";
		tp[5][1] = "manga";
		tp[5][2] = "banana";
		tp[5][3] = "melancia";
		tp[5][4] = "uva";
		tp[5][5] = "pessego";
		
		boolean cont = true;
		
		while(cont==true) {
			System.out.print("Selecione uma das 4 opções: \n"
					+ "1. Gerenciar Temas \n"
					+ "2. Gerenciar Palavras \n"
					+ "3. Jogar \n"
					+ "4. Sair \n");
			int selecao = input.nextInt();
			
			switch (selecao){
				case 1:
					JogoDaForca Temas = new JogoDaForca();
					Temas.Gerenciar_Temas();
					break;
					
				case 2:
					JogoDaForca pala = new JogoDaForca();
					pala.Gerenciar_Palavras();
					break;
					
				case 3:
					boolean game = true;
					do {
						JogoDaForca jogar = new JogoDaForca();
						jogar.jogo();
						System.out.print("insira 1 para jogar novamente");
						int op = input.nextInt();
						if(op != 1) {
							game = false;
						}
					
					} while(game == true);
				
					break;
					
				case 4:
					cont = false;
					break;
			
			}
		}
		

	}
	

	public void Gerenciar_Temas() {
		
		int sair = 0;
		
		while (sair==0) {
			System.out.print("Selecione 1 - para adicionar temas, 2 para excluir ou 3 para sair \n");
			int opicao = ler.nextInt();
			
			switch (opicao) {
			case 1:
				System.out.print("Insira novo tema: \n");
				String tema = ler.next();
				
				for(int i = 0; i<51; i++) {
					if(tp[i][0]!=null) {
						if (tp[i][0].equalsIgnoreCase(tema)) {
							System.out.print("tema repitido \n");
							i=51;
						}
					}
					else if(tp[i][0]== null) {
						tp[i][0] = tema;
					}
					
				}
				System.out.print(tp[6][0]);
				break;
			
			case 2:
				System.out.print("Insira o tema que deve ser retirado: \n");
				String compara = ler.next();
				
				for(int i = 0; i<51; i++) {
					if (tp[i][0]!=null) {
						if (tp[i][0].equalsIgnoreCase(compara)) {
							for(int j=0; j<51; j++) {
								if (tp[i][j]!=null) {
									tp[i][j] = null;
								}
							}
						}	
					System.out.print(tp[0][1] + "\n");
				}
				}
				break;
				
			case 3:
				sair = 1;
				break;
				
			default:
				System.out.print("Opção invalida: \n");
			
			}
			
		}
		
	}
	
	public void Gerenciar_Palavras() {
		
		int sair = 0;
		
		while (sair==0) {
			
			System.out.print("Insira o tema em que a palavra está localizado: \n");
			String tem = ler.next();
			int temNum = 0;
			boolean confere = false;
			
			for(int i = 0; i<51; i++) {
				if (tp[i][0].equalsIgnoreCase(tem)) {
					confere = true;
					temNum = i;
				}
			}
			
			if (confere == true) {
				System.out.print("Selecione 1 - para adicionar palavra, 2 para retirar palavra ou 3 para sair \n");
				int opicao = ler.nextInt();
				
				switch (opicao) {
				case 1:
					System.out.print("Insira nova palavra: \n");
					String tema = ler.next();
					
					for(int j = 0; j<51; j++) {
						if(tp[temNum][j]!=null) {
							if (tp[temNum][j].equalsIgnoreCase(tema)) {
								System.out.print("palavra repitida");
								j=51;
							}
						}
						else if(tp[temNum][j]== null) {
							tp[temNum][j] = tema;
							j=51;
						}
					}
					break;
				
				case 2:
					System.out.print("Insira a palavra que deve ser retirada: \n");
					String compara = ler.next();
					for(int j = 0; j<51; j++) {
						if (tp[temNum][j] == compara) {
							tp[temNum][j] = null;
							System.out.print("palavra retirada");
							j=51;
						}
					}
					break;
					
				case 3:
					sair = 1;
					break;
					
				default:
					System.out.print("Opção invalida: \n");
				
				}
				
			}else {
				System.out.print("Tema não encontrado");
			}
			
		}
		
	}
	
	
	public void jogo(){

			System.out.print("Selecione o tema: \n");
			String tema = ler.next();
			boolean verifica = false;
			int t = 0;
			
			for(int i = 0; i<51; i++) {
				if (tp[i][0]!=null) {
					if (tp[i][0].equalsIgnoreCase(tema)) {
						verifica = true;
						t = i;
						System.out.print("tema selecionado é " + tp[i][0] + "\n");
						System.out.print("tema selecionado é " + tp[i][1] + "\n");
						i = 51;
					}
				}
			}
			
			if(verifica == true) {
				int range = 0;
				for(int i=1; i<51; i++) {
					if(tp[t][i]==null) {
						range = i-1;
						i=51;
					}
				}
				Random aleatorio = new Random();
				int sorteio = aleatorio.nextInt(range)+1;
				int ve = 0;
				String palavra = tp[t][sorteio];
				String str = null;
				int tamanho = palavra.length();
				String arr [] = new String[tamanho];
				int pontuacao = palavra.length(); //usado para comparar o numero de acertos com o tamanho da palavra
				
				while(ve<5 && pontuacao!=0) {
					System.out.print("Insira uma letra: \n");
					System.out.print(palavra);
					String letra = ler.next();
					int num = 0;
					
					for(int i = 0; i<tamanho; i++){
						if (palavra.charAt(i) == letra.toLowerCase().charAt(0) || palavra.charAt(i) == letra.toUpperCase().charAt(0)) {
							if (arr[i]!=null) {
								if (arr[i].equals(letra.toLowerCase()) || arr[i].equals(letra.toUpperCase())) {
									System.out.print("Tente outra letra! \n");
								}
							}else {
								arr[i] = letra;
								pontuacao -=1;
							}
						}else {
							num +=1;
							if (num == tamanho) {		//caso o usuario erre a letra, é contabilizado o erro
								ve += 1;
								System.out.print("Tente outra letra! \n");
							}
						}
						}
					
					
					for(int i = 0; i<tamanho; i++) {
						if (arr[i] != null) {
							System.out.print(arr[i]);
						}else {
							System.out.print("_");
						}
					}
					
					System.out.print("\n");
					
					if(pontuacao==0) {
						System.out.print("Parabens! Você adivinhou a palavra! \n");
					}else if(ve==5) {
						System.out.print("Você perdeu! \n");
					}
	
				}

			}

		}
}
	
