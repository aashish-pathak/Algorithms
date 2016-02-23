/*Given a matrix of size M x N, there are large number of queries to find submatrix sums. 
 * Inputs to queries are left top and right bottom indexes of submatrix whose sum is to find out.
 * How to preprocess the matrix so that submatrix sum queries can be performed in O(1) time.
 * Example:

	tli :  Row number of top left of query submatrix
	tlj :  Column number of top left of query submatrix
	rbi :  Row number of bottom right of query submatrix
	rbj :  Column number of bottom right of query submatrix
	
	Input: mat[M][N] = {{1, 2, 3, 4, 6},
	                    {5, 3, 8, 1, 2},
	                    {4, 6, 7, 5, 5},
	                    {2, 4, 8, 9, 4} };
	Query1: tli = 0, tlj = 0, rbi = 1, rbj = 1
	Query2: tli = 2, tlj = 2, rbi = 3, rbj = 4
	Query3: tli = 1, tlj = 2, rbi = 3, rbj = 3;
	
	Output:
	Query1: 11  // Sum between (0, 0) and (1, 1)
	Query2: 38  // Sum between (2, 2) and (3, 4)
	Query3: 38  // Sum between (1, 2) and (3, 3)

Soln: Idea is to preprocess the given matrix to store sum of submatrix till that point
Thus, preprocessed matrix = {{1 3 6 10 16}, 
							 {6 11 22 27 35 }, 
							 {10 21 39 49 62 },
							 {12 27 53 72 89 }
	Then, Query : tli = 2, tlj = 2, rbi = 3, rbj = 4
	Sum between (2, 2) and (3, 4) = 89 - 35 - 27 + 11 = 38
*/
package jack.algos.Matrix;

public class SumOfSubMatrix {
	public static void main(String[] args) {
		int[][] in = {{1, 2, 3, 4, 6},
		                {5, 3, 8, 1, 2},
		                {4, 6, 7, 5, 5},
		                {2, 4, 8, 9, 4} };
		int noOfRows = in.length;
		int noOfColumns = in[1].length;
		int[][] auxMatrix = preProcessMatrix(in, noOfRows, noOfColumns);
		int sum = sumOfSubmatrix(auxMatrix, 1, 2, 3, 3);
		System.out.println("Sum is: " + sum);
	}
	
	public static int sumOfSubmatrix(int[][] auxMatrix, int lTopI, int lTopJ, int rBottI, int rBottJ) {
		int sum = auxMatrix[rBottI][rBottJ];
		if(lTopI > 0)
			sum -= auxMatrix[lTopI-1][rBottJ];
		if(lTopJ > 0)
			sum -= auxMatrix[rBottI][lTopJ-1];
		if((lTopI > 0) && (lTopJ > 0))
			sum += auxMatrix[lTopI-1][lTopJ-1];
			
		return sum;
	}
	public static int[][] preProcessMatrix(int[][] in, int r, int c) {
		int[][] auxMatrix = new int[r][c];
		//copy first row as it is in auxMatrix
		for(int i=0; i<c; i++) 
			auxMatrix[0][i] = in[0][i];
		//save column sums in auxMatrix
		for(int i=1; i<r; i++) {
			for(int j=0; j<c; j++) 
				auxMatrix[i][j] = in[i][j] + auxMatrix[i-1][j];
		}
		
		//save row sums in auxMatrix
		for(int i=0; i<r; i++) {
			for(int j=1; j<c; j++) 
				auxMatrix[i][j] += auxMatrix[i][j-1];
		}
		 
		/* printing the auxMatrix */
		  for(int i=0; i<r; i++) {
			System.out.println();
			for(int j=0; j<c; j++) {
				System.out.print(auxMatrix[i][j] + " ");
			}
		}
		
		return auxMatrix;
	}
}
