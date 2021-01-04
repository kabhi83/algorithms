/**
 * 
 */
package home.ak.algo.greedy;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given weights and values of n items, a thief need to put these items
 *         in a knapsack of capacity W to get the maximum total value in the
 *         knapsack. In this case, items can be broken into smaller pieces,
 *         hence the thief can select fractions of items.
 *
 */
public class FractionalKnapsackProblem {

	static class Item {
		int weight;
		int value;
		Double cost;

		public Item(int weight, int value) {
			this.weight = weight;
			this.value = value;
			this.cost = Double.valueOf((double) value / (double) weight);
		}

	}

	public static double getMaxValue(int[] wt, int[] val, int capacity) {
		// Build the item array
		int n = wt.length;
		Item[] items = new Item[n];
		for (int i = 0; i < n; i++) {
			items[i] = new Item(wt[i], val[i]);
		}

		// Sort the array in the descending value of the cost
		Arrays.sort(items, (a, b) -> (b.cost.compareTo(a.cost)));
		double maxValue = 0.0;

		for (Item item : items) {
			int currWt = item.weight;
			int currVal = item.value;
			if (capacity >= currWt) {
				// Whole item can be included
				maxValue += currVal;
				capacity -= currWt;
			} else {
				// item can't be picked whole
				double fraction = ((double) capacity / (double) currWt);
				maxValue += (currVal * fraction);
				capacity = (int) (capacity - (currWt * fraction));
				break; // Since this will be the last item in knapsack
			}
		}
		return maxValue;
	}

	public static void main(String[] args) {
		int[] wt = { 10, 40, 20, 30 };
		int[] val = { 60, 40, 100, 120 };
		int capacity = 50;

		double maxValue = getMaxValue(wt, val, capacity);
		System.out.println("Maximum value we can obtain = " + maxValue);
	}
}
