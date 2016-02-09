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
	}
	
	public static void zigzag(int[] in, boolean flag) {
		int temp;
		for(int i=0; i<in.length-1; i++) {
			if(flag) {
				if(in[i] > in[i+1]) {
					temp = in[i];
					in[i] = in[i+1];
					in[i+1] = temp;
				}
			} else {
				if(in[i] < in[i+1]) {
					temp = in[i];
					in[i] = in[i+1];
					in[i+1] = temp;
				}
			}
			flag = !flag;
		}
		for(int i=0; i<in.length; i++)
			System.out.print(in[i] + " ");
	}
}
