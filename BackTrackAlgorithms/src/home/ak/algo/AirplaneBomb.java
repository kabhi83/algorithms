/**
 * 
 */
package home.ak.algo;

import java.util.Scanner;

/**
 * User is allowed to move either right or left in one move. User can apply bomb
 * only once. Once applied all enemies in 5*5 matrix will be eliminated
 */
public class AirplaneBomb {
	static int maxCoins;
	static int N;
	static int[][] originalArr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 0; testCase < T; testCase++) {
			maxCoins = -1;
			N = sc.nextInt();
			originalArr = new int[N][5];
			int[][] arr = new int[N][5];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 5; j++) {
					originalArr[i][j] = sc.nextInt();
					arr[i][j] = originalArr[i][j];
				}
			}
			// Initial position is between
			calculateMaxCoins(arr, N, 2, 0, false);
			System.out.println("#" + (testCase + 1) + " " + maxCoins);
		}
	}

	public static void calculateMaxCoins(int[][] arr, int ht, int y, int coins, boolean blasted) {
		// Exit Criteria
		if (ht == 0 || coins == -1) {
			if (coins > maxCoins) {
				maxCoins = coins;
			}
			return;
		}

		// Check for right movement
		if (ht - 1 > -1 && y + 1 < 5) {
			if (arr[ht - 1][y + 1] == 1) {// encountered a coin
				calculateMaxCoins(arr, ht - 1, y + 1, coins + 1, blasted);
			} else if (arr[ht - 1][y + 1] == 2) { // encountered an enemy
				if (!blasted) {
					blasted = true;
					for (int i = ht - 1, cnt = 0; i > -1 && cnt < 5; i--, cnt++) {
						for (int j = 0; j < 5; j++) {
							if (arr[i][j] == 2) {
								arr[i][j] = 0;
							}
						}
					}
					calculateMaxCoins(arr, ht - 1, y + 1, coins, blasted);
					// Restore back
					blasted = false;
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < 5; j++) {
							arr[i][j] = originalArr[i][j];
						}
					}
				}
				// for no blast
				calculateMaxCoins(arr, ht - 1, y + 1, coins - 1, blasted);
			} else { // encountered 0
				calculateMaxCoins(arr, ht - 1, y + 1, coins, blasted);
			}
		}

		// Check for left movement
		if (ht - 1 > -1 && y - 1 >= 0) {
			if (arr[ht - 1][y - 1] == 1) {// encountered a coin
				calculateMaxCoins(arr, ht - 1, y - 1, coins + 1, blasted);
			} else if (arr[ht - 1][y + 1] == 2) { // encountered an enemy
				if (!blasted) {
					blasted = true;
					for (int i = ht - 1, cnt = 0; i > -1 && cnt < 5; i--, cnt++) {
						for (int j = 0; j < 5; j++) {
							if (arr[i][j] == 2) {
								arr[i][j] = 0;
							}
						}
					}
					calculateMaxCoins(arr, ht - 1, y - 1, coins, blasted);
					// Restore back
					blasted = false;
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < 5; j++) {
							arr[i][j] = originalArr[i][j];
						}
					}
				}
				// for no blast
				calculateMaxCoins(arr, ht - 1, y - 1, coins - 1, blasted);
			} else { // encountered 0
				calculateMaxCoins(arr, ht - 1, y - 1, coins, blasted);
			}
		}

		// Check from current location
		if (ht - 1 > -1) {
			if (arr[ht - 1][y] == 1) {// encountered a coin
				calculateMaxCoins(arr, ht - 1, y, coins + 1, blasted);
			} else if (arr[ht - 1][y] == 2) { // encountered an enemy
				if (!blasted) {
					blasted = true;
					for (int i = ht - 1, cnt = 0; i > -1 && cnt < 5; i--, cnt++) {
						for (int j = 0; j < 5; j++) {
							if (arr[i][j] == 2) {
								arr[i][j] = 0;
							}
						}
					}
					calculateMaxCoins(arr, ht - 1, y, coins, blasted);
					// Restore back
					blasted = false;
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < 5; j++) {
							arr[i][j] = originalArr[i][j];
						}
					}
				}
				// for no blast
				calculateMaxCoins(arr, ht - 1, y, coins - 1, blasted);
			} else { // encountered 0
				calculateMaxCoins(arr, ht - 1, y, coins, blasted);
			}
		}
	}
}
