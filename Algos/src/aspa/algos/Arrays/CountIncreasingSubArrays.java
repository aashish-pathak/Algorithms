package aspa.algos.Arrays;

public class CountIncreasingSubArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 2, 2, 4};
		count(array);
	}
	
	public static void count(int[] array){
		
		/*
		 * Easiest way to generate all subarrays of 
		 * given array.
		 * T.C. : O(n^3)
		 *
		for (int i = 0; i<array.length; i++){
			for (int j=i; j<array.length; j++){	
				for (int k=i; k<=j; k++)
					System.out.print(array[k] + " ");
				System.out.println("");
			}
		}
		*/
		
		/*
		 * This calculations could be handy,
		 * Length		Count of subarray
		 * 2		->  1   +2 gives next
		 * 3		->  3	+3 gives next
		 * 4		->	6	+4 gives next and so on
		 * 5		->	10
		 * 6		->	15
		 */
		int subArrayLength = 1;
		int count = 0;
		
		for (int i = 0; i < array.length-1; i++){
			if (array[i] < array[i+1]){
				subArrayLength += 1;
				count += subArrayLength - 1;
			} else {
				subArrayLength = 1;
			}
		}
		
		System.out.println(count);
	}

}
