package jack.algos.Strings;

import java.util.Scanner;

public class ReverseTheString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String str = in.nextLine();
		String rev = reverseString(str);
		System.out.println("Reversed string is: " + rev);
	}
	
	public static String reverseString(String str) {
		int i=0, j=str.length()-1;
		char[] rev = new char[str.length()];
		if(str == null) 
			return null;
		while(i<=j) {
			rev[i] = str.charAt(j);
			rev[j] = str.charAt(i);
			i++;
			j--;
		}
		String revStr = new String(rev);
		return revStr;
	}
}
