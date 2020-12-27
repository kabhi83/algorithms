/**
 * 
 */
package home.ak.algo.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kundu
 *
 *         Given a string s containing only digits, return all possible valid IP
 *         addresses that can be obtained from s. You can return them in any
 *         order.
 * 
 *         A valid IP address consists of exactly four integers, each integer is
 *         between 0 and 255, separated by single dots and cannot have leading
 *         zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP
 *         addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are
 *         invalid IP addresses.
 * 
 *         Example 1:Input: s = "25525511135" Output:
 *         ["255.255.11.135","255.255.111.35"]
 * 
 *         Example 2:Input: s = "0000" Output: ["0.0.0.0"]
 */
public class RestoreIPAddress {

	public static List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();

		if (s.length() > 12) { // Max 3 integers per octet
			return res;
		}

		int n = s.length();

		for (int i = 1; i < n && i < 4; i++) {
			String first = s.substring(0, i);
			if (!isValidPart(first)) {
				continue;
			}
			for (int j = 1; i + j < n && j < 4; j++) {
				String second = s.substring(i, i + j);
				if (!isValidPart(second)) {
					continue;
				}
				for (int k = 1; i + j + k < n && k < 4; k++) {
					String third = s.substring(i + j, i + j + k);
					String fourth = s.substring(i + j + k);
					if (!isValidPart(third) || !isValidPart(fourth)) {
						continue;
					}
					res.add(first + "." + second + "." + third + "." + fourth);
				}
			}
		}
		return res;
	}

	private static boolean isValidPart(String part) {
		if (part.length() > 3 || part.startsWith("0") && part.length() > 1) {
			// 0 is valid but 00, 01, 02.. are not
			return false;
		}
		int val = Integer.parseInt(part);
		return val >= 0 && val <= 255;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "25525511135";
		List<String> result = restoreIpAddresses(s);
		System.out.println(result);
	}

}
