/**
 * 
 */
package home.ak.algo.recursion;

/**
 * @author kundu
 *
 */
public class L01_PrintNNumbers {

	public static void print(int i, int N) {
		// Base case
		if (i > N) {
			return;
		}
		System.out.println(i);
		print(i + 1, N);
	}
	
	public static void main(String[] args) {
		int N = 10;
		print(1, N);
	}

}
