import java.util.*;

public class QuickSort {
	static int[] in = {3,7,8,5,2,1,9,5,4};
	public static void main(String[] args) {
		int low, high, pivot;
		low = 0;
		high = in.length - 1;
		System.out.println("\nBefore sorting: ");
		for (int i=0; i<in.length; i++)
			System.out.print(in[i] + " ");
		sort(in, low, high);
		System.out.println("\nAfter sorting: ");
		for (int i=0; i<in.length; i++)
			System.out.print(in[i] + " ");
		
	}
	
	public static void sort(int[] in, int l, int h) {
		int p;
		if (l < h) {
			p = getPivot(in, l, h);
			sort(in, l, p-1);
			sort(in, p+1, h);
		}
	}
	
	public static int getPivot(int[] in, int l, int h) {
		int temp;
		while (l < h) {
			if (in[l] > in[l+1]) {
				temp = in[l];
				in[l] = in[l+1];
				in[l+1] = temp;
				l++;
			} else {
				temp = in[h];
				in[h] = in[l+1];
				in[l+1] = temp;
				h--;
			}
		}
		return l;
	}
}
