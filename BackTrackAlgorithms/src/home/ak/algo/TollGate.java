/**
 * 
 */
package home.ak.algo;

/**
 * @author user
 *
 */
public class TollGate {

	private int N; // Toll no. of tolls
	private int[] tollCost;// Toll cost to hire all the soldiers
	private int[] tollHire;// Total number of soldiers at all toll
	private Integer minCost = Integer.MAX_VALUE;

	public void dfs(int tollPosition, int battlePool3, int battlepool2, int battlepool1, int currentCost) {
		int totalBattlePool = battlepool1 + battlepool2 + battlePool3;

		if (currentCost > minCost) {
			return; // No more computation needed
		}

		if (tollPosition == N - 1) {
			if (totalBattlePool < tollHire[tollPosition]) {
				currentCost += tollCost[tollPosition];
			}

			if (currentCost < minCost) {
				minCost = currentCost;
				return;
			}
		}

		// toll pay option
		dfs(tollPosition + 1, battlePool3, battlepool2, battlepool1, currentCost + tollCost[tollPosition]);

		// toll hire option
		dfs(tollPosition + 1, battlePool3 + tollHire[tollPosition], battlepool2, battlepool1,
				currentCost + 2 * tollCost[tollPosition]);

		// toll battle option
		if (totalBattlePool >= tollHire[tollPosition]) {
			if (tollHire[tollPosition] > battlepool1 + battlepool2) {
				// Soldiers to be pulled out of battlepool3
				battlePool3 = totalBattlePool - tollHire[tollPosition];
				battlepool1 = battlepool2 = 0;
			} else if (tollHire[tollPosition] > battlepool1) {
				battlepool2 = (battlepool1 + battlepool2) - tollHire[tollPosition];
				battlepool1 = 0;
			}
			dfs(tollPosition + 1, 0, battlePool3, battlepool2, currentCost);
			// Note : pool3 is zero, pool3 becomes pool2 and pool2 as pool1
		}
	}

}
