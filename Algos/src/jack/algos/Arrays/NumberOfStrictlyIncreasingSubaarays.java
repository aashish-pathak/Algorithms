/*Given an array of integers, count number of subarrays (of size more than one) that are strictly increasing.
Expected Time Complexity : O(n)
Expected Extra Space: O(1)

Examples:
	Input: arr[] = {1, 4, 3}
	Output: 1
	There is only one subarray {1, 4}

	Input: arr[] = {1, 2, 3, 4}
	Output: 6
	There are 6 subarrays {1, 2}, {1, 2, 3}, {1, 2, 3, 4},{2, 3}, {2, 3, 4} and {3, 4}

	Input: arr[] = {1, 2, 2, 4}
	Output: 2
	There are 2 subarrays {1, 2} and {2, 4}
*/

package jack.algos.Arrays;

public class NumberOfStrictlyIncreasingSubaarays {
	public static void main(String[] args) {
		int[] in = {1, 2, 2, 4};
		int count = numberOfIncreasingSubarrays(in);
		System.out.println("There are total " + count + " strictly increasing subararys.");
	}
	
	public static int numberOfIncreasingSubarrays(int[] in) {
		int count = 0;
		int len = 1;
		for(int i=0; i<in.length-1; i++) {
			if(in[i] < in[i+1]) {
				len++;
			} else {
				count += (len * (len-1))/2;
				len = 1;
			}
		}
		if(len > 1)
			count += (len * (len-1))/2;
		return count;
	}
}
