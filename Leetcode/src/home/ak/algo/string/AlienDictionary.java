/**
 * 
 */
package home.ak.algo.string;

/**
 * @author kundu
 * 
 *         In an alien language, surprisingly they also use english lowercase
 *         letters, but possibly in a different order. The order of the alphabet
 *         is some permutation of lowercase letters.
 * 
 *         Given a sequence of words written in the alien language, and the
 *         order of the alphabet, return true if and only if the given words are
 *         sorted lexicographicaly in this alien language.
 * 
 *         Ex1: Input: words = ["hello","leetcode"], order =
 *         "hlabcdefgijkmnopqrstuvwxyz" Output: true
 * 
 *         Explanation: As 'h' comes before 'l' in this language, then the
 *         sequence is sorted.
 * 
 *         Ex2: Input: words = ["apple","app"], order =
 *         "abcdefghijklmnopqrstuvwxyz" Output: false
 * 
 *         Explanation: The first three characters "app" match, and the second
 *         string is shorter (in size.) According to lexicographical rules
 *         "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank
 *         character which is less than any other character
 *
 */
public class AlienDictionary {

	public boolean isAlienSorted(String[] words, String order) {
		int[] alphabet = new int[26]; // Only lower case English letters

		// Populate the lexicographical sort order in alphabet array
		for (int i = 0; i < order.length(); i++) {
			alphabet[order.charAt(i) - 'a'] = i;
		}

		// Compare each words in the words array
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				// Compare only to the size of the min length word
				int min = Math.min(words[i].length(), words[j].length());
				for (int k = 0; k < min; k++) {
					char iChar = words[i].charAt(k);
					char jChar = words[j].charAt(k);
					// case 1: Lexicographically sorted
					if (alphabet[iChar - 'a'] < alphabet[jChar - 'a']) {
						// Got to new word - move to next j
						break;
					}

					// case 2: Lexicographically not sorted
					if (alphabet[iChar - 'a'] > alphabet[jChar - 'a']) {
						return false;
					}

					// case 3: comparing 1st few equal char words - app & apple
					if (k == min - 1 && words[i].length() > words[j].length()) {
						// apple comes before app
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] words1 = {"word","world","row"};
		String order1 = "worldabcefghijkmnpqstuvxyz";
		System.out.println(new AlienDictionary().isAlienSorted(words1, order1));
		
		String[] words2 = {"apple", "app"};
		String order2 = "abcdefghijklmnopqrstuvwxyz";
		System.out.println(new AlienDictionary().isAlienSorted(words2, order2));
		
		String[] words3 = {"hello", "leetcode"};
		String order3 = "hlabcdefgijkmnopqrstuvwxyz";
		System.out.println(new AlienDictionary().isAlienSorted(words3, order3));
	}

}
