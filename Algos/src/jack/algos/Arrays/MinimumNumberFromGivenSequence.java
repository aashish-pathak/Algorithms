/*
 * Given a pattern containing only I’s and D’s. I for increasing and D for decreasing. 
 * Devise an algorithm to print the minimum number following that pattern. 
 * Digits from 1-9 and digits can’t repeat.
 * Input: D        Output: 21
   Input: I        Output: 12
   Input: DD       Output: 321
   Input: II       Output: 123
   Input: DIDI     Output: 21435
   Input: IIDDD    Output: 126543
   Input: DDIDDIID Output: 321654798
 * */

package jack.algos.Arrays;

import java.util.Scanner;

public class MinimumNumberFromGivenSequence {
	public static void main(String[] args) {
		//take the sequence as an input from user
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the sequence: ");
		String str = in.nextLine();
		str = str.toLowerCase();
		//System.out.println("Input is: " + str);
		
		constructMimimunNumber(str);
	}
	public static void constructMimimunNumber(String str) {
		int length = str.length();
		int currentMax = 0;
		int lastNum = 0;
		for(int i=0; i<length; i++) {
			char seq = str.charAt(i);
			int noOfImmediateD = 0;
			switch (seq) {
				case 'd':
				{
					if(i==0) {
						noOfImmediateD = noOfImmediateDs(str, i);
						currentMax = noOfImmediateD + 2;
						System.out.print(currentMax + " ");
						System.out.print(currentMax-1 + " ");
						lastNum = currentMax - 1;
					} else 
						System.out.print(--lastNum + " ");
					break;
				}	
				case 'i':
				{
					noOfImmediateD = noOfImmediateDs(str, i);
					if(i == 0) {
						currentMax = noOfImmediateD + 2;
						System.out.print(++lastNum + " ");
						System.out.print(currentMax + " ");
						lastNum = currentMax;
					} else {
						currentMax = currentMax + noOfImmediateD + 1;
						lastNum = currentMax;
						System.out.print(lastNum + " ");
					}
					
					for(int j=0; j<noOfImmediateD; j++) {
						System.out.print(--lastNum + " ");
						i++;
					}
					break;
				}
				default:
					System.out.println("Please enter valid sequence");
					return;
			
			}
		}
	}
	public static int noOfImmediateDs(String str, int index) {
		int count = 0;
		for(int i=index+1; i<str.length(); i++) {
			if(str.charAt(i) == 'd')
				count++;
			else break;
		}
		return count;
	}
}
