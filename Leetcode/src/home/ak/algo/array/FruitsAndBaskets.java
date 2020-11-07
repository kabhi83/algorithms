/**
 * 
 */
package home.ak.algo.array;

/**
 * @author kundu
 * 
 *         In a row of trees, the i-th tree produces fruit with type tree[i].
 * 
 *         You start at any tree of your choice, then repeatedly perform the
 *         following steps:
 * 
 *         Add one piece of fruit from this tree to your baskets. If you cannot,
 *         stop. Move to the next tree to the right of the current tree. If
 *         there is no tree to the right, stop. Note that you do not have any
 *         choice after the initial choice of starting tree: you must perform
 *         step 1, then step 2, then back to step 1, then step 2, and so on
 *         until you stop.
 * 
 *         You have two baskets, and each basket can carry any quantity of
 *         fruit, but you want each basket to only carry one type of fruit each.
 * 
 *         What is the total amount of fruit you can collect with this
 *         procedure?
 * 
 *         Example 1:Input: [1,2,1] Output: 3 Explanation: We can collect
 *         [1,2,1].
 * 
 *         Example2: Input: [0,1,2,2] Output: 3 Explanation: We can collect
 *         [1,2,2]. If we started at the first tree, we would only collect [0,
 *         1].
 *
 */
public class FruitsAndBaskets {

	/**
	 * Sliding window problem - contiguous sub-array with two possible values
	 */
	public int totalFruit(int[] tree) {
		if (null == tree || tree.length == 0) {
			return 0;
		}
		int lastFruit = -1;
		int secondLastFruit = -1;
		int lastFruitCount = 0;
		int max = 0, currentMax = 0;
		for (Integer fruit : tree) {
			// 1st case: same last & second last fruit
			if (fruit == lastFruit || fruit == secondLastFruit) {
				currentMax++;
			} else {
				// Encountered a new fruit
				currentMax = lastFruitCount + 1;
			}

			// If last fruit - [1, 1, 1]
			if (fruit == lastFruit) {
				lastFruitCount++;
			} else {
				lastFruitCount = 1; // Reset the count
				secondLastFruit = lastFruit;
				lastFruit = fruit;
			}
			max = Math.max(max, currentMax);
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] tree = { 0, 1, 2, 2 };
		int[] tree = { 1, 2, 3, 2, 2 };
		int result = new FruitsAndBaskets().totalFruit(tree);
		System.out.println(result);
	}

}
