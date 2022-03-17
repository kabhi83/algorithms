/**
 * 
 */
package home.ak.algo.recursion;

/**
 * @author kundu
 * 
 *         Print from 1 to N without using + operator
 *
 */
public class L2_PrintNNumberWithBacktrack {

	public static void print(int i, int N) {
		if (i < 1) {
			return;
		}
		print(i - 1, N);
		System.out.println(i);
	}

	public static void main(String[] args) {
		int N = 10;
		print(N, N);
	}

}
