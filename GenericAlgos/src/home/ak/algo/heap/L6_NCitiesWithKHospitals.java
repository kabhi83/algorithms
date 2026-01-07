/**
 * 
 */
package home.ak.algo.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author kundu
 * 
 *         Given n cities with the population array depicting the population of
 *         each city and k hospitals to be built such that k > n. Built k
 *         hospitals in n cities such that the maximum load on an hospital is
 *         minimized, where load = population/hospitals
 *
 */
public class L6_NCitiesWithKHospitals {

	static class City {
		int id;
		int population;
		double load;
		int hospitals;

		public City(int id, int population, double load, int hospitals) {
			this.id = id;
			this.population = population;
			this.load = load;
			this.hospitals = hospitals;
		}
	}

	public static Map<Integer, Integer> placeHospitals(int[] population, int n, int k) {

		// Number of cities should be less than the number of hospitals
		if (n > k) {
			return null;
		}

		// Sorting priority queue by load value - Descending order
		PriorityQueue<City> queue = new PriorityQueue<>((a, b) -> {
			if (a.load < b.load) {
				return 1;
			} else if (b.load < a.load) {
				return -1;
			}
			return 0;
		});

		// Initialize the priority queue by assigning 1 hospital to each city first
		int remainingHospitals = k;
		for (int i = 0; i < n; i++) {
			queue.offer(new City(i, population[i], population[i], 1));
			remainingHospitals--;
		}

		// Assign the remaining hospitals based on highest population
		while (remainingHospitals > 0) {
			City populatedCityHospital = queue.poll();
			int updatedHospitalCount = populatedCityHospital.hospitals + 1;
			double adjustedLoad = (populatedCityHospital.population) / updatedHospitalCount;
			// Insert back the value
			queue.offer(new City(populatedCityHospital.id, populatedCityHospital.population, adjustedLoad,
					updatedHospitalCount));
			remainingHospitals--;
		}

		Map<Integer, Integer> hospitalPopulationMap = new HashMap<>();
		while (!queue.isEmpty()) {
			City city = queue.poll();
			hospitalPopulationMap.put(city.id, city.hospitals);
		}
		return hospitalPopulationMap;
	}

	public static void main(String[] args) {
		int[] population = { 20000, 50000 };
		Map<Integer, Integer> map = placeHospitals(population, population.length, 6);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

}
