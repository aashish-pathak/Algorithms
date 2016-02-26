/* Given an array of distinct elements, rearrange the elements of array 
 * in zig-zag fashion in O(n) time. 
 * The converted array should be in form a < b > c < d > e < f. 
 * Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
 * Output: arr[] = {3, 7, 4, 8, 2, 6, 1}
 * T.C. O(n)
 * */

package jack.algos.Arrays;

public class ConvertArrayIntoZigZag {
	public static void main(String[] args) {
		int in[] = {4, 3, 7, 8, 6, 2, 1};
		//flag=true: in[i] < in[i+1]
		//flag=false: in[i] > in[i+1]
		boolean flag = true;

		zigzag(in, flag);

		for(int i=0; i<in.length; i++)
			System.out.print(in[i] + " ");
	}

	public static void zigzag(int[] in, boolean flag) {
		for(int i=0; i<in.length-1; i++) {
			if(flag) {
				if(in[i] > in[i+1]) {
					swap(in, i, i+1);
				}
			} else {
				if(in[i] < in[i+1]) {
					swap(in, i, i+1);
				}
			}
			flag = !flag;
		}
	}

	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}

}
