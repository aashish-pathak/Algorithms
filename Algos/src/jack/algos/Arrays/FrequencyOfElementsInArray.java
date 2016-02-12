package jack.algos.Arrays;

public class FrequencyOfElementsInArray {
	public static void main(String[] args) {
		int[] in = {2, 3, 3, 2, 5};
		frequencyMethod2(in);
	}
	
	public static void frequencyMethod1(int[] in) {
		int elementIndex, i=0;
			while(i<in.length) {
				if(in[i] <= 0) {
					i++;
					continue;
				}
				elementIndex = in[i]-1;
				if(in[elementIndex] > 0) {
					in[i] = in[elementIndex];
					in[elementIndex] = -1;
				} else {
					in[elementIndex]--;
					in[i] = 0;
					i++;
				}
			}
			System.out.println("\nCounts of all elements: \n");
			for  (i=0; i<in.length; i++)
				System.out.println(i+1 + " --> "  + Math.abs(in[i]));
	}

	public static void frequencyMethod2(int[] in) {
		int n = in.length;
		for (int j =0; j < n; j++)
	        in[j] = in[j]-1;
		
		for(int i=0; i<n; i++) {
			int element = in[i];
			in[element%n] = in[element%n] + n;
		}
		for(int i=0; i<n; i++) {
			System.out.println((i+1) + "---> " + in[i]/n);
		}
	}
}
