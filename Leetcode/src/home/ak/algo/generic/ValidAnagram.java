/**
 * 
 */
package home.ak.algo.generic;

/**
 * @author user
 * 
 *         Given two strings s and t , write a function to determine if t is an
 *         anagram of s.
 * 
 *         Example 1: Input: s = "anagram", t = "nagaram" Output: true
 * 
 *         Example 2: Input: s = "rat", t = "car" Output: false
 * 
 *         Note: You may assume the string contains only lower case alphabets.
 *
 */
public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		
		if(s.length() != t.length()){
			return false;
		}

		int[] charCount = new int[26]; // since only lower case

		for (int i = 0; i < s.length(); i++) {
			charCount[s.charAt(i) - 'a']++;
			charCount[t.charAt(i) - 'a']--;
		}

		for (int i = 0; i < 26; i++) {
			if (charCount[i] != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "anagram", t = "nagaram";
		// String s = "rat", t = "car";
		boolean result = new ValidAnagram().isAnagram(s, t);
		System.out.println(result);
	}

}
