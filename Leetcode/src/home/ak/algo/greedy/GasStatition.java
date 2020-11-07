/**
 * 
 */
package home.ak.algo.greedy;

/**
 * @author kundu
 * 
 *         There are N gas stations along a circular route, where the amount of
 *         gas at station i is gas[i].
 * 
 *         You have a car with an unlimited gas tank and it costs cost[i] of gas
 *         to travel from station i to its next station (i+1). You begin the
 *         journey with an empty tank at one of the gas stations.
 * 
 *         Return the starting gas station's index if you can travel around the
 *         circuit once in the clockwise direction, otherwise return -1.
 * 
 *         Note:
 * 
 *         If there exists a solution, it is guaranteed to be unique. Both input
 *         arrays are non-empty and have the same length. Each element in the
 *         input arrays is a non-negative integer.
 *
 */
public class GasStatition {

	/**
	 * Consider the problem with two variables - surplus(s) and deficit(d) for all
	 * the points in the circular path. If s+d >=0, then only we can cover the
	 * entire path
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int surplus = 0, start = 0, deficit = 0;

		for (int i = 0; i < gas.length; i++) {
			surplus = surplus + gas[i] - cost[i];
			if (surplus < 0) {
				start = i + 1;
				deficit += surplus;
				surplus = 0;
			}
		}
		// If sum + diff < 0, there is no valid starting point
		return (surplus + deficit) >= 0 ? start : -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] gas = { 1, 2, 3, 4, 5 }, cost = { 3, 4, 5, 1, 2 };
		//int[] gas = { 2, 3, 4 }, cost = { 3, 4, 3 };
		//int[] gas = {1,2 ,3, 4, 5}, cost = {3,4,5,1,2};
		int startPoint = new GasStatition().canCompleteCircuit(gas, cost);
		System.out.println(startPoint);
	}

}
