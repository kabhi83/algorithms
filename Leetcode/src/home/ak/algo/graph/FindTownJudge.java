/**
 * 
 */
package home.ak.algo.graph;

/**
 * @author kundu
 * 
 *         In a town, there are N people labeled from 1 to N. There is a rumor
 *         that one of these people is secretly the town judge.
 * 
 *         If the town judge exists, then:
 * 
 *         1. The town judge trusts nobody.
 * 
 *         2. Everybody (except for the town judge) trusts the town judge.
 * 
 *         There is exactly one person that satisfies properties 1 and 2. You
 *         are given trust, an array of pairs trust[i] = [a, b] representing
 *         that the person labelled a trusts the person labelled b.
 * 
 *         If the town judge exists and can be identified, return the label of
 *         the town judge. Otherwise, return -1.
 * 
 *         Example 1: Input: N = 2, trust = [[1,2]] Output: 2
 * 
 *         Example 2: Input: N = 3, trust = [[1,3],[2,3]] Output: 3
 *
 */
public class FindTownJudge {

	public int findJudge(int N, int[][] trust) {

		int[] trustCount = new int[N + 1]; // +1 since people are labeled from 1 to N

		// Concept of in-degree and out-degree edges. If a person gives trust -> Giver
		// loses one point and receiver gets one point

		for (int i = 0; i < trust.length; i++) {
			trustCount[trust[i][0]]--; // Gives trust
			trustCount[trust[i][1]]++; // Receives trust
		}

		for (int i = 1; i < trustCount.length; i++) {
			if (trustCount[i] == N - 1) // Trust of all except himself
				return i;
		}

		return -1;
	}

	public static void main(String[] args) {
		int N = 3;
		int[][] trust = { { 1, 3 }, { 2, 3 } };
		System.out.println(new FindTownJudge().findJudge(N, trust));
	}

}
