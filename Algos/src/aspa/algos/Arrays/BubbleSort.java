package aspa.algos.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = { 71,12,33,64,15,7,87,8,9,10 };
		//sort(array);
		zigzag(array);
	}
	
	public static void sort(int[] arr){
		// This will print the array in ascending order.
		// Bubble sort implementation.
		final int N = arr.length;
		for(int j = 0; j < N-1; j++){
			for (int i = 0; i < N-j-1; i++){
				if (arr[i] > arr[i+1]){
					swap(arr, i, i+1);
				}
			}
		}
		for (int i = 0; i < N; i++){
			System.out.println(arr[i]);
			
		}
	}
	
	public static void zigzag(int[] arr){
		boolean flag = true;
		final int N = arr.length;
		
		for (int i = 0; i < N-1; i++){
			
			if (flag){
				if (arr[i] > arr[i+1]){
					swap(arr, i, i+1);
				}
			} else {
				if (arr[i] < arr[i+1]){
					swap(arr, i, i+1);
				}
			}
			flag = !flag;
		}
		
		for (int i = 0; i < N; i++){
			System.out.println(arr[i]);
		}
	}
	
	public static void swap(int[] arr, int x, int y){
		// You need to send array object as there is no pass-by-reference
		// for primitive data types in Java.
		arr[x] = arr[x] ^ arr[y];
		arr[y] = arr[x] ^ arr[y];
		arr[x] = arr[x] ^ arr[y];
	}

}
