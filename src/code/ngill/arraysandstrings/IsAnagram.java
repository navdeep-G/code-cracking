package code.ngill.arraysandstrings;

import java.util.Arrays;

public class IsAnagram {

	public static boolean isAnagram(String input, String base) {
		if(input == null || base == null || input.length() != base.length()) {
			return false;
		}
		
		char[] charArrayInput = input.toCharArray();
		Arrays.sort(charArrayInput);
		
		char[] charArrayBase = base.toCharArray();
		Arrays.sort(charArrayBase);
		
		return Arrays.equals(charArrayInput, charArrayBase);
	}

	public static boolean isAnagramTwo(String input, String base) {
		if(input == null || base == null || input.length() != base.length()) {
			return false;
		}
		
		int[] charCount = new int[256];
		int uniqueChars = 0;
		
		for(char c : input.toCharArray()) {
			if(charCount[c] == 0) {
				uniqueChars++;
			}
			++charCount[c];
		}
		
		for(char c : base.toCharArray()) {
			if(charCount[c] <= 0) {
				return false;
			}
			
			--charCount[c];
			if(charCount[c] == 0) {
				--uniqueChars;
				if(uniqueChars == 0) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		String input = "abc";
		String base = "cbaa";
		System.out.println(isAnagram(input, base));
		System.out.println(isAnagramTwo(input, base));
	}
	
}
