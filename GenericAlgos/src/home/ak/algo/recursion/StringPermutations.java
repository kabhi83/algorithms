/**
 * 
 */
package home.ak.algo.recursion;

/**
 * @author kundu
 *
 */
public class StringPermutations {

	void permute(String str) {
		permute(str, 0, str.length() - 1);
	}

	private void permute(String str, int left, int right) {
		if (left == right) {
			System.out.println(str);
			return;
		}

		for (int i = left; i <= right; i++) {
			String swapped = swap(str, left, i);
			permute(swapped, left + 1, right);
		}
	}

	private String swap(String str, int i, int j) {
		char[] charArr = str.toCharArray();
		char temp = charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = temp;
		return String.valueOf(charArr);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "ABC";
		new StringPermutations().permute(str);
	}

}
