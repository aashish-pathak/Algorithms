/*
 * This class is to find subarray of size 'k' within a given input array of size 'n'.
 * Brute force will give O(n^2) with nested for loops.
 * Here trying to do it in O(n)
 * 
 * */
import java.util.*;

public class SubarrayWithLeastAvrg {
	static int[] in = {3, 7, 5, 20, -10, 0, 12};
	static int k = 2;
	
	public static void main(String[] args) {
		getSubArray();
	}
	
	public static void getSubArray() {
		int n = in.length;
		int minSum = 0;
		int index = k-1;
		/* getting sum of subarray of length k for the first time */
		for (int i=0; i<k; i++) {
			minSum += in[i];
		}
		
		/* iterating over the input array to find least sum and index*/
		for (int i=k; i<n; i++) {
			int tempSum = minSum - in[i-k] + in[k];
			if (minSum > tempSum) {
				minSum = tempSum;
				index = i;
			}
		}
		
		System.out.println("Subarray is between index: " + (index-k+1) + " and " + index );
	}
}
