package ordenar;

public class insertionSort {

	public static int[] InsertionSort(int[] input) {

		int aux;
		for (int i = 1; i < input.length; i++) {
			for (int j = i; j > 0; j--) {
				if (input[j] < input[j - 1]) {
					aux = input[j];
					input[j] = input[j - 1];
					input[j - 1] = aux;
				}
			}
		}
		return input;
	}
}
