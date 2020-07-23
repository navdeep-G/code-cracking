package code.ngill.bitmanipulation;

import java.security.InvalidParameterException;

public class InsertBits {

	public static void main(String[] args) {
		int n = Integer.parseInt("100000111000", 2);
		int m = Integer.parseInt("10001", 2);
		int i = 2;
		int j = 6;
		System.out.println(Integer.toBinaryString(insertBits(n, m, i, j)));
	}

	private static int insertBits(int n, int m, int i, int j) {
		if (j-i + 1 < Integer.toBinaryString(m).length()) {
			throw new InvalidParameterException();
		}
		
		int mask = ~0 << (j+1) | (1 << i) - 1;
		n = n & mask;

		int paddedToInsert = m << i;
		return n | paddedToInsert;
	}
	
}
