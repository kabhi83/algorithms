/**
 * 
 */
package home.ak.algo.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kundu
 * 
 *         Given an array of size n that has the following specifications:
 * 
 *         1. Each element in the array contains either a policeman or a thief.
 * 
 *         2. Each policeman can catch only one thief.
 * 
 *         3. A policeman cannot catch a thief who is more than K units away
 *         from the policeman.
 * 
 *         We need to find the maximum number of thieves that can be caught.
 * 
 *         Ex: Input : arr[] = {'P', 'T', 'T', 'P', 'T'}, k = 1. Output : 2.
 *         Here maximum 2 thieves can be caught, first policeman catches first
 *         thief and second police- man can catch either second or third thief.
 *
 */
public class PolicemanThiefProblem {

	public static int catchMaxThief(char[] arr, int k) {

		// capture the index of policeman and thief
		List<Integer> thiefIdx = new ArrayList<>();
		List<Integer> policeIdx = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'P') {
				policeIdx.add(i);
			} else {
				thiefIdx.add(i);
			}
		}

		// Get the absolute distance between police and thief
		int p = 0, t = 0;
		int thiefCount = 0;
		while (p < policeIdx.size() && t < thiefIdx.size()) {
			if (Math.abs(policeIdx.get(p) - thiefIdx.get(t)) <= k) {
				thiefCount += 1;
				p++;
				t++;
			} else if (thiefIdx.get(t) < policeIdx.get(p)) { // increment the minimum index
				t++;
			} else {
				p++;
			}
		}
		return thiefCount;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// char[] arr = {'P', 'T', 'T', 'P', 'T'};
		// int k = 1;
		char[] arr = { 'T', 'T', 'P', 'P', 'T', 'P' };
		int k = 2;
		System.out.println(catchMaxThief(arr, k));
	}

}
