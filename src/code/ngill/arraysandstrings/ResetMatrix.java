package code.ngill.arraysandstrings;

public class ResetMatrix {

	public static int[][] resetMatrix(int[][] matrix) {
		int[] rows = new int[matrix.length];
		int[] cols = new int[matrix[0].length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
				}
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(cols[j] == 1 || rows[i] ==1) {
					matrix[i][j] = 0;
				}
			}
		}
		
		return matrix;
		
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{0,1,2,3},
						  {1,2,3,4},
						  {2,3,4,0},
						  {2,3,1,2}};
		printMatrix(resetMatrix(matrix));
	}
	
	private static void printMatrix(int[][] rotatedImage) {
		for (int i = 0; i < rotatedImage.length; i++) {
			for (int j = 0; j < rotatedImage[0].length; j++) {
				System.out.print(rotatedImage[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
