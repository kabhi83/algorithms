/**
 * 
 */
package home.ak.algo.trie;

/**
 * @author kundu
 * 
 *         A node in a Trie represents a letter in an alphabet.
 *
 */
public class Trie {
	static class TrieNode {

		TrieNode[] children;
		boolean isEndOfWord;
		final static Integer ALPHABET_SIZE = 26;

		public TrieNode() {
			this.children = new TrieNode[ALPHABET_SIZE];
			isEndOfWord = false;
		}

		// Function to mark the currentNode as Leaf
		public void markAsLeaf() {
			this.isEndOfWord = true;
		}

		// Function to unMark the currentNode as Leaf
		public void unMarkAsLeaf() {
			this.isEndOfWord = false;
		}
	}

	private TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	// Function to get the index of a character 't'
	public int getIndex(char t) {
		return t - 'a';
	}

	// Function to insert a key,value pair in the Trie
	public void insert(String key, int value) {
	}

	// Function to search given key in Trie
	public boolean search(String key) {
		return false;
	}

	// Function to delete given key from Trie
	public boolean delete(String key) {
		return false;
	}

}
