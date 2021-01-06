/**
 * 
 */
package home.ak.algo.bitmanipulation;

/**
 * @author kundu
 *
 */
public class BitOperations {

	public static void bitOperations(int a, int b) {

		// Let the initial values be a = 5 and b = 7

		// 1. Bitwise AND - &
		// 0101 & 0111 = 0101 = 5 (since 1 & 0 = 0 and 1 & 1 = 1)
		System.out.println("a&b = " + (a & b));

		// 2. Bitwise OR - |
		// 0101 & 0111 = 0111 = 7 (Since 1 | 0 = 0 and 1 | 1 = 1)
		System.out.println("a|b = " + (a | b));

		// 3. Bitwise XOR - ^
		// 0101 & 0111 = 0010 = 2 (Since 1 ^ 1 and 0 ^ 0 = 0)
		System.out.println("a^b = " + (a ^ b));

		// 4. Bitwise left shift - <<
		// 0101 << 2 = 010100 = 20 (Number moved by 2 places on left)
		System.out.println("a << 2 = " + (a << 2));

		// 5. Bitwise right shift - >>
		// 0101 >> 2 = 01 = 1 (Number moved by 2 places towards right)
		System.out.println("a >> 2 = " + (a >> 2));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		bitOperations(5, 7);
	}

}
