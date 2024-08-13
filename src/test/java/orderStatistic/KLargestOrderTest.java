package orderStatistic;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class KLargestOrderTest {

    private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public KLargestOrderStatisticsImpl<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		this.implementation = new KLargestOrderStatisticsImpl<Integer>();
	}

    public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

    @Test
    public void testOrder1() {
        Comparable[] test = implementation.getKLargest(vetorTamImpar, 3);
        Integer[] result = new Integer[test.length];

        for (int i = 0; i < test.length; i++) {
            result[i] = (Integer) test[i];
        }
        
        assertArrayEquals(new Integer[] {37, 41, 49}, result);
    }

    @Test
    public void testOrder2() {
        Comparable[] test = implementation.getKLargest(vetorTamImpar, 7);
        Integer[] result = new Integer[test.length];

        for (int i = 0; i < test.length; i++) {
            result[i] = (Integer) test[i];
        }
        
        assertArrayEquals(new Integer[] {18, 26, 32, 36, 37, 41, 49}, result);
    }

    @Test
    public void testOrder3() {
        Comparable[] test = implementation.getKLargest(vetorTamImpar, 11);
        Integer[] result = new Integer[test.length];

        for (int i = 0; i < test.length; i++) {
            result[i] = (Integer) test[i];
        }
        
        assertArrayEquals(new Integer[] {4, 6, 7, 11, 18, 26, 32, 36, 37, 41, 49}, result);
    }

    @Test
    public void testOrder4() {
        Comparable[] test = implementation.getKLargest(vetorTamImpar, 1);
        Integer[] result = new Integer[test.length];

        for (int i = 0; i < test.length; i++) {
            result[i] = (Integer) test[i];
        }
        
        assertArrayEquals(new Integer[] {49}, result);
    }

    

    
}
