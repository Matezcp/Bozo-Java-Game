/**
 * Essa é uma classe auxiliar que permite gerencia um conjunto de vários dados simultaneamente.
 * Operações como rolar alguns dos dados ou exibir o resultado de todos eles, são implementadas.
 * @author Mateus Zanetti Camargo Penteado
 *
 */
public class RolarDados {
	private Dado[] dados;
	private int numDados;
	
	/**
	 * Usa a representação em string do dados, para mostrar o valor de todos os dados do conjunto. Exibe os dados horisontalmente, por exemplo:
	 * 
	 *  1          2          3          4          5
	 *  +-----+    +-----+    +-----+    +-----+    +-----+  
	 *  |*   *|    |     |    |*    |    |*    |    |*   *|   
	 *  |  *  |    |  *  |    |     |    |  *  |    |     | 
	 *  |*   *|    |     |    |    *|    |    *|    |*   *|   
	 *  +-----+    +-----+    +-----+    +-----+    +-----+  
	 */
	@Override
	public String toString() {
		//Essa função pega todas as strings dos dados e monta elas um ao lado da outra e armazena em uma string bidimensional
		String Final = "";
		String[] dice = new String[numDados];
		int aux = 0;
		
		for(int i = 0;i<numDados;i++)
			dice[i] = dados[i].toString(); //Pega a String de cada dado
		
		Final = Final.concat("1          2          3          4          5\n"); //A primeira linha é sempre igual
		//Tem mais 5 linhas para montar, logo um for de 5 repetições
		for(int i=0;i<5;i++) {
			//Precisa montar a primeira linha de cada dado uma ao lado da outra logo um for de numero de dados repetições
			for(int j=0;j<numDados;j++) {
				//Vai imprimindo char a char de cada dado, como cada dado tem 7 colunas o for para em aux +7
				for(int k = aux;k<aux+7;k++) {
					Final = Final.concat(""+dice[j].charAt(k));
				}
				//Imprimi um espaço entre os dados
				Final = Final.concat("    ");
			}
		Final = Final.concat("\n"); //Pula para começar a imprimir a proxima linha
		aux+=7;	//Incrementa o aux em 7 pois cada linha do dado tem 7 colunas e deve-se ir para proxima linha do dado
		}
	
		return Final;
	}
	
	
	/**
	 * Rola todos os dados.
	 * @return - Retorna o valor de cada um dos dados, inclusive os que não foram rolados. Nesse caso, o valor retornado é o valor anterior que ele já possuia.
	 */
	public int[] rolar() {
		int[] valores = new int[numDados];
		for(int i=0;i<numDados;i++) {
			valores[i] = dados[i].rolar(); //Rola todos os dados armazendo os valores obtidos na variavel valores e retornando-a
		}
		
		return valores;
	}
	
	/**
	 * Rola alguns dos dados.
	 * @param quais - É um array de booleanos que indica quais dados devem ser rolados. Cada posição representa um dos dados. Ou seja, a posição 0 do array indica se o dado 1
	 * deve ser rolado ou não, e assim por diante.
	 * @return - Retorna o valor de cada um dos dados, inclusive os que não foram rolados. Nesse caso, o valor retornado é o valor anterior que ele já possuia.
	 */
	public int[] rolar(boolean[] quais) {
		int[] valores = new int[numDados];
		//Verifica quais posições está com true e roda apenas os dados que está com true
		for(int i=0;i<numDados;i++) {
			if(quais[i]==true)
				valores[i] = dados[i].rolar();
			else
				valores[i] = dados[i].getLado();
		}
		
		return valores;
	}
	
	
	/**
	 * Rola alguns dos dados.
	 * @param quais - É um String que possui o número dos dados a serem rolados. Por exemplo "1 4 5" indica que os dados 1 4 e cinco devem ser rolados. Os números devem ser
	 * separados por espaços. Se o valor passado no string estiver fora do intervalo válido, ele é ignorado simplesmente.
	 * @return - Retorna o valor de cada um dos dados, inclusive os que não foram rolados. Nesse caso, o valor retornado é o valor anterior que ele já possuia.
	 */
	public int[] rolar(String quais) {
		boolean[] selecionados = new boolean[6];
		
		//Verifica se há cada número de 1 a 5 na String de entrada e se armazena essa informação como true e false no vetor de boolean selecionados
		//E chama novamente a função rolar mas com um vetor de boolean
		if(quais.contains("1")) {
			selecionados[0]=true;
		}
		else {
			selecionados[0] = false;
		}
		if(quais.contains("2")) {
			selecionados[1]=true;
		}
		else {
			selecionados[1] = false;
		}
		if(quais.contains("3")) {
			selecionados[2]=true;
		}
		else {
			selecionados[2] = false;
		}
		if(quais.contains("4")) {
			selecionados[3]=true;
		}
		else {
			selecionados[3] = false;
		}
		if(quais.contains("5")) {
			selecionados[4]=true;
		}
		else {
			selecionados[4] = false;
		}
		if(quais.contains("6")) {
			selecionados[5]=true;
		}
		else {
			selecionados[5] = false;
		}
			
		
		return rolar(selecionados);
		
	}
	
	
	/**
	 * Construtor que cria e armazena vários objetos do tipo Dado.
	 * Usa para isso o construtor padrão daquela classe, ou seja, um dado de 6 lados e gerando sempre uma semente aleatória para o gerador de números aleatórios.
	 * Os dados criados podem ser referenciados por números, entre 1 e n.
	 * @param n - Número de dados a serem criados.
	 */
	public RolarDados(int n) {
		numDados = n;
		dados = new Dado[n];
		//Cria n dados
		for(int i=0;i<n;i++) {
			dados[i] = new Dado();
			try {
				//é preciso fazer esse sleep para os dados não terem a mesma semente
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
