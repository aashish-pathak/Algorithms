package jack.algos.Arrays;

public class StringToInt {
	public static void main(String[] args) {
		String str = "1234";
		int num = convertToInt(str);
		System.out.println("Integer is: " + num);
	}
	
	public static int convertToInt(String input) {
		int num=0, n=input.length()-1;
	    int multiplier = 1;
	    while(n>=0) {
	            if((n==0) && (input.charAt(n) == '-')) {
	                num = -num;
	                n--;
	            } else {
	            	char a = input.charAt(n--);
	                num += Character.getNumericValue(a) * multiplier;
 	                multiplier = multiplier * 10;
	            }
	        }
	    return num;
	}
}
