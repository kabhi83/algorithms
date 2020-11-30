/**
 * 
 */
package home.ak.algo.generic;

/**
 * @author kundu
 * 
 *         Given n non-negative integers a1, a2, ..., an , where each represents
 *         a point at coordinate (i, ai). n vertical lines are drawn such that
 *         the two endpoints of the line i is at (i, ai) and (i, 0). Find two
 *         lines, which, together with the x-axis forms a container, such that
 *         the container contains the most water.
 * 
 *         Notice that you may not slant the container.
 * 
 *         Example: Input: height = [1,8,6,2,5,4,8,3,7] Output: 49 Explanation:
 *         The above vertical lines are represented by array
 *         [1,8,6,2,5,4,8,3,7]. In this case, the max area of water is between
 *         the height 8 and 7. MIN(8, 7) * (i -j) = 7 * 7
 * 
 *         Hint: The aim is to maximize the area formed between the vertical
 *         lines. The area of any container is calculated using the shorter line
 *         as length and the distance between the lines as the width of the
 *         rectangle. Area = length of shorter vertical line * distance between
 *         lines
 *
 */
public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
			}
		}
		return max;
	}

	/**
	 * One pass solution
	 */
	public int maxAreaOptimized(int[] height) {
		int max = 0;
		int i = 0, j = height.length - 1;
		while (i < j) {
			max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int result = new ContainerWithMostWater().maxArea(height);
		System.out.println(result);
		result = new ContainerWithMostWater().maxAreaOptimized(height);
		System.out.println(result);
	}

}
