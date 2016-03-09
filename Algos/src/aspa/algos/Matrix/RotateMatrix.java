/**
 * Rotate the given matrix in 90 degree to the right.
 * Assuming it is a square matrix i.e. N*N.
 * 
 * Current solution can be easily tweaked to any order matrix.
 * We shall need to maintain a separate matrix for rotated one.
 * And fill in that matrix from given matrix.
 *  
 */

package aspa.algos.Matrix;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16} };
		final int M = matrix.length;
		final int N = matrix[0].length;
		rotate90degree(matrix, M, N);
	}

	private static void rotate90degree(int[][] matrix, int M, int N) {
		transposeOf(matrix, M, N);
	}

	private static void transposeOf(int[][] matrix, int M, int N) {
		// Take a transpose of a matrix
		for (int i = 0; i < M; i++){
			for (int j = i; j < N; j++){
				swap(matrix, i, j);
			}
		}
		// And then reverse every row.
		for (int i = 0; i < M; i++){
			for (int j = 0; j < N / 2; j++){
				if (matrix[i][j] == matrix[i][N-1-j])
					continue;
				matrix[i][j]     = matrix[i][j] ^ matrix[i][N-1-j];
				matrix[i][N-1-j] = matrix[i][j] ^ matrix[i][N-1-j];
				matrix[i][j]     = matrix[i][j] ^ matrix[i][N-1-j];
			}
		}
		
		printMatrix(matrix, M, N);
	}
	
	private static void swap(int[][] matrix, int i, int j){
		if (matrix[i][j] == matrix[j][i])
			return;
		matrix[i][j] = matrix[i][j] ^ matrix[j][i];
		matrix[j][i] = matrix[i][j] ^ matrix[j][i];
		matrix[i][j] = matrix[i][j] ^ matrix[j][i];
	}
	
	private static void printMatrix(int[][] matrix, int M, int N){
		for (int i = 0; i < M; i++){
			System.out.println();
			for (int j = 0; j < N; j++){
				System.out.print(matrix[i][j] + " ");
			}
		}		
	}

}
