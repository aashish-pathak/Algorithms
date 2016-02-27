/* Given an array of distinct elements, rearrange the elements of array 
 * in zig-zag fashion in O(n) time. 
 * The converted array should be in form a < b > c < d > e < f. 
 * Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
 * Output: arr[] = {3, 7, 4, 8, 2, 6, 1}
 * T.C. O(n)
 * */

package aspa.algos.Arrays;

public class ConvertArrayIntoZigZag {
	
	public static void main(String[] args){
		
		int array[] = {4, 3, 7, 8, 6, 2, 1};
		//bubbleSort(array);
		sortZigZag(array);
		
		for (int i=0; i < array.length; i++){
			System.out.println(array[i]);
		}
	}
	
	private static void sortZigZag(int[] array) {
		// TODO Auto-generated method stub
		
		final int N = array.length;
		boolean flag = true;
		
		for (int i=0; i < N-1; i++){
			if(flag){
				if (array[i] > array[i+1]){
					swap(array, i, i+1);
				}
			} else {
				if (array[i] < array[i+1]){
					swap(array, i, i+1);
				}
			}
			flag = !flag;
		}
	}

	public static void bubbleSort(int[] arr){
		// Plain bubble sort implementation
		// O(n^2) complexity.
		final int N = arr.length;
		
		for (int i = 0; i < N-1; i++){
			for (int j = 0; j < N-i-1; j++){
				if (arr[i] > arr[i+1]){
					swap(arr, i, i+1);
				}
			}
		}
		
	}

	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

}
