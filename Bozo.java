import java.io.IOException;
/**
 * Essa é a classe inicial do programa Bozó. Possui apenas o método main, que cuida da execução do jogo.
 * @author Mateus Zanetti Camargo Penteado
 *
 */
public class Bozo {
	/**
	 * Método inicial do programa. Ele cuida da execução do jogo e possui um laço, no qual cada iteração representa uma rodada do jogo. 
	 * Em cada rodada, o jogador joga os dados até 3 vezes e depois escolhe a posição do placar que deseja preencher. 
	 * No final das rodadas a pontuação total é exibida.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//Instancia o placar, os dados e um vetor de inteiros
		Placar pontos = new Placar();
		RolarDados dados = new RolarDados(5);
		int[] valores = new int[5];
		
		String entrada; //String que receberá entradas do usuário
		int pos;
		
		System.out.println(pontos.toString()); //Exibe o placar inicialmente
	
		for(int i=1;i<11;i++) {
			System.out.println("****** Rodada "+i);
			//O usuário pode lançar até 3 vezes o dados
			for(int j=0;j<3;j++) {
				if(j==0) { //Na primeira vez ele apenas roda todos os dados
					System.out.println("Pressione ENTER para lançar os dados");
					entrada = EntradaTeclado.leString();
					valores = dados.rolar();
				}
				else { //Nas outras 2 vezes ele roda apenas os dados selecionados pelo usuário
					System.out.println("Digite os números dos dados que quiser TROCAR. Separados por espaços.");
					entrada = EntradaTeclado.leString();
					valores = dados.rolar(entrada);
					}
				System.out.println(dados.toString()); //Todas as vezes ele mostra dos dados rolados
			}

			System.out.println(pontos.toString()); // Exibe a pontuação atual
			System.out.printf("Escolha a posição que quer ocupar com essa jogada ===> ");
			pos = EntradaTeclado.leInt(); //Le a posição desejada
			pontos.add(pos, valores); //Adiciona os pontos na posição desejada
			System.out.println(pontos.toString()); // Exibe a pontuação atual
		}
		
		//Ao final exibe a pontuação obtida
		System.out.println("***********************************");
		System.out.println("***");
		System.out.println("*** Seu score final foi de: "+pontos.getScore());
		System.out.println("***");
		System.out.println("***********************************");
		
	}

}
