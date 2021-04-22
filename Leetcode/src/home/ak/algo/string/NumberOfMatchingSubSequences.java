/**
 * 
 */
package home.ak.algo.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kundu
 * 
 *         Given a string s and an array of strings words, return the number of
 *         words[i] that is a subsequence of s.
 * 
 *         A subsequence of a string is a new string generated from the original
 *         string with some characters (can be none) deleted without changing
 *         the relative order of the remaining characters.
 * 
 *         For example, "ace" is a subsequence of "abcde".
 * 
 *         Input: s = "abcde", words = ["a","bb","acd","ace"]
 * 
 *         Output: 3. Explanation: There are three strings in words that are a
 *         subsequence of s: "a", "acd", "ace".
 *
 */
public class NumberOfMatchingSubSequences {

	public static int numMatchingSubseq(String s, String[] words) {
		int count = 0;
		Map<Character, List<String>> map = new HashMap<>();
		for(String word: words) {
			char ch = word.charAt(0);
			if(!map.containsKey(ch)) {
				map.put(ch, new ArrayList<>());
			}
			map.get(ch).add(word);
		}
		
		for(char c: s.toCharArray()) {
			List<String> list = map.get(c);
			if(null != list) {
				map.remove(c);
				for(String str: list) {
					if(str.length() == 1) {
						count++;
						continue;
					}
					//get the substring
					char ch = str.charAt(1);
					if(!map.containsKey(ch)) {
						map.put(ch, new ArrayList<>());
					}
					map.get(ch).add(str.substring(1));
				}
			}
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "abcde";
		String[] words1 = {"a","bb","acd","ace"};
		System.out.println(numMatchingSubseq(s1, words1));
		
		String s2 = "dsahjpjauf";
		String[] words2 = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
		System.out.println(numMatchingSubseq(s2, words2));
	}

}
