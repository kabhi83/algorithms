/**
 * 
 */
package home.ak.algo.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kundu
 * 
 *         Compute All Valid IP Addresses From Raw IP String
 * 
 *         Backtracking Problem:
 * 
 *         1. Choices: Snippets of 3 digit long
 * 
 *         2. Constraints: Value between 0 to 255 for all snippets and no
 *         snippet with leading 0
 * 
 *         3. Goal: 4 valid snippets (or sub-sections). Pointer is at the end
 * 
 *
 */
public class IPAddressRestoration {

	private static final String IP_DELIMETER = ".";

	public static List<String> restoreIPAddress(String S) {
		// Create the list to capture the results
		List<String> result = new ArrayList<>();
		int[] octets = new int[4]; // 4 octet of the ip address
		// Initiate backtracking - choose, explore and unchoose
		restoreIPAddress(result, 0, S, octets, 0); // driver program
		return result;
	}

	private static void restoreIPAddress(List<String> result, int index, String S, int[] octets, int octet) {
		// Base case: If we have filled 4 segments (0, 1, 2, 3) and we are on the 4th,
		// we will only record an answer if the string was decomposed fully
		if (octet == 4 && index >= S.length()) {
			// Reached the end
			result.add(octets[0] + IP_DELIMETER + octets[1] + IP_DELIMETER + octets[2] + IP_DELIMETER + octets[3]);
			return;
		} else if (octet == 4) {
			return;
		}

		// Generate segments to try, a segment can be 1 to 3 digits long.
		for (int segmentLength = 1; segmentLength <= 3 && index + segmentLength <= S.length(); segmentLength++) {
			String segment = S.substring(index, index + segmentLength);
			int segmentValue = Integer.parseInt(segment);
			if (segmentValue > 255 || segmentLength >= 2 && segment.charAt(0) == '0') {
				// Constraint validation fails
				break;
			}

			octets[octet] = segmentValue;
			// Recurse on the segment choice - when finished & we come back here, the next
			// loop iteration will try another segment
			restoreIPAddress(result, index + segmentLength, S, octets, octet + 1);
		}
	}

	public static void main(String[] args) {
		String S = "25525511135";
		System.out.println(restoreIPAddress(S));
	}

}
