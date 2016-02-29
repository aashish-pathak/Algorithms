/**
 *  Given a pattern containing only I’s and D’s. 
 *  I for increasing and D for decreasing. 
 *  Devise an algorithm to print the minimum number following that pattern. 
 *  Digits from 1-9 and digits can’t repeat.
 *
 *  Examples:
 *
 *  Input: D        Output: 21
 *  Input: I        Output: 12
 *  Input: DD       Output: 321
 *  Input: II       Output: 123
 *  Input: DIDI     Output: 21435
 *  Input: IIDDD    Output: 126543
 *  Input: DDIDDIID Output: 321654798 
 *
 */

/**
 * Algorithm :
 * 1. Base case or Initial case
 * 		a. When 1st character from input array is 'I'
 * 			- Add 1, 2 to the output array.
 * 			- Store latest position of 'I' i.e. 1 over here.
 * 			- Store next minimum value to be 3
 * 		b. When 1st character from input array is 'D'
 * 			- Add 2, 1 to the output array.
 * 			- latest position of 'I' is 0 (zero)
 * 			- Store next minimum value to be 3
 * 2. Traverse the remaining character string one-by-one (1 to inputString.length)
 * 		a. If character is 'I'
 * 			- append available minimum value to the output array
 * 			- Increment minimum available value
 * 			- Update the latest index of 'I' to be current
 * 		b. If character is 'D'
 * 			Now, this one is little tricky.
 * 			- Append output array with outputArray[currentIndex]
 * 			- Increment all the values in outputArray between latest position of 'I' to current
 * 			- Increment next minimum available value
 */
package aspa.algos.Arrays;

public class FormMinimumNumber {

	private static int[] outputArray = new int[9];
	private static int outputArrayIndex = 0;
	
	public static void main(String[] args) {
		
		printMinimumNumber("D");
		System.out.println("");
		printMinimumNumber("I");
		System.out.println("");
		printMinimumNumber("DD");
		System.out.println("");
		printMinimumNumber("II");
		System.out.println("");
		printMinimumNumber("DIDI");
		System.out.println("");
		printMinimumNumber("IIDDD");
		System.out.println("");
		printMinimumNumber("DDIDDIID");
	}

	public static void intializeOutputArray(){
		for (int i = 0; i < outputArray.length; i++)
			outputArray[i] = 0;
		outputArrayIndex = 0;
	}
	
	public static void printMinimumNumber(String sequence){
		// Initialize necessary variables
		int positionOfI = 0;
		int minValueAvailable = 1;
		intializeOutputArray();
		
		// Base case
		if (sequence.charAt(0) == 'I'){
			pushToOutputArray(1);
			pushToOutputArray(2);
			minValueAvailable = 3;
			positionOfI = 1;
		} else if (sequence.charAt(0) == 'D'){
			pushToOutputArray(2);
			pushToOutputArray(1);
			minValueAvailable = 3;
		}
		
		// Traverse the remaining string.
		for (int i = 1; i < sequence.length(); i++){
			
			if (sequence.charAt(i) == 'I'){
				
				pushToOutputArray(minValueAvailable);
				minValueAvailable++;
				positionOfI = i + 1;
				
			} else if (sequence.charAt(i) == 'D') {
				// Little tricky
				pushToOutputArray(outputArray[i]);
				for (int j = positionOfI; j<=i; j++)
					outputArray[j]++;
				minValueAvailable++;
			}
		}
			
		// Print the number
		for (int i = 0; i < outputArray.length; i++){
			if (outputArray[i] == 0)
				break;
			System.out.print(outputArray[i]);
		}
			
	}
	
	public static void pushToOutputArray(int x){
		outputArray[outputArrayIndex++] = x;
	}
}
