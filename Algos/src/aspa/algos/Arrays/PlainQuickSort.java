/**
 * Implement a plain quick sort algorithm.
 * Choose last element of an array as a pivote.
 * There are ways to improve this algorithm by choosing
 * pivote element properly.
 */

package aspa.algos.Arrays;

public class PlainQuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {23, 12, 45, 1, 5, 25, 89, 32, 12};
		quickSort(array, 0, array.length - 1);
		for (int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}

	private static void quickSort(int[] array, int p, int r) {
		// TODO Auto-generated method stub
		int q;
		if (p < r){
			q = partition(array, p, r);
			quickSort(array, p, q-1);
			quickSort(array, q+1, r);
		}
	}

	private static int partition(int[] array, int p, int r) {
		// TODO Auto-generated method stub
		
		int pivote = array[r];
		int i = p-1;
		
		for (int j = p; j < r; j++){
			
			if (array[j] <= pivote){
				i = i + 1;
				swap(array, i, j);
			}
		}
		swap(array, i+1, r);
		return i+1;
	}

	private static void swap(int[] array, int i, int j) {
		// TODO Auto-generated method stub
		// This is important.
		// In case of same index, this function should not do
		// anything, simply return.
		if (array[i] == array[j])
			return;
		array[i] = array[i] ^ array[j];
		array[j] = array[i] ^ array[j];
		array[i] = array[i] ^ array[j];
	}
}
