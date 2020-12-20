/**
 * 
 */
package home.ak.algo.dp;

/**
 * @author kundu
 * 
 *         Given n, how many structurally unique BST's (binary search trees)
 *         that store values 1 ... n?
 * 
 *         Example:
 * 
 *         Input: 3 Output: 5 Explanation: Given n = 3, there are a total of 5
 *         unique BST's:
 * 
 *         
 *				  1         3     3      2      1
 *				   \       /     /      / \      \
 *				    3     2     1      1   3      2
 *				   /     /       \                 \
 *				  2     1         2                 3
 *
 */
public class UniqueBSTs {
	
	/**
	 * Catalan Number Problem
	 */
	public int numTrees(int n) {

		// Subproblems from 0 to n hence the n + 1 to accommodate the 0 subproblem
		int[] dp = new int[n + 1];

		// Base case: when n = 0 and n = 1
		dp[0] = 1;
		dp[1] = 1; // A single node can only make 1 unique tree.

		/*
		 * The answer to the ith subproblem will be the summation of F(i, n) for i = 0
		 * to i = n (where we plant every number as the root). For n = 3, we test for 1
		 * as the root, 2 as the root and 3 as the root
		 * 
		 * The answer to the total unique BST's we can construct with values from 1...n
		 * with i representing what is rooted at the root of the tree is F(i, n),
		 * expressed as F(i, n) = G(i - 1) * G(n - i)
		 * 
		 * We attain this value by taking the Cartesian Product (fancy word meaning all
		 * possible cross products) between all possible unique left BST's and unique
		 * right BST's.
		 * 
		 * All possible unique left BST's count is G[j - 1] if we plant at i.
		 * 
		 * All possible unique right BST's count is G[i - j] if we plant at i.
		 * 
		 * Taking a product is the same as taking all pairing between the two sets of
		 * possibilities.
		 */
		for (int i = 2; i <= n; i++) {
			// Place every element at root and compute
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 3;
		System.out.println(new UniqueBSTs().numTrees(n));
	}

}
