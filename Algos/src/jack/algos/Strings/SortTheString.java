package jack.algos.Strings;

import java.util.Arrays;
import java.util.Scanner;

public class SortTheString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string to be sorted: ");
		String str = in.nextLine();
		
		char[] char_representation = str.toCharArray();
		Arrays.sort(char_representation);
		String sortedStr = new String(char_representation);
		System.out.println("Sorted string is: " + sortedStr);
	}
}
