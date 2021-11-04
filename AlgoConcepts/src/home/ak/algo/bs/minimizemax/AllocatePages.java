package home.ak.algo.bs.minimizemax;

import java.util.Arrays;

/**
 * @author kundu
 * 
 *         Given number of pages in n different books and m students. The books
 *         are arranged in ascending order of number of pages. Every student is
 *         assigned to read some consecutive books. The task is to assign books
 *         in such a way that the maximum number of pages assigned to a student
 *         is minimum.
 * 
 *         Example: Input pages[] = {10, 20, 30, 40} and m = 2, Output = 60
 *         Explanation: The maximum page a student need to read is 60
 *
 */
public class AllocatePages {

	public static int findMaxPages(int[] pages, int m) {
		// A student need to read minimum 1 book. So, if s1 = 10 and s2 = 20,30,40
		// Or we can also consider s1 = 10, 20, 30 and s2 = 40 (optimal)
		int start = pages[pages.length - 1];
		int end = Arrays.stream(pages).sum(); // Maximum possible pages is the sum of all pages

		int res = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2; // Maximum pages

			if (isValid(pages, mid, m)) {
				// Now we have to minimize the maximum pages
				res = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		return res;

	}

	private static boolean isValid(int[] pages, int maxpages, int m) {
		// Count the no. of students to read the pages with the allowed max pages
		int noOfStudent = 1;
		int allocatedPages = 0;
		for (int page : pages) {
			allocatedPages += page;
			if (allocatedPages > maxpages) {
				// Increment the student count and allocate the new pages to him
				noOfStudent++;
				allocatedPages = page;
			}
			// Check if students exceeds the permissible count
			if (noOfStudent > m) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] pages = { 10, 20, 30, 40 };
		int students = 2;
		System.out.println(findMaxPages(pages, students));

		pages = new int[] { 12, 34, 67, 90 };
		students = 2;
		System.out.println(findMaxPages(pages, students));
	}

}
