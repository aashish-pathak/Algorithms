/*
 * Given N*N matrix (a square matrix),
 *  a00 a01 a02
 *  a10 a11 a12
 *  a20 a21 a22
 *  
 * Traverse the matrix in zigzag fashion. The output should be,
 * 
 *    a00 a01 a10 a20 a11 a02 a12 a21 a22
 *
 */

package aspa.algos.Matrix;

public class ZigzagMatrix {

	public static void main(String[] args) {
		
		int[][] matrix = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		printZigzag(matrix);
	}
	
	private static void printZigzag(int[][] matrix){
		
		// For first half
		int m = 0, n = 0;
		final int N = matrix[0].length;
		System.out.print(matrix[m][n] + " "); // Start with the top left element
		
		do{
			n++; // Go to the right
			System.out.print(matrix[m][n] + " ");
			
			// Reach to the left wall while increasing row
			while(n != 0){
				m++;
				n--;
				System.out.print(matrix[m][n] + " ");
			}
			m++;
			// Termination condition of a loop.
			if(m > N-1){
				m--;
				break;
			}
			System.out.print(matrix[m][n] + " ");
			// Reach to the roof of the matrix decreasing row
			while(m != 0){
				n++;
				m--;
				System.out.print(matrix[m][n] + " ");
			}
		} while(true);
		
		// For second half
		do{
			n++;
			System.out.print(matrix[m][n] + " "); // Print right top element
			
			// Reach to the bottom wall or left down corner decreasing row
			while(n != N-1){
				n++;
				m--;
				System.out.print(matrix[m][n] + " ");
			}
			
			m++;
			// Termination condition of a loop
			if(m > N-1){
				m--;
				break;
			}
			System.out.print(matrix[m][n] + " ");
			
			// Reach to the right wall of the matrix increasing column
			while(m != N-1){
				n--;
				m++;
				System.out.print(matrix[m][n] + " ");
			}
		} while(true);
	}
}
