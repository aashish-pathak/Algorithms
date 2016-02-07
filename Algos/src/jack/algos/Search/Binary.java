package jack.algos.Search;

public class Binary {
	public static void main(String[] args) {
		int[] in = {1,2,3,4,5,6,7,8,9};
		int key = 5;
		int low=0, high=in.length - 1;
		int retVal = search(in, key, low, high);
		if (retVal == -1)
			System.out.println("Element not found!");
		else 
			System.out.println("Element found at position: " + retVal);
	}
	
	//Assuming the array is sorted in ascending order
	public static int search(int[] in, int key, int low, int high) {
		int mid;
		if (low <= high) {
			mid = (low + high )/ 2;
			if (key == in[mid])
				return mid;
			else if (key < in[mid])
				return search(in, key, low, mid-1);
			else if (key > in[mid])
				return search(in, key, mid+1, high);
		}
		return -1;
	}
	
	//For the array sorted in desc order
	public static int searchDesc(int[] in, int key, int low, int high) {
		int mid;
		if (low <= high) {
			mid = (low + high )/ 2;
			if (key == in[mid])
				return mid;
			else if (key < in[mid]) 
				return searchDesc(in, key, mid+1, high);
			else if (key > in[mid])
				return searchDesc(in, key, low, mid-1);
		}
		return -1;
	}
}
//18,16,12,7,1