package jack.algos.Matrix;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] in = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16} };
		rotate(in, 4);
	}
	public static void rotate(int[][] matrix, int n) {
		for (int layer = 0; layer < n / 2; ++layer) {
			int startIndex = layer;
			int endIndex = n - 1 - layer;
			
			for(int i = startIndex; i < endIndex; ++i) {
				int offset = i - startIndex;
				int top = matrix[startIndex][i]; // save top
				// left -> top
				matrix[startIndex][i] = matrix[endIndex-offset][startIndex];
				// bottom -> left
				matrix[endIndex-offset][startIndex] = matrix[endIndex][endIndex - offset];
				// right -> bottom
				matrix[endIndex][endIndex - offset] = matrix[i][endIndex];
				// top -> right
				matrix[i][endIndex] = top; // right <- saved top
			}
		}
		
		//printing the rotated matrix
		for(int i=0; i<matrix.length; i++) {
			System.out.println();
			for(int j=0; j<matrix[1].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
	}
}
