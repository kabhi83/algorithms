/**
 * 
 */
package home.ak.algo.recursion;

/**
 * @author kundu
 * 
 * 
 *         Find the sum of the digits of the given number
 * 
 *         Recurrence relation:
 * 
 *         digitSum(num) = num%10 + digitSum(num/10);
 *
 */
public class DigitSum {

	public static int digitSum(int num) {
		//Base case
		if (num == 0) {
			return 0;
		}
		return num % 10 + digitSum(num / 10);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 123456;
		System.out.println(digitSum(num));
	}

}
