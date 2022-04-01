/**
 * 
 */
package home.ak.algo.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author kundu
 * 
 *         You are given two strings stamp and target. Initially, there is a
 *         string s of length target.length with all s[i] == '?'.
 * 
 *         In one turn, you can place stamp over s and replace every letter in
 *         the s with the corresponding letter from stamp.
 * 
 *         For example, if stamp = "abc" and target = "abcba", then s is "?????"
 *         initially. In one turn you can:
 * 
 *         place stamp at index 0 of s to obtain "abc??",
 * 
 *         place stamp at index 1 of s to obtain "?abc?",
 * 
 *         or place stamp at index 2 of s to obtain "??abc".
 * 
 *         Note that stamp must be fully contained in the boundaries of s in
 *         order to stamp (i.e., you cannot place stamp at index 3 of s). We
 *         want to convert s to target using at most 10 * target.length turns.
 * 
 *         Return an array of the index of the left-most letter being stamped at
 *         each turn. If we cannot obtain target from s within 10 *
 *         target.length turns, return an empty array.
 *
 */
public class StampingTheSequence {

	public static int[] movesToStamp(String stamp, String target) {
		// Reverse analysis - target to string with ? only

		// Convert to char arrays
		char[] stampArr = stamp.toCharArray();
		char[] targetArr = target.toCharArray();

		int count = 0; // count of ?
		boolean[] visitedIdx = new boolean[target.length()];

		List<Integer> result = new ArrayList<>();

		while (count < target.length()) {
			boolean isChanged = false;
			for (int i = 0; i < target.length() - stamp.length(); i++) {
				// Check if starting from this index, is it possible to replace the stamp chars
				// with target chars
				if (!visitedIdx[i] && canReplace(i, stampArr, targetArr)) {
					// Replace the chars in target string till the stamp length
					count = replace(i, targetArr, stamp.length(), count);
					visitedIdx[i] = true;
					isChanged = true;
					result.add(i);

					if (count == target.length()) {
						break;
					}
				}

			}

			if (!isChanged) {
				return new int[0];
			}
		}

		// reverse the list since we are moving from backward
		Collections.reverse(result);
		int[] resArr = new int[result.size()];
		int k = 0;
		for (int res : result) {
			resArr[k++] = res;
		}
		return resArr;

	}

	private static boolean canReplace(int pos, char[] stampArr, char[] targetArr) {
		for (int i = 0; i < stampArr.length; i++) {
			if (targetArr[i + pos] != '?' && targetArr[i + pos] != stampArr[i]) {
				return false;
			}
		}
		return true;
	}

	private static int replace(int pos, char[] targetArr, int length, int count) {
		for (int i = 0; i < length; i++) {
			if (targetArr[i + pos] != '?') {
				targetArr[i + pos] = '?';
				count++;
			}
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
