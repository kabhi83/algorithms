/**
 * 
 */
package home.ak.algo.generic;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Count the number of prime numbers less than a non-negative number, n.
 * 
 *         Example 1: Input: n = 10 Output: 4 Explanation: There are 4 prime
 *         numbers less than 10, they are 2, 3, 5, 7.
 * 
 *         Example 2: Input: n = 0 Output: 0
 *
 */
public class CountPrimes {

	/**
	 * Sieve of Eratosthenes - For a given upper limit n the algorithm works by
	 * iteratively marking the multiples of primes as composite, starting from 2.
	 * Once all multiples of 2 have been marked composite, the multiples of next
	 * prime, ie 3 are marked composite. This process continues until p <= SQRT(n)
	 * where p is the prime number
	 * 
	 */
	public int countPrimes(int n) {
		if (n <= 1)
			return 0;

		boolean[] primes = new boolean[n];
		// Let's start by considering all numbers as prime
		Arrays.fill(primes, true);

		for (int i = 2; i * i < n; i++) {
			if (primes[i]) {
				for (int j = i; j * i < n; j++) {
					// Make all multiples of i to false
					primes[i * j] = false;
				}
			}
		}

		int primeCount = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i]) {
				primeCount++;
			}
		}

		return primeCount;
	}

	// Traditional way to find primes - n^2 complexity to count the number of primes
	// numbers for a given value of n
	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;

		if (n == 2)
			return true;

		// Check for the others - only the odds
		for (int i = 3; i < Math.sqrt(n); i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
