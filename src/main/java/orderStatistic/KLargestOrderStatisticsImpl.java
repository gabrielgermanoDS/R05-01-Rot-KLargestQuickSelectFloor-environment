package orderStatistic;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Porem, voce pode modificar o array original.
 *   Voce pode criar ainda um array de tamanho k que vai armazenar apenas
 *   os elementos a serem retornados.
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem.
 * - Se a entrada for invalida, deve-se retornar um array vazio (por exemplo,
 *   ao solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 *   Este metodo NUNCA deve retornar null.
 * 
 * @author campelo and adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@Override
	public T[] getKLargest(T[] array, int k) {

		if (k > array.length || array.length == 0) {
			return (T[]) new Comparable[0];
		}

		T[] result = (T[]) new Comparable[k];

		int startingPoint = (array.length - k) + 1;

		int j = 0;
		for (int i = startingPoint; i <= array.length; i++) {

			if (j == k) break;

			result[j] = orderStatistics(array, i);
			j++;

		}

		return result;
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		
		T result = selectMin(array);

		if (k > 1) {
			for (int j = 2; j <= k; j++) {
				result = selectGreater(array, result);
			}
		}

		return result;
	}

	public T selectMin(T[] array) {
		T min = array[0];
		
		for (int j = 1; j < array.length; j++) {
			if (array[j].compareTo(min) < 0) {
				min = array[j];
			}
		}

		return min;
	}

	public T selectGreater(T[] array, T previous) {

		T candidate = null;

		for (int j = 0; j < array.length; j++) {
			if (array[j].compareTo(previous) > 0) {
				if (candidate == null) {

					candidate = array[j];

				} else {
					if (array[j].compareTo(candidate) < 0) {
						candidate = array[j];
					}
				}
			}
		}

		

		return candidate;
	}

	
}
