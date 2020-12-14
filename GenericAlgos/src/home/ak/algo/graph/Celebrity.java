/**
 * 
 */
package home.ak.algo.graph;

/**
 * @author kundu
 * 
 *         In a party of N people, only one person is known to everyone. Such a
 *         person may be present in the party, if yes, (s)he doesn’t know anyone
 *         in the party. We can only ask questions like “does A know B? “. Find
 *         the stranger (celebrity) in the minimum number of questions. We can
 *         describe the problem input as an array of numbers/characters
 *         representing persons in the party. We also have a hypothetical
 *         function knows(A, B) which returns true if A knows B, false
 *         otherwise. How can we solve the problem.
 * 
 *         1. Input:
 * 
 *         MATRIX = { {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 0, 1, 0} }
 *         Output:id = 2 Explanation: The person with ID 2 does not know anyone
 *         but everyone knows him
 * 
 *         2. Input:
 * 
 *         MATRIX = { {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 1, 0, 0}, {0, 0, 1, 0} }
 *         Output: No celebrity Explanation: There is no celebrity.
 *
 */
public class Celebrity {

	static int[][] matrix = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

	static boolean knows(int a, int b) {
		return matrix[a][b] == 1 ? true : false;
	}

	public static int findCelebrity(int n) {
		if (n <= 1) {
			return -1;
		}

		int[] inDegree = new int[n];
		int[] outDegree = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// Check if we are not comparing same person
				if (i != j && knows(i, j)) {
					outDegree[i]++;
					inDegree[j]++;
				}
			}
		}

		// Check for celebrity with only inDegree value and 0 outDegree value
		for(int i = 0; i < n; i++) {
			if(inDegree[i] == n-1 && outDegree[i] == 0) {
				//Everyone know i and i knows none
				return i;
			}
		}

		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int celebrity = findCelebrity(4);
		System.out.println(celebrity);
	}

}
