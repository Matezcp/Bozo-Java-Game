/**
 * Esta classe representa o placar de um jogo de Bozó. Permite que combinações de dados sejam alocadas às posições e mantém o escore de um jogador.
 * @author Mateus Zanetti Camargo Penteado
 *
 */
public class Placar {
	private int[] tabuleiro = new int[10]; //Vetor que armazena os pontos que é inicializado com -1
	
	private void bubbleSort(int[] vet) { //Algoritmo de ordenação para facilitar a verificação de alguns casos
		int aux;
		 for(int i = 0; i<5; i++){
		        for(int j = 0; j<4; j++){
		            if(vet[j] > vet[j + 1]){
		                aux = vet[j];
		                vet[j] = vet[j+1];
		                vet[j+1] = aux;
		            }
		        }
		    }
	}
	
	private boolean verificaQuina(int[] vet) { //Verifica se é uma quina
		for(int i=1;i<5;i++)
			if(vet[i] != vet[0]) { //Se a o valor atual for diferente do primeiro valor quer dizer que não são todos iguais
				return false;
			}
		return true;
	}
	
	private boolean verificaQuadra(int[] vet) { //Verifica se é uma quadra
		//Basicamente a função pega 2 valores diferentes do vetor vet e ve quantas vezes eles aparecem
		//Se algum dos 2 for 4 quer dizer que ha uma quadra, ele considera um vetor ordenado, visto que é feito
		//Um bubble sort antes de ser mandado para essa função
		int ref1 = vet[0],ref2=-1,numRef1 = 1,numRef2 = 0;
		for(int i =1;i<5;i++) {
			if(vet[i]!=ref1) { //Achou outro valor diferente de vet[0]
				if(ref2 == -1) { //Se não havia achado antes, esse é o nosso novo valor de referencia
					ref2 = vet[i];
					numRef2++;
				}
				else if(vet[i]!=ref2) {//Se já havia achado e esse valor não é igual o valor achado antes quer dizer que há pelo menos 3 valores diferentes no vetor, logo não é uma quadra
					return false;
				}
				else 
					numRef2++; //Caso contrario aumenta o numero de valores da referencia 2
			}
			else {
				numRef1++; //Caso contrario aumenta o numero de valores da referencia 1
			}
		}
		if(numRef1 == 4 || numRef2 == 4) //Se o numero de valores de umas das referencias for 4 return true, se não return false
			return true;
		else
			return false;
	}
	
	private boolean verificaSequencia(int[] vet) { //Verifica se há uma sequencia no vetor
		//Considera que o vetor está ordenado pois ele passa por um bubble sort antes dessa função ser chamada
			for(int i =1;i<5;i++)
				if(vet[i] != vet[i-1]+1) //Se o valor atual for diferente do valor anterior+1 não é uma sequencia
					return false;
			
		return true;
	}
	
	private boolean verificaFullHand(int[] vet) { //Verifica se há uma FullHand no vetor
		//Basicamente usa uma lógica muita parecida com a da quadra, pega 2 valores diferentes do vetor vet e ve quantas vezes eles aparecem
		//Se 1 deles aparecer 2 vezes e o outro 3 quer dizer que ha uma FullHand, ele considera um vetor ordenado, visto que é feito
		//Um bubble sort antes de ser mandado para essa função
		int ref1 = vet[0],ref2=-1,numRef1 = 1,numRef2 = 0;
		for(int i =1;i<5;i++) {
			if(vet[i]!=ref1) { //Achou outro valor diferente de vet[0]
				if(ref2==-1) { //Se não havia achado antes, esse é o nosso novo valor de referencia
					ref2 = vet[i];
					numRef2++;
				}
				else if(vet[i]!=ref2) { //Se já havia achado e esse valor não é igual o valor achado antes quer dizer que há pelo menos 3 valores diferentes no vetor, logo não é uma FullHouse
					return false;
				}
				else
					numRef2++; //Caso contrario aumenta o numero de valores da referencia 2
			}
			else
				numRef1++; //Caso contrario aumenta o numero de valores da referencia 1
		}
		
		//Se o numero de valores de umas das referencias for 3 e da outra 2 return true, se não return false
		if((numRef1 == 2 && numRef2 == 3)||(numRef1 == 3 && numRef2 == 2))
			return true;
		else
			return false;
			
	}
	/**
	 * A representação na forma de string, mostra o placar completo, indicando quais são as posições livres (com seus respectivos números) e o valor obtido nas posições já ocupadas. Por exemplo:
 	 * (1)    |   (7)    |   (4) 
 	 * --------------------------
 	 * (2)    |   20     |   (5) 
 	 * --------------------------
 	 * (3)    |   30     |   (6) 
 	 * --------------------------
 	 *        |   (10)   |
 	 *        +----------+ 
 	 *
 	 *mostra as posições 8 (sequencia) e 9 (quadra) ocupadas.
 	 *
	 */
	@Override
		public String toString() {
		String Final = "";
		//Variavel ini nos ajuda a colocar os valores corretos no placar
		int ini=0;
		//O placar tem 8 linhas mas como as 2 ultimas são especificas e a cada 1 linha tem uma linha apenas com traços iguais vamos usar um for de 3 repetições
		for(int i=0;i<3;i++) {
			//Vamos separar cada linha em 3 partes, correspondente desde o número da posição até o próximo
			for(int j=0;j<3;j++) {
				switch (j) {
				//Se estivermos na primeira parte
				case 0:
					//Se não estiver preenchido apenas colocar ini+1
					if(tabuleiro[ini]==-1) {
						Final = Final.concat("("+(ini+1)+")    |   ");
					}
					else {
						//Se tiver um número para colocar precisamos verificar se o número tem 1 ou 2 digitos
						//Para a formatação do placar continuar correta
						if(tabuleiro[ini]%10==tabuleiro[ini]) {
							Final = Final.concat(""+tabuleiro[ini]+"      |   ");
						}
						else {
							Final = Final.concat(""+tabuleiro[ini]+"     |   ");
						}
					}
					break;
				case 1:
					//Se não estiver preenchido apenas colocar ini+7
					if(tabuleiro[ini+6]==-1) {
						Final = Final.concat("("+(ini+7)+")    |   ");
					}
					else {
						//Se tiver um número para colocar precisamos verificar se o número tem 1 ou 2 digitos
						//Para a formatação do placar continuar correta
						if(tabuleiro[ini+6]%10==tabuleiro[ini+6]) {
							Final = Final.concat(tabuleiro[ini+6]+"      |   ");
						}
						else {
							Final = Final.concat(tabuleiro[ini+6]+"     |   ");
						}
					}
					break;
					
				case 2:
					//Se não estiver preenchido apenas colocar ini+4
					if(tabuleiro[ini+3]==-1) {
						Final = Final.concat("("+(ini+4)+")\n");
					}
					else {
						//Se tiver um número para colocar precisamos verificar se o número tem 1 ou 2 digitos
						//Para a formatação do placar continuar correta
						if(tabuleiro[ini+3]%10==tabuleiro[ini+3]) {
							Final = Final.concat(tabuleiro[ini+3]+"\n");
						}
						else {
							Final = Final.concat(tabuleiro[ini+3]+"\n");
						}
					}
					break;

				default:
					break;
				}
			}
			ini++; //Aumentar o valor de ini para indicar corretamente as posições
			Final = Final.concat("--------------------------\n"); //Colocar as linhas pontilhadas
		}
		
		//Por fim tratar as ultimas 2 linhas
		//Se não estiver preenchido apenas colocar 10
		if(tabuleiro[9]==-1) {
			Final = Final.concat("       |   (10)   |\n");
		}
		else {
			//Se tiver um número para colocar precisamos verificar se o número tem 1 ou 2 digitos
			//Para a formatação do placar continuar correta
			if(tabuleiro[9]%10==tabuleiro[9]) {
				Final = Final.concat("       |   "+tabuleiro[9]+"      |\n");
			}
			else {
				Final = Final.concat("       |   "+tabuleiro[9]+"     |\n");
			}
		}
		//Por fim colocar a linha final corretamente
		Final = Final.concat("       +----------+\n");
		
		return Final;
	}
	
