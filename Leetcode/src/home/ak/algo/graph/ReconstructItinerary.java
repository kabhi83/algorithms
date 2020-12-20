/**
 * 
 */
package home.ak.algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         Given a list of airline tickets represented by pairs of departure and
 *         arrival airports [from, to], reconstruct the itinerary in order. All
 *         of the tickets belong to a man who departs from JFK. Thus, the
 *         itinerary must begin with JFK.
 * 
 *         Note:
 * 
 *         If there are multiple valid itineraries, you should return the
 *         itinerary that has the smallest lexical order when read as a single
 *         string. For example, the itinerary ["JFK", "LGA"] has a smaller
 *         lexical order than ["JFK", "LGB"]. All airports are represented by
 *         three capital letters (IATA code). You may assume all tickets form at
 *         least one valid itinerary. One must use all the tickets once and only
 *         once.
 * 
 *         Example 1: Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"],
 *         ["LHR", "SFO"]] Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 
 *         Example 2: Input:
 *         [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 *         Output: ["JFK","ATL","JFK","SFO","ATL","SFO"] Explanation: Another
 *         possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But
 *         it is larger in lexical order.
 *
 */
public class ReconstructItinerary {

	public List<String> findItinerary(List<List<String>> tickets) {

		if (null == tickets) {
			return null;
		}

		// Build the graph using a map of origin and list of destinations possible
		// using PriorityQueue for lexicographical sorting
		Map<String, PriorityQueue<String>> destMap = new HashMap<>();

		// Create the result list
		LinkedList<String> resultList = new LinkedList<>();

		for (List<String> ticket : tickets) {
			if (!destMap.containsKey(ticket.get(0))) {
				PriorityQueue<String> dest = new PriorityQueue<>();
				destMap.put(ticket.get(0), dest);
			}
			destMap.get(ticket.get(0)).offer(ticket.get(1));
		}

		dfs("JFK", destMap, resultList);

		return resultList;

	}

	private void dfs(String from, Map<String, PriorityQueue<String>> destMap, LinkedList<String> resultList) {
		PriorityQueue<String> arrivals = destMap.get(from);
		while (null != arrivals && !arrivals.isEmpty()) {
			dfs(arrivals.poll(), destMap, resultList);
		}
		resultList.addFirst(from);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
		List<String> list1 = new ArrayList<String>(Arrays.asList("JFK", "SFO"));
		List<String> list2 = new ArrayList<String>(Arrays.asList("JFK", "ATL"));
		List<String> list3 = new ArrayList<String>(Arrays.asList("SFO", "ATL"));
		List<String> list4 = new ArrayList<String>(Arrays.asList("ATL", "JFK"));
		List<String> list5 = new ArrayList<String>(Arrays.asList("ATL", "SFO"));
		List<List<String>> tickets = new ArrayList<>();
		tickets.add(list1);
		tickets.add(list2);
		tickets.add(list3);
		tickets.add(list4);
		tickets.add(list5);
		
		List<String> itinerary = new ReconstructItinerary().findItinerary(tickets);
		System.out.println(itinerary);
	}

}
