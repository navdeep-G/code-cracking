package code.ngill.bitmanipulation;



public class SwapBits {

	public static void main(String[] args) {
		System.out.println("Before: " + Integer.toBinaryString(23));
		System.out.println("Swapped: " + Integer.toBinaryString(swapBits(23)));
	}

	private static int swapBits(int number) {
		// 0xaaaaaaaa = 10101010101010101010101010101010
		// 0x55555555 = 01010101010101010101010101010101
		return ((number & 0xaaaaaaaa) >> 1) | ((number & 0x55555555) << 1);
	}
}
