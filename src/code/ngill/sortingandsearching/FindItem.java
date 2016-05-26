package code.ngill.sortingandsearching;

public class FindItem {

	public static void main(String[] args) {
		int numbers[] = new int[] { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
		System.out.println(findItemRecursive(numbers, 0, 11, 5));
		System.out.println(findItemIterative(numbers, 0, 11, 5));
		
		numbers = new int[] { 1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20, 25 };
		System.out.println(findItemRecursive(numbers, 0, 11, 5));
		System.out.println(findItemIterative(numbers, 0, 11, 5));
		
		numbers = new int[] { 1, 3, 4, 7, 10, 14, 15, 16, 19, 20, 25 };
		System.out.println(findItemRecursive(numbers, 0, 10, 5));
		System.out.println(findItemIterative(numbers, 0, 10, 5));
		
		numbers = new int[] { 5, 7, 10, 14, 15, 16, 19, 20, 25, 1, 3, 4 };
		System.out.println(findItemRecursive(numbers, 0, 10, 5));
		System.out.println(findItemIterative(numbers, 0, 10, 5));
	}

	private static int findItemRecursive(int[] numbers, int beginning, int end,
			int i) {
		int middle = ((end - beginning) / 2) + beginning;

		if (end < beginning) {
			return -1;
		}

		if (numbers[middle] == i) {
			return middle;
		}

		if (numbers[middle] < i && numbers[end] >= i) {
			return findItemRecursive(numbers, middle + 1, end, i);
		} else {
			return findItemRecursive(numbers, beginning, middle - 1, i);
		}
	}

	private static int findItemIterative(int[] numbers, int beginning, int end,
			int i) {
		while (end > beginning) {
			int middle = ((end - beginning) / 2) + beginning;
			if (numbers[middle] == i) {
				return middle;
			}

			if (numbers[middle] < i && numbers[end] >= i) {
				beginning = middle+1;
			} else {
				end = middle - 1;
			}
		}
		return -1;
	}

}
