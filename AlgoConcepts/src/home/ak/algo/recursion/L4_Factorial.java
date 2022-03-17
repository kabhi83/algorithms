/**
 * 
 */
package home.ak.algo.recursion;

/**
 * @author kundu
 *
 */
public class L4_Factorial {

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(factorial(3));
	}

}
