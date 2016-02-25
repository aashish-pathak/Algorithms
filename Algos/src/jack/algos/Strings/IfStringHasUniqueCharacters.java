/*
 * Program to check if a string has all unique characters.
 * Soln: create boolean array of size 256. (ASCII values)
 * keep on changing to true for every character encountered.
 * 
 * Another approach could be sorting the string and checking on consecutive characters.
 * This approach needs no extra space. and T.C = O(nlogn) (for sorting)
 * */

package jack.algos.Strings;

import java.util.Scanner;

public class IfStringHasUniqueCharacters {
	public static void main(String[] args) {
		System.out.println("Please enter the string: ");
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		
		if(hasUniqueCharacters(str))
			System.out.println(str + " has all unique characters!");
	}
	
	public static boolean hasUniqueCharacters(String str) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) { 
				System.out.println("Repeated character is: " + val + ":" + (char)val);
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
}
