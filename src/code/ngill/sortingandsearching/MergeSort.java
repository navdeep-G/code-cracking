package code.ngill.sortingandsearching;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int A[] = new int[] { 2, 4, 5, -1, -1 };
		int B[] = new int[] { 1,3 };
		mergeArrays(A, B);
		System.out.println(Arrays.toString(A));
	}

	private static void mergeArrays(int[] A, int[] B) {
		int lastAIndex = B.length;
		int lastBIndex = B.length - 1;
		int insertIndex = A.length - 1;

		while (lastAIndex >= 0 && lastBIndex >= 0) {
			if (A[lastAIndex] > B[lastBIndex]) {
				A[insertIndex] = A[lastAIndex];
				lastAIndex--;
			} else {
				A[insertIndex] = B[lastBIndex];
				lastBIndex--;
			}
			insertIndex--;
		}

		while (lastBIndex >= 0) {
			A[insertIndex] = B[lastBIndex];
			lastBIndex--;
		}

	}

}
