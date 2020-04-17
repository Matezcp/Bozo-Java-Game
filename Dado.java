/**
 * Simula um dado de número de lados variados.
 * Ao criar o objeto é possível estabelecer o número de lados. A rolagem do dado é feita por meio de um gerador de números aleatórios (Random).
 * @author Mateus Zanetti Camargo Penteado
 *
 */
public class Dado {
	private int lados;
	private int lastSort = -1;
	private Random aleatorio;
	
	/**
	 * Transforma representação do dado em String. É mostrada uma representação do dado que está para cima. Note que só funciona corretamente para dados de 6 lados. Exemplo:
	 *+-----+    
	 *|*   *|    
	 *|  *  |    
	 *|*   *|    
	 *+-----+  
	 *No caso o retorno da função será a string "+-----+|*   *||  *  ||*   *|+-----+"
	 */
	@Override
	public String toString() {
		//A função retorna o dado em forma de uma string unidimensional
		//Como o dado tem 5 linhas já atribuimos a primeira linha a String e fazems um for que roda 4 vezes
		String Final = "+-----+";
		for(int i=1;i<5;i++) {
			if(i== 4)
				Final = Final.concat("+-----+"); //O ultimo loop sempre coloca essa String
			else if(i== 1) {
				//Precisa verificar qual o númeo que deseja representar
				if(lastSort == 1) {				
					Final = Final.concat("|     |");
				}
				else if(lastSort == 2 || lastSort == 3) {
					Final = Final.concat("|*    |");
				}
				else
					Final = Final.concat("|*   *|");
			}
			else if(i== 2) {
				//Precisa verificar qual o númeo que deseja representar
				if(lastSort == 1 || lastSort == 3 || lastSort == 5) {
					Final = Final.concat("|  *  |");
				}
				else if(lastSort == 6) {
					Final = Final.concat("|*   *|");
				}
				else
					Final = Final.concat("|     |");
			}
			else {
				//Precisa verificar qual o númeo que deseja representar
				if(lastSort == 4 || lastSort == 5 || lastSort == 6) {
					Final = Final.concat("|*   *|");
				}
				else if(lastSort == 2 || lastSort == 3) {
					Final = Final.concat("|    *|");
				}
				else
					Final = Final.concat("|     |");
			}
		}
		
		return Final;
	}
	/**
	 * Simula a rolagem do dado por meio de um gerador aleatório. O número selecionado pode posteriormente ser recuperado com a chamada a getLado()
	 * @return - o número que foi sorteado
	 */
	public int rolar() {
		lastSort = 1+aleatorio.getIntRand(lados); //Deve-se somar 1 pq o getIntRand(lados) vai retornar um valor entre 0 e 5
		return lastSort;
		
	}
	/**
	 * Recupera o último número selecionado.
	 * @return - o número do último lado selecionado
	 */
	public int getLado() {
		return lastSort;
	}
	/**
	 * Cria um dado com 6 lados (um cubo)
	 */
	public Dado() {
		aleatorio = new Random();
		lados = 6;
	}
	
	/**
	 * Cria objeto com um número qualquer de lados
	 * @param k - número de lados do dado
	 */
	public Dado(int k) {
		aleatorio = new Random();
		lados = k;
	}
}
