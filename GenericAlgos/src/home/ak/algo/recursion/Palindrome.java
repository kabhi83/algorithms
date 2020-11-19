/**
 * 
 */
package home.ak.algo.recursion;

/**
 * @author kundu
 * 
 *         Check if a given String is palindrome or not
 * 
 *         Recurrence relation:
 * 
 *         isPalindrome(S, i, j) = isPalindrome(S, i+1, j-1) if S[i] = S[j],
 *         else false
 *
 */
public class Palindrome {

	public static boolean isPalindrome(String str) {
		return isPalindrome(str, 0, str.length() - 1);
	}

	private static boolean isPalindrome(String str, int i, int j) {
		
		//Base case to stop the execution
		if (i >= j) {
			return true;

		}
		return str.charAt(i) == str.charAt(j) && isPalindrome(str, i + 1, j - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "dear";
		System.out.println(isPalindrome(str1));

		String str2 = "dabad";
		System.out.println(isPalindrome(str2));
	}

}
