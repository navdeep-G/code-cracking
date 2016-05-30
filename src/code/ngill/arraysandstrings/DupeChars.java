package code.ngill.arraysandstrings;

public class DupeChars {

	public static void removeDuplicateChars(char[] string) {
		for (int i = 0; i < string.length - 1; i++) {
			if(string[i] == ' ') {
				continue;
			}
			for (int j = i + 1; j < string.length; j++) {
				if(string[i] == string[j]) {
					string[j] = ' ';
				}
			}
		}
		
		for (int i = 1; i < string.length - 1; i++) {
			if(string[i] == ' ') {
				string[i] = string[i+1];
				string[i+1] = ' ';
			}
		}
		System.out.println(string);
	}
	
	public static void removeDuplicateCharacters(char[] string) {
		int tail = 1;
		for (int i = 1; i < string.length; ++i) {
			int j;
			for (j = 0; j < tail; ++j) {
				if(string[i] == string[j]) break;
			}
			if(j == tail) {
				string[tail] = string[i];
				++tail;
			}
		}
		string[tail] = 0;
		System.out.println(string);
	}
	

	
	public static void main(String[] args) {
		char[] str = "aaaa".toCharArray();
		removeDuplicateCharacters(str);
	}
	
}
