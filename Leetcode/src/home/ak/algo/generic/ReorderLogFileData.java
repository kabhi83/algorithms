/**
 * 
 */
package home.ak.algo.generic;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You have an array of logs. Each log is a space delimited string of
 *         words.
 * 
 *         For each log, the first word in each log is an alphanumeric
 *         identifier. Then, either:
 * 
 *         1. Each word after the identifier will consist only of lowercase
 *         letters, or;
 * 
 *         2. Each word after the identifier will consist only of digits.
 * 
 *         We will call these two varieties of logs letter-logs and digit-logs.
 *         It is guaranteed that each log has at least one word after its
 *         identifier.
 * 
 *         Reorder the logs so that all of the letter-logs come before any
 *         digit-log. The letter-logs are ordered lexicographically ignoring
 *         identifier, with the identifier used in case of ties. The digit-logs
 *         should be put in their original order.
 * 
 *         Return the final order of the logs.
 *
 */
public class ReorderLogFileData {

	public String[] reorderLogFiles(String[] logs) {

		// Sort the array of logs
		Arrays.sort(logs, (log1, log2) -> {
			String[] split1 = log1.split(" ", 2);
			String[] split2 = log2.split(" ", 2);
			boolean isLog1LetterLog = Character.isLetter(split1[1].charAt(0));
			boolean isLog2LetterLog = Character.isLetter(split2[1].charAt(0));

			if (isLog1LetterLog && isLog2LetterLog) {
				// Sort lexicographically
				int lexOrder = split1[1].compareTo(split2[1]);
				// In case of tie
				if (lexOrder == 0) {
					lexOrder = split1[0].compareTo(split2[0]);
				}
				return lexOrder;
			}
			return isLog1LetterLog ? -1 : isLog2LetterLog ? 0 : 1;
			// If 1st log is letter log, then it's the smallest; if the second log is letter
			// log then it's smaller and both are digit logs, the order has to be preserved
		});
		return logs;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] logs = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
		logs = new ReorderLogFileData().reorderLogFiles(logs);
		System.out.println(Arrays.toString(logs));
	}

}
