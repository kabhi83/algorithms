/**
 * 
 */
package home.ak.algo.dp.oneDim;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         You are given a set of n types of rectangular 3-D boxes, where the
 *         ith box has height h(i), width w(i) and depth d(i) (all real
 *         numbers). You want to create a stack of boxes which is as tall as
 *         possible, but you can only stack a box on top of another box if the
 *         dimensions of the 2-D base of the lower box are each strictly larger
 *         than those of the 2-D base of the higher box. Of course, you can
 *         rotate a box so that any side functions as its base. It is also
 *         allowable to use multiple instances of the same type of box.
 * 
 *         Hint: Since we have n boxes, we should concentrate about box
 *         rotations since we each rotation will create more possibilities for
 *         making stack, remember we have unlimited number of boxes.
 * 
 *         State: area of the 2D base
 *
 */
public class BoxStackingProblem {

	static class Box {
		int length;
		int width;
		int height;

		public Box(int length, int width, int height) {
			this.length = length;
			this.width = width;
			this.height = height;
		}

		public Box() {
		}

		/**
		 * Biggest size should be length and the smaller one is width
		 */
		static Box createBox(int height, int side1, int side2) {
			Box box = new Box();
			box.height = height;
			if (side1 >= side2) {
				box.length = side1;
				box.width = side2;
			} else {
				box.length = side2;
				box.width = side1;
			}
			return box;
		}
	}

	public static int maxHeight(int[][] boxes) {
		// Though we have unlimited supply of boxes, only 3 unique possibilities will
		// have different base area. Hence genrate all the possible combinations
		Box[] box = new Box[boxes.length * 3]; // 3 possibilities per box
		for (int i = 0; i < boxes.length; i++) {
			int l = boxes[i][0];
			int w = boxes[i][1];
			int h = boxes[i][2];
			box[i * 3] = Box.createBox(l, w, h);
			box[i * 3 + 1] = Box.createBox(h, l, w);
			box[i * 3 + 2] = Box.createBox(w, h, l);
		}

		// Sort the box in descending order of the base area
		Arrays.sort(box, (a, b) -> (b.length * b.width) - (a.length * a.width));

		System.out.println("All possible combination of boxes after rotation");
		for (int i = 0; i < box.length; i++) {
			System.out.println(box[i].length + " " + box[i].width + " " + box[i].height);
		}

		// Apply longest increasing subsequence kind of algorithm on these sorted boxes.
		int dp[] = new int[box.length]; // for all combinations
		// fill with the default heights
		for (int i = 0; i < box.length; i++) {
			dp[i] = box[i].height;
		}

		// Check if the ith box can go on top of jth box
		int max = 0;
		for (int i = 1; i < box.length; i++) {
			for (int j = 0; j < i; j++) {
				if (box[j].length > box[i].length && box[j].width > box[i].width) {
					// Then only we can place the ith box on top of jth box; hence the height will
					// add up
					dp[i] = Math.max(dp[i], box[i].height + dp[j]);
					max = Math.max(max, dp[i]);
				}
			}
		}

		return dp[box.length - 1];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] boxes = { { 4, 7, 9 }, { 5, 8, 9 }, { 11, 20, 40 }, { 1, 2, 3 } };
		// int[][] boxes = { { 3, 2, 5 }, { 1, 2, 4 } };
		System.out.println(maxHeight(boxes));

	}

}
