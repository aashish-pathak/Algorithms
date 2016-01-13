package jack.algos.Sort;

public class QuickSort {
	public static void main(String[] args) {
		int[] in = {3,7,8,5,2,1,9,5,4};
		int low, high, pivot;
		low = 0;
		high = in.length - 1;
		System.out.println("\nBefore sorting: ");
		for (int i=0; i<in.length; i++)
			System.out.print(in[i] + " ");
		in = sort(in, low, high);
		System.out.println("\nAfter sorting: ");
		for (int i=0; i<in.length; i++)
			System.out.print(in[i] + " ");
	}
	
	public static int[] sort(int[] in, int l, int h) {
		int p;
		if (l < h) {
			p = getPivot(in, l, h);
			in = sort(in, l, p-1);
			in = sort(in, p+1, h);
		}
		return in;
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
