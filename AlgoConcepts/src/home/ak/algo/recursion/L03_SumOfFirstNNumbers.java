/**
 * 
 */
package home.ak.algo.recursion;

/**
 * @author kundu
 *
 */
public class L03_SumOfFirstNNumbers {

	/**
	 * Parameterized function - operated on the parameter "sum"
	 */
	public static void sumParameterized(int i, int sum) {

		if (i < 1) {
			System.out.println(sum);
			return;
		}
		sumParameterized(i - 1, sum + i);
	}

	/**
	 * Functional solution working on the returned value. The function yields a
	 * return value
	 */
	public static int sumFunctional(int n) {
		if (n == 0) {
			return 0;
		}
		// Below line is incomplete and waits for the completion
		return n + sumFunctional(n - 1);
	}

	public static void main(String[] args) {
		int N = 10;
		sumParameterized(N, 0);
		System.out.println(sumFunctional(N));
	}

}
