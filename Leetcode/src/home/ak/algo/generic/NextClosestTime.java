/**
 * 
 */
package home.ak.algo.generic;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kundu
 * 
 *         Given a time represented in the format "HH:MM", form the next closest
 *         time by reusing the current digits. There is no limit on how many
 *         times a digit can be reused.
 * 
 *         You may assume the given input string is always valid. For example,
 *         "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 * 
 *         Example 1: Input: "19:34" Output: "19:39"
 * 
 *         Explanation: The next closest time choosing from digits 1, 9, 3, 4,
 *         is 19:39, which occurs 5 minutes later. It is not 19:33, because this
 *         occurs 23 hours and 59 minutes later.
 * 
 *         Example 2: Input: "23:59" Output: "22:22" Explanation: The next
 *         closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be
 *         assumed that the returned time is next day's time since it is smaller
 *         than the input time numerically.
 *
 */
public class NextClosestTime {

	public String nextClosestTime(String time) {

		// Convert the given time to minutes
		int minutes = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));

		// Capture all the digits of the original time
		Set<Integer> digits = new HashSet<>();
		for (char c : time.toCharArray()) {
			if (c != ':') {
				digits.add(c - '0');
			}
		}

		// Simulate a clock by adding 1 minute each time
		while (true) {
			minutes = (minutes + 1) % (24 * 60);
			int[] nextTime = { minutes / 60 / 10, minutes / 60 % 10, minutes % 60 / 10, minutes % 60 % 10 };

			// Check if all the digits in the new time is a valid digit
			boolean isValid = true;
			for (int digit : nextTime) {
				if (!digits.contains(digit)) {
					isValid = false;
				}
			}

			// If all digits are present in the original time
			if (isValid) {
				return String.format("%02d:%02d", minutes / 60, minutes % 60);
			}
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String time = "23:59";
		System.out.println(new NextClosestTime().nextClosestTime(time));

	}

	/*
	 * Time Complexity: O(1). We try up to 24 * 60 possible times until we find the
	 * correct time.
	 * 
	 * Space Complexity: O(1).
	 */

}
