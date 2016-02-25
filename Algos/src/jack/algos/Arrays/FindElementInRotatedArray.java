package jack.algos.Arrays;

import jack.algos.Search.Binary;

public class FindElementInRotatedArray {
	public static void main(String[] args) {
		int in[] = { 2,6,8,9,15,20,18,16,12,7,1};
		int num = 12;
		//get the highest element in the array in log n
		//This will be the point where array can be divided into 2 subarrays
		//O(logn) can be then used to find num in these 2 subarrays
		//O(log n + log n) = O(log n)
		
		int maxIndex = getMaxIndex(in);
		//System.out.println("Maxindex: " + maxIndex);
		int numIndex = Binary.search(in, num, 0, maxIndex);
		if (numIndex == -1) 
			numIndex = Binary.searchDesc(in, num, maxIndex+1, in.length-1);
		
		System.out.println("Number " + num + " found at index: " + numIndex);
	}
	
	public static int getMaxIndex(int[] in) {
		int l = in.length;
		int low = 0, high = l-1;
		int mid = (low+high)/2;
		while(low<high) {
			if(in[mid] > in[mid-1]) {
				low = mid;
			} else {
				high = mid;
			}
			mid = (low+high)/2;
			if ((mid == low) || (mid == high))
				break;
		}
		return mid;
	}
}
