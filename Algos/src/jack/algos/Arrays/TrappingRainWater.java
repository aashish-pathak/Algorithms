/* Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1, compute how much water it is able to trap after raining.
 * Input: arr[]   = {2, 0, 2}
 * Output: 2
	Structure is like below
	| |
	|_|
	We can trap 2 units of water in the middle gap.

	Input: arr[]   = {3, 0, 0, 2, 0, 4}
	Output: 10
	Structure is like below
	      |
	|     |
	|   | |
	|_ _|_|
	*** IMP NOTE: BAR WIDTH IS 1 UNIT *** 
 * */

package jack.algos.Arrays;

public class TrappingRainWater {
	public static void main(String[] args) {
		int[] in = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int[] leftMax =  new int[in.length];
		int[] rightMax =  new int[in.length];
		
		/* Compute leftMax and rightMax arrays for each element in input array
		 * leftMax[i] = highest bar on the left of the element
		 * rightMax[i] = highest bar on the right of the element
		 * */
		int tempMax=0;
		int i;
		for(i=0; i<in.length; i++) {
			if(i==0)
				leftMax[i] = 0;
			else {
				leftMax[i] = tempMax;
			}
			tempMax = (tempMax<in[i]) ? in[i] : tempMax; 
		}
		
		tempMax = 0;
		for(i=in.length-1; i>=0; i--) {
			if(i==in.length-1)
				rightMax[i] = 0;
			else {
				rightMax[i] = tempMax;
			}
			tempMax = (tempMax<in[i]) ? in[i] : tempMax; 
		}
		
		int totalCapacity = computeWaterCapacity(in, leftMax, rightMax);
		System.out.println("Total water that can be trapped is: " + totalCapacity);
	}
	
	/* water capacity for each bar is calculated as (min(leftMax, rightMax) - heightOfBar)*/
	public static int computeWaterCapacity(int[] in, int[] left, int[] right) {
		int totalWater = 0;
		for(int i=0; i<in.length; i++) {
			int currBarCapacity = Math.min(left[i], right[i]) - in[i];
			totalWater += (currBarCapacity > 0) ? currBarCapacity : 0;
		}
		return totalWater;
	}
}
