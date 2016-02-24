package jack.algos.Strings;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string: ");
		String str = in.nextLine();
		if(isPalindromeRecursive(str))
			System.out.println(str + " is a Palindrome");
		else
			System.out.println(str + " is not a Palindrome");
	}
	
	public static boolean isPalindromeRecursive(String str) {
		if(str.length() == 0 || str.length() == 1)
            return true; 
        if(str.charAt(0) == str.charAt(str.length()-1))
            // check for first and last char of String:
            // if they are same then do the same thing for a substring
            // with first and last char removed. and carry on this
            // until you string completes or condition fails
            return isPalindromeRecursive(str.substring(1, str.length()-1));

        // if its not the case than string is not.
        return false;
	}
	
	public static boolean isPalindrome(String str) {
		int i=0, j=str.length()-1;
		if((str.length() == 0) || (str.length() == 1))
			return true;
		while(i<=j) {
			if(str.charAt(i) == str.charAt(j)) {
				i++; j--;
			} else
			return false;
		}
		return true;
	}
}
