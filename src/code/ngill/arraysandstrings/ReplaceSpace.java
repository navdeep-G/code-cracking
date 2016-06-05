package code.ngill.arraysandstrings;


public class ReplaceSpace {

	public static String replaceSpaces(String input) {
		if (input == null || input.isEmpty()) {
			return input;
		}

		char[] inputArray = input.toCharArray();
		int spaceCount = 0;
		for (char c : inputArray) {
			if (c == ' ') {
				spaceCount++;
			}
		}
		
		if(spaceCount == 0) {
			return input;
		}

		char[] outputArray = new char[inputArray.length + 2 * spaceCount];
		int outputIndex = 0;
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isSpaceChar(inputArray[i])) {
				outputArray[outputIndex] = inputArray[i];
				outputIndex++;
			} else {
				outputArray[outputIndex] = '%';
				outputArray[outputIndex+1] = '2';
				outputArray[outputIndex+2] = '0';
				outputIndex += 3;
			}
		}

		return new String(outputArray);
	}

	public static void main(String[] args) {
		String input = "hello world!";
		System.out.println(replaceSpaces(input));
	}

}
