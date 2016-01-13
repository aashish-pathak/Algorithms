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
import sun.misc.Sort;
import jack.algos.Sort.*;

public class PairEqualsToGivenSum {
	public static void main(String[] args) {
		int[] in = {6,9,10,11, 0,1,2,3,4,5,12};
		int sum = 14;
		// sort the input array in ascending order
		in = QuickSort.sort(in, 0, in.length-1);
		getPairs(in, sum);
	}
	
	public static void getPairs(int[] in, int sum) {
		int i=0, j=in.length-1;
		while (i<j) {
			if (in[i] + in[j] == sum) {
				System.out.println("(" + in[i] + ", " + in[j] + ")");
				i++; j--;
			} else if (in[i] + in[j] < sum)
				i++;
			else
				j++;
		}
	}
}
