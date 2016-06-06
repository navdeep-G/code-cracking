package code.ngill.arraysandstrings;

public class RotatedString {

	public static boolean isRotatedString(String base, String rotated) {
		if(base.length() != rotated.length()) {
			return false;
		}
		
		String concatenated = rotated.concat(rotated);
		return concatenated.indexOf(base) != -1;
	}
	
	public static void main(String[] args) {
		System.out.println(isRotatedString("apple", "pleap"));
		System.out.println(isRotatedString("apple", "ppeap"));
	}
	
}
