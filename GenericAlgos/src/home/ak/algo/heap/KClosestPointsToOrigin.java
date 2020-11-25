/**
 * 
 */
package home.ak.algo.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         Given an array of points in the a 2D2D plane, find ‘K’ closest points
 *         to the origin.
 * 
 *         The Euclidean distance of a point P(x,y) from the origin can be
 *         calculated through the following formula:
 * 
 *         distance = sqrt(x^2 + y^2)
 * 
 *         Example 1: Input: points = [[1,2],[1,3]], K = 1 Output: [[1,2]]
 *         Explanation: The Euclidean distance between (1, 2) and the origin is
 *         sqrt(5). The Euclidean distance between (1, 3) and the origin is
 *         sqrt(10). Since sqrt(5) < sqrt(10), therefore (1, 2) is closer to the
 *         origin.
 * 
 *         Example 2: Input: point = [[1, 3], [3, 4], [2, -1]], K = 2 Output:
 *         [[1, 3], [2, -1]]
 *
 */
public class KClosestPointsToOrigin {

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int distFromOrigin() {
			// ignoring sqrt
			return (x * x) + (y * y);
		}
	}

	public static List<Point> findClosestPoints(Point[] points, int k) {
		PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());
		for (Point point : points) {
			maxHeap.offer(point);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		return new ArrayList<Point>(maxHeap);
	}

	public static void main(String[] args) {
		Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
		List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
		System.out.print("Here are the k points closest the origin: ");
		for (Point p : result)
			System.out.print("[" + p.x + " , " + p.y + "] ");
	}

	/*
	 * Time complexity # The time complexity of this algorithm is (N*logK) as we
	 * iterating all points and pushing them into the heap.
	 * 
	 * Space complexity # The space complexity will be O(K) because we need to store
	 * ‘K’ point in the heap.
	 */

}
