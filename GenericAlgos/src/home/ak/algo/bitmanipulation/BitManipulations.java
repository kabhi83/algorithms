/**
 * 
 */
package home.ak.algo.bitmanipulation;

/**
 * @author kundu
 *
 */
public class BitManipulations {

	/**
	 * Set the bit at the given position to 1
	 */
	public static int setBit(int x, int position) {
		// Create a mask - 1 is already in the 0th position
		int mask = 1 << position;
		// Perform Bitwise OR
		return x | mask;
	}

	/**
	 * Set the bit at the given position to 0
	 */
	public static int clearBit(int x, int position) {
		// Create a mask
		int mask = 1 << position;

		// Perform Bitwise AND with the 1's complement of the mask
		return x & ~mask;
	}

	/**
	 * Flip a bit at the given position 0 -> 1 or 1 -> 0
	 */
	public static int flipBit(int x, int position) {
		int mask = 1 << position;
		return x ^ mask; // For XOR, 1^1 and 0^0 is 0
	}
	
	//Check if the bit is set or not
	public static int isBitSet(int x, int position) {
		//Shift the bit to check to the right by the positions
		int shifted = x >> position;
		return shifted & 1; //Bitwise AND
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Set Bit: " + setBit(6, 5));

		System.out.println("Clear Bit: " + clearBit(6, 2));
		
		System.out.println("Flip Bit: "+ flipBit(102, 2));
		
		System.out.println("Is Bit Set: "+ isBitSet(102, 2));
	}

}