	/**
	 * Adiciona uma sequencia de dados em uma determinada posição do placar. 
	 * Após a chamada, aquela posição torna-se ocupada e não pode ser usada uma segunda vez.
	 * @param posicao - Posição a ser preenchida. As posições 1 a 6 correspondem às quantidas de uns até seis, ou seja, as laterais do placar. 
	 * As outas posições são: 7 - full hand;
	 * 8 - sequencia; 9 - quadra; e 10 - quina
	 * @param dados- um array de inteiros, de tamanho 5. 
	 * Cada posição corresponde a um valor de um dado. Supões-se que cada dado pode ter valor entre 1 e 6.
	 */
	public void add(int posicao,int[] dados) {
		int numDados = 0;
		if(tabuleiro[posicao-1] != -1) //Se já estiver preenchido retorna
			return;
		
		if(posicao <= 6) { //Se a posição for menor que 6 basta vermos o número de dados com o valor da posição
			for(int i = 0;i<5;i++) {
				if(dados[i]==posicao)
					numDados++;
			}
		}
		else if(posicao != 10) { //Se for maior que 6 e diferente de 10, ordena o vetor para poder verificar as condições mais facilmente
			bubbleSort(dados);
		}
		
		switch (posicao) {
		//O Switch do case 1 ao 6, basta multiplicar o numDados pelo valor do case
		case 1:
			tabuleiro[0] = numDados;
			break;
		case 2:
			tabuleiro[1] = numDados * 2;
			break;
			
		case 3:
			tabuleiro[2] = numDados * 3;
			break;
			
		case 4:
			tabuleiro[3] = numDados * 4;
			break;
		
		case 5:
			tabuleiro[4] = numDados * 5;
			break;
			
		case 6:
			tabuleiro[5] = numDados * 6;
			break;		
		//Dos cases de 7 a 10, cada um chama sua respectiva função que verifica a condição de cada um, se retornar true atribui os pontos equivalentes, se retornar false atribui 0
		case 7:
			if(verificaFullHand(dados)==true)
				tabuleiro[6] = 15;
			else
				tabuleiro[6] = 0;
			break;
			
		case 8:
			if(verificaSequencia(dados)== true)
				tabuleiro[7] = 20;
			else
				tabuleiro[7] = 0;
			break;
			
		case 9:
			if(verificaQuadra(dados)== true)
				tabuleiro[8] = 30;
			else
				tabuleiro[8] = 0;
			break;
			
		case 10:
			if(verificaQuina(dados) == true)
				tabuleiro[9] = 40;
			else
				tabuleiro[9] = 0;
			break;
		

		default:
			break;
		}
	}
		
	/**
	 * Computa a soma dos valores obtidos, considerando apenas as posições que já estão ocupadas.
	 * @return - O valor da soma.
	 */
	public int getScore() {
		int score = 0;
		for(int i=0;i<10;i++) {
			if(tabuleiro[i]!=-1) //Se o tabuleiro estiver preenchido somar ao score
				score+=tabuleiro[i];
		}
		
		return score;
	}

	public Placar() {
		for(int i =0;i<10;i++)
			tabuleiro[i] = -1;
	}
	
	
	
	
}
