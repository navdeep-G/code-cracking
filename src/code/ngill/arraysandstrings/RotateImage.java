package code.ngill.arraysandstrings;


public class RotateImage {

	public static int[][] rotateImage(int[][] image, int n) {
		for(int i = 0; i < n / 2 ; ++i) {
			int first = i;			
			int last = n - 1 - i;	
			for(int j = first; j < last ; ++j) {
				int offset = j - first;
				int top = image[first][j];
				
				image[first][j] = image[last-offset][first];
				image[last-offset][first] = image[last][last - offset];
				image[last][last - offset] = image[j][last];
				image[j][last] = top;
			}
		}
		
		return image;
	}
	
	public static void main(String[] args) {
		int[][] image = {{1,2,3}, {4,5,6}, {7,8,9}};
		printMatrix(image);
		System.out.println();
		printMatrix(rotateImage(image, 3));
	}

	private static void printMatrix(int[][] rotatedImage) {
		for (int i = 0; i < rotatedImage.length; i++) {
			for (int j = 0; j < rotatedImage.length; j++) {
				System.out.print(rotatedImage[i][j] + " ");
			}
			System.out.println();
		}
	}

}
