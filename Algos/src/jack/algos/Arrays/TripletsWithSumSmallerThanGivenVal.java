/**
 * Given an array of distinct integers and a sum value. 
 * Find count of triplets with sum smaller than given sum value. 
 * Expected Time Complexity is O(n2).
 * 
 * E.g., Input : arr[] = {-2, 0, 1, 3}
         sum = 2.
		 Output : 2
 * */

package jack.algos.Arrays;
import jack.algos.Sort.*;
import jack.algos.Arrays.*;

public class TripletsWithSumSmallerThanGivenVal {
	public static void main(String[] args) {
		int in[] = {-2, 0, 1, 3};
		int sum = 1;
		
		// first sort the given array
		in = QuickSort.sort(in, 0, in.length-1);
		getTripletCount(in, sum);
	} 
	
	public static void getTripletCount(int[] in, int sum) {
		int count = 0;
		for (int i=0; i<in.length-2; i++) {
			count += PairEqualsToGivenSum.getPairsV1(in, (sum-in[i]), i+1);
		}
		System.out.println("Total " + count + " triplets with sum less than " + sum);
	}
}
