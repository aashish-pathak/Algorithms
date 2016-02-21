package Misc;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Print the fibonacci series for the length: ");
		int n = in.nextInt();
		
		System.out.println("Non-recursive Fibonacci:  ");
		fibonacci(n);
		
		System.out.println("\nRecursive Fibonacci:  ");
		for (int i = 0; i < n; i++)
            System.out.print(fibonacciRec(i) + " ");
	}
	
	public static void fibonacci(int n) {
		long first = 0;
		long second = 1;
		System.out.print(first + " " + second + " ");
		for(int i=0; i<n-2; i++) {
			long nextElem = first + second;
			System.out.print(nextElem + " ");
			first = second;
			second = nextElem;
		}
	}
	
	public static long fibonacciRec (int n) {
		if (n < 2) return n;
		return fibonacciRec(n - 1) + fibonacciRec(n - 2);
    }
}
