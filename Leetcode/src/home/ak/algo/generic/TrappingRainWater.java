/**
 * 
 */
package home.ak.algo.generic;

/**
 * @author user
 * 
 *         Given n non-negative integers representing an elevation map where the
 *         width of each bar is 1, compute how much water it can trap after
 *         raining.
 * 
 *         Formula: for each bar the amount of water stored can be found by
 * 
 *         [min(leftHighest, rightHighest) - bar height]
 *
 */
public class TrappingRainWater {

	public int trap(int[] height) {
		int totalAmount = 0;
		if (height == null || height.length == 0) {
			return totalAmount;
		}

		int[] leftHighest = new int[height.length + 1];
		leftHighest[0] = 0; // implicit
		for (int i = 0; i < height.length; i++) {
			leftHighest[i + 1] = Math.max(leftHighest[i], height[i]);
		}

		int rightHighest = 0;
		for (int i = height.length - 1; i >= 0; i--) {
			rightHighest = Math.max(rightHighest, height[i]);
			// Check if the current height is greater than the min value of
			// left highest and right highest
			totalAmount += Math.min(leftHighest[i], rightHighest) > height[i]
					? Math.min(leftHighest[i], rightHighest) - height[i] : 0;

		}
		return totalAmount;

		// time complexity O(n) and
		// space complexity O(n)
	}

	public static void main(String[] args) {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int totalAmount = new TrappingRainWater().trap(height);
		System.out.println(totalAmount);
	}

}
