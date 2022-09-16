/**
 * 
 */
package home.ak.algo.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kundu
 * 
 *         Given n pairs of parentheses, write a function to generate all
 *         combinations of well-formed parentheses.
 *
 */
public class L11_GenerateAllParanthesis {

	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		solve(n, "", 0, 0, result);
		return result;
	}

	private static void solve(int n, String currStr, int openCount, int closeCount, List<String> result) {
		if(currStr.length() == 2 * n) { //since 2 parenthesis per pair (i.e., "()")
			result.add(currStr);
			return;
		}
		
		if(openCount < n) {
			solve(n, currStr + "(", openCount + 1, closeCount, result);
		}
		if(closeCount < openCount) {
			solve(n, currStr + ")", openCount, closeCount + 1, result);
		}
	}
	
	public static void main(String[] args) {
		int n = 3;
		System.out.println(generateParenthesis(n));
	}

}
