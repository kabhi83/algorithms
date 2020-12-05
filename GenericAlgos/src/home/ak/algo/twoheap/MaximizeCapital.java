/**
 * 
 */
package home.ak.algo.twoheap;

import java.util.*;

/**
 * @author kundu
 * 
 *         Given a set of investment projects with their respective profits, we
 *         need to find the most profitable projects. We are given an initial
 *         capital and are allowed to invest only in a fixed number of projects.
 *         Our goal is to choose projects that give us the maximum profit. Write
 *         a function that returns the maximum total capital after selecting the
 *         most profitable projects.
 * 
 *         We can start an investment project only when we have the required
 *         capital. Once a project is selected, we can assume that its profit
 *         has become our capital.
 * 
 *         Input: numberOfProjects=2, initialCapital=0, profits=[1,2,3],
 *         capital=[0,1,1].
 * 
 *         Output: 4
 * 
 *         Explanation: Since your initial capital is 0, you can only start the
 *         project indexed 0. After finishing it you will obtain profit 1 and
 *         your capital becomes 1. With capital 1, you can either start the
 *         project indexed 1 or the project indexed 2. Since you can choose at
 *         most 2 projects, you need to finish the project indexed 2 to get the
 *         maximum capital. Therefore, output the final maximized capital, which
 *         is 0 + 1 + 3 = 4.
 *
 */
public class MaximizeCapital {

	static class Project {
		int profit;
		int capital;

		Project(int profit, int capital) {
			this.profit = profit;
			this.capital = capital;
		}
	}

	public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
		int n = profits.length;
		PriorityQueue<Project> minCapitalHeap = new PriorityQueue<>((a, b) -> a.capital - b.capital);
		PriorityQueue<Project> maxProfitHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);

		// insert the capitals in the min heap
		for (int i = 0; i < capital.length; i++) {
			minCapitalHeap.offer(new Project(profits[i], capital[i]));
		}

		// Find the best projects which can be completed with the initial capacity
		int availableCapital = initialCapital;

		// Add the projects which can be completed with the available capital, then pick
		// the max profit one
		for (int i = 0; i < numberOfProjects; i++) {
			while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital <= availableCapital) {
				// Add the project profit to maxHeap
				maxProfitHeap.add(minCapitalHeap.poll());
			}

			// No projects selected
			if (maxProfitHeap.isEmpty()) {
				break;
			}

			// select the project with the maximum profit
			availableCapital += maxProfitHeap.poll().profit;
		}

		return availableCapital;
	}

	public static void main(String[] args) {
		int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
		System.out.println("Maximum capital: " + result);
		result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
		System.out.println("Maximum capital: " + result);
	}
}
