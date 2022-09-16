/**
 * 
 */
package home.ak.algo.twoheap;

import java.util.PriorityQueue;

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
 *         Example -
 * 
 *         Input: Project Capitals=[0,1,2,3], Project Profits=[1,2,3,5],
 * 
 *         Initial Capital=0, Number of Projects=3,
 * 
 *         Output: 8
 * 
 *         Explanation: With ‘0’ capital, we can only select the first project,
 *         bringing out capital to 1. Next, we will select the second project,
 *         which will bring our capital to 3. Next, we will select the fourth
 *         project, giving us a profit of 5. After selecting the three projects,
 *         our total capital will be 8 (1+2+5).
 *
 */
public class L03_MaximizeCapital {

	static class Project {
		int capital;
		int profit;

		public Project(int capital, int profit) {
			this.capital = capital;
			this.profit = profit;
		}
	}

	public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
		PriorityQueue<Project> minCapital = new PriorityQueue<>((a, b) -> a.capital - b.capital);
		PriorityQueue<Project> maxProfit = new PriorityQueue<>((a, b) -> b.profit - a.profit);

		for (int i = 0; i < capital.length; i++) {
			minCapital.add(new Project(capital[i], profits[i]));
		}

		int totalCapital = initialCapital;
		while (numberOfProjects > 0) {
			while (!minCapital.isEmpty() && totalCapital >= minCapital.peek().capital) {
				maxProfit.add(minCapital.poll());
			}

			// terminate if we are not able to find any project that can be completed within
			// the available capital
			if (maxProfit.isEmpty())
				break;

			int currProfit = maxProfit.poll().profit;
			totalCapital += currProfit;
			numberOfProjects--;
		}

		return totalCapital;
	}

	public static void main(String[] args) {
		int[] capital = { 0, 1, 2 };
		int[] profit = { 1, 2, 3 };
		int numberOfProject = 2, initialCapital = 1;
		System.out.println(findMaximumCapital(capital, profit, numberOfProject, initialCapital));

	}

}
