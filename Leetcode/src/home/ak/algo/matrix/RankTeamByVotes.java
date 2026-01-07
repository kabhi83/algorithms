/**
 * 
 */
package home.ak.algo.matrix;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         In a special ranking system, each voter gives a rank from highest to
 *         lowest to all teams participating in the competition.
 * 
 *         The ordering of teams is decided by who received the most
 *         position-one votes. If two or more teams tie in the first position,
 *         we consider the second position to resolve the conflict, if they tie
 *         again, we continue this process until the ties are resolved. If two
 *         or more teams are still tied after considering all positions, we rank
 *         them alphabetically based on their team letter.
 * 
 *         You are given an array of strings votes which is the votes of all
 *         voters in the ranking systems. Sort all teams according to the
 *         ranking system described above.
 * 
 *         Return a string of all teams sorted by the ranking system.
 * 
 *         Example 1:
 * 
 *         Input: votes = ["ABC","ACB","ABC","ACB","ACB"] Output: "ACB"
 *         Explanation: Team A was ranked first place by 5 voters. No other team
 *         was voted as first place, so team A is the first team. Team B was
 *         ranked second by 2 voters and ranked third by 3 voters. Team C was
 *         ranked second by 3 voters and ranked third by 2 voters. As most of
 *         the voters ranked C second, team C is the second team, and team B is
 *         the third.
 *
 */
public class RankTeamByVotes {

	public static String rankTeams(String[] votes) {
		int positionCnt = votes[0].length();
		int[][] voteCount = new int[26][positionCnt];

		for (String vote : votes) {
			for (int i = 0; i < positionCnt; i++) {
				char c = vote.charAt(i);
				voteCount[c - 'A'][i]++;
			}
		}
		System.out.println(Arrays.deepToString(voteCount));

		Character[] tmp = new Character[positionCnt];
		for (int i = 0; i < positionCnt; i++) {
			tmp[i] = votes[0].charAt(i);
		}

		Arrays.sort(tmp, (t1, t2) -> {
			for (int i = 0; i < positionCnt; i++)
				if (voteCount[t1 - 'A'][i] != voteCount[t2 - 'A'][i]) {
					return voteCount[t2 - 'A'][i] - voteCount[t1 - 'A'][i]; // return team with higher votes
				}
			return t1 - t2; // return team with lower alphabetically letter

		});

		StringBuilder result = new StringBuilder();

		for (Character c : tmp)
			result.append(c);

		return result.toString();
	}

	public static void main(String[] args) {
		String[] votes = { "ABC", "ACB", "ABC", "ACB", "ACB" };

		System.out.println(rankTeams(votes));
	}

}
