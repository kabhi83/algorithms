/**
 * 
 */
package home.ak.algo.array;

/**
 * @author kundu
 * 
 *         Given n non-negative integers a1, a2, ..., an , where each represents
 *         a point at coordinate (i, ai). n vertical lines are drawn such that
 *         the two endpoints of the line i is at (i, ai) and (i, 0). Find two
 *         lines, which, together with the x-axis forms a container, such that
 *         the container contains the most water.
 * 
 *         You're given an array of positive integers where each interger
 *         represents the height of a vertical line on a chart. Find two lines
 *         which together with the x-axis forms a container that would hold the
 *         greatest amount of water. Return the area of the water it would hold.
 * 
 *         Hints - Two pointer method to solve while considering the width i.e.,
 *         the x-axis
 *
 */
public class ContainerWithMostWater {

	public static int maxArea(int[] height) {

		// Base case
		if (height.length == 0 || height.length == 1)
			return 0;

		// Initialize the pointers
		int p1 = 0, p2 = height.length - 1;

		int maxArea = 0, minHeight = -1;
		while (p1 < p2) {
			minHeight = Math.min(height[p1], height[p2]);
			int currentArea = minHeight * (p2 - p1);
			maxArea = Math.max(maxArea, currentArea);
			// Increment the pointer of the min-height in seach of max area
			if (height[p1] <= height[p2])
				p1++;
			else
				p2--;
		}

		return maxArea;
	}

	public static void main(String[] args) {
		// int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int[] height = { 4, 3, 2, 1, 4 };
		System.out.println(maxArea(height));
	}

}
