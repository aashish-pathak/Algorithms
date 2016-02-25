/**
 *  In given array, find all the pairs whose sum is equal to given number.
 *  e.g., A = {6,9,10,11, 0,1,2,3,4,5,12} and num = 14
 *  o/p: (2,12), (3,11), (4,10), (5,9)
 *  Complexity: O(n)
 *  
 *  Idea is to first sort given array in ascending order and then 
 *  traverse it from start and end simultaneously to find the pair
 * */

package jack.algos.Arrays;
import jack.algos.Sort.*;

public class PairEqualsToGivenSum {
	public static void main(String[] args) {
		int[] in = {6,9,10,11, 0,1,2,3,4,5,12};
		int sum = 14;
		// sort the input array in ascending order
		in = QuickSort.sort(in, 0, in.length-1);
		int total = getPairs(in, sum);
		System.out.println("There are total " + total + " pairs in the given array whose sum = " + sum);
		total = getPairsV1(in, sum, 0);
		System.out.println("There are total " + total + " pairs in the given array whose sum is less than " + sum);
	}
	
	/* Sum exact equal to given sum */
	public static int getPairs(int[] in, int sum) {
		int i=0, j=in.length-1, total=0;
		while (i<j) {
			if ((in[i] + in[j]) == sum) {
				total++;
				System.out.println("(" + in[i] + ", " + in[j] + ")");
				i++; j--;
			} else if ((in[i] + in[j]) < sum) 
				i++;
			else 
				j--;
		}
		return total;
	}
	
	/* Sum less than or equal to given sum 
	 * 'start' variable is intentionally introduced to to find the count from 
	 * a subarray in the given array starting from position 'start'.
	 * This particular scenario was required for some other problem.
	 * Ref: TripletsWithSumSmallerThanGivenVal.java
	 * In normal case we can pass start as 0.
	 * */
	public static int getPairsV1(int[] in, int sum, int start) {
		int i=start, j=in.length-1, total=0;
		while (i<j) {
			if ((in[i] + in[j]) < sum) {
				total = total + (j-i);
				i++;
			}	
			else 
				j--;
		}
		return total;
	}
}
