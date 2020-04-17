import java.util.Calendar;
/**
 * gerador simples de números aleatórios.
 * @author Mateus Zanetti Camargo Penteado
 *
 */
public class Random{
	private static long p = 2147483648L;
	private static long m = 843314861;
	private static long a = 453816693;
	private long xi;
	/**
	 * Permite alterar a semente de geração de números aleatórios. 
	 * Supostamente deve ser chamada antes de iniciar a geração, mas se for chamado a qualquer instante, reseta o valor da semente
	 * @param semente - o valor da nova semente de geração
	 */
	public void setSemente(long semente) {
		xi = semente%p;
	}
	/**
	 * Retorna um número aleatório no intervalo (0,1[
	 * @return o número gerado.
	 */
	public double getRand() {
		xi = (a+m*xi)%p;
		return (double) xi/ p;	
	}
	/**
	 * Retorna um valor inteiro no intervalo (0,max[
	 * @param max - O valor limite para a geração do número inteiro
	 * @return o número gerado
	 */
	public int getIntRand(int max) {
		return (int) (max * getRand());
	}
	/**
	 * Construtor que permite criar o gerador, especificando o valor inicial da semente.
	 * @param k - O valor inicial da semente
	 */
	public Random(int k) {
		setSemente(k);
	}
	/**
	 * Construtor que usa uma semente aleatória, adquerida usando o método Calendar.getTimeInMillis().
	 */
	public Random() {
		setSemente(Calendar.getInstance().getTimeInMillis());
	}
	
}	
	
