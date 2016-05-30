package code.ngill.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

public class UniqueChars {

	public boolean containsOnlyUniqueChars(String string) {
		Set<Character> foundCharacters = new HashSet<Character>();
		for(char c : string.toCharArray()) {
			if(foundCharacters.contains(c)) {
				return false;
			}
			
			foundCharacters.add(c);
		}
		
		return true;
	}
	
	public boolean containsOnlyUniqueCharsNoAddDS(String string) {
		for (int i = 0; i < string.length() - 1; i++) {
			for (int j = i + 1; j < string.length(); j++) {
				if(string.charAt(i) == string.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	//Other solutions...
	public boolean otherSolution(String string) {
		boolean[] charSet = new boolean[256];
		for (int i = 0; i < string.length(); i++) {
			int val = string.charAt(i);
			if(charSet[val]) return false;
			charSet[val] = true;
		}
		return true;
	}
	
	public boolean otherSolution2(String string) {
		int checker = 0;
		for (int i = 0; i < string.length(); i++) {
			int val = string.charAt(i) - 'a';
			if((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}
}
