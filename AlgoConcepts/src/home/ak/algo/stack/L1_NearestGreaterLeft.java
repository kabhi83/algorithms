/**
 * 
 */
package home.ak.algo.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author kundu
 *
 */
public class L1_NearestGreaterLeft {
	
	public static List<Integer> nearestGreaterElementLeft(int[] arr){
		if(arr.length == 0) {
			return null;
		}
		
		List<Integer> ngeList = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < arr.length; i++) {
			if(stack.isEmpty()) {
				ngeList.add(-1);
			} else if(stack.peek() > arr[i]) {
				ngeList.add(stack.peek());
			} else {
				while(!stack.isEmpty() && stack.peek() < arr[i]) {
					//Keep popping from stack
					stack.pop();
				}
				//Check if stack has become empty - then no greatest element
				if(stack.isEmpty()) {
					ngeList.add(-1);
				} else {
					ngeList.add(stack.peek());
				}
			}
			
			//Finally push the current element to stack
			stack.add(arr[i]);
		}
		return ngeList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 4 };
		List<Integer> list = nearestGreaterElementLeft(arr);
		for (int val : list) {
			System.out.print(val + " ");
		}

	}

}
