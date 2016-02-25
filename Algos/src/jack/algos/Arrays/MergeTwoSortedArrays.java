/*We are given two sorted array. 
 * We need to merge these two arrays such that 
 * the initial numbers (after complete sorting) are in the first array and the remaining numbers are in the second array. 
 * Extra space allowed in O(1).

Example:

Input: ar1[] = {1, 5, 9, 10, 15, 20};
       ar2[] = {2, 3, 8, 13};
Output: ar1[] = {1, 2, 3, 5, 8, 9}
        ar2[] = {10, 13, 15, 20}  
*/
package jack.algos.Arrays;

import jack.algos.Search.Binary;

public class MergeTwoSortedArrays {
	static int[] arr1 = {1, 5, 9, 10, 15, 20};
	static int[] arr2 = {2, 3, 8, 13};
	public static void main(String[] args) {
		merge();
		
		System.out.println("Array1:");
		for(int i:arr1)
			System.out.print(i + " ");
		System.out.println("\nArray2:");
		for(int i:arr2)
			System.out.print(i + " ");
	}
	
	public static void merge() {
		int l1, l2;
		l1 = arr1.length;
		l2 = arr2.length;
		for(int i=l2-1; i>=0; i--) {
			int elementToShift = arr2[i];
			int indexInArr1 = Binary.indexToInsert(arr1, elementToShift, 0, l1-1);
			if(indexInArr1 < l1) {
				arr2[i] = arr1[l1-1];
				shiftArrayFromGivenIndex(indexInArr1);
				arr1[indexInArr1] = elementToShift;
			}
		}
	}
	//this function shifts the array values by 1 position to the right from given index
	public static void shiftArrayFromGivenIndex(int index) {
		for(int i=arr1.length-1; i> index; i--) 
			arr1[i] = arr1[i-1];
	}
}
