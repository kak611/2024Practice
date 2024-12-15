import java.util.*;

class Trie2 {
	TrieNode root;

	public Trie2() {
		root = new TrieNode('\0');
	}

	// addWord(word)
	public void addWord(String word) {
		if (word == null || word.length() == 0) return;
		root.insertWord(word);
	}

	// getWords(prefix)
	public List<String> getWords(String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return new ArrayList<String>();
		}

		// Step1: Check if prefix exists in Trie
		TrieNode curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			curr = curr.children.get(prefix.charAt(i));
			System.out.println("??? " + curr.character + ", prefixcharAt: " + prefix.charAt(i));
			if (curr == null) return new ArrayList<>();
		}
		System.out.println(">>>> " + curr.character + ", prefix: " + prefix);
		// Step2: If exists, find all words from last 'char'
		return curr.search();
	}

	// containsWord(word)
	public boolean containsWord(String word) {
		if (word == null || word.length() == 0) {
			return false;
		}

		TrieNode curr = root;

		for (int i = 0; i < word.length(); i++) {
			curr = curr.children.get(word.charAt(i));
			if (curr == null) {
				return false;
			}
		}
		return curr.isWord;
	}

	class TrieNode {
		TrieNode parent;
		char character;
		boolean isWord;
		boolean isLeaf;
		Map<Character, TrieNode> children;

		public TrieNode(char character) {
			this.character = character;
			this.isWord = false;
			this.isLeaf = true;
			children = new HashMap();
		}

		public boolean isLeaf() {
			return this.children.size() == 0;
		}

		public void insertWord(String word) {
			if (word == null || word.length() == 0) {
				System.out.println("Word is invalid!");
				return;
			}

			// Step1: check if children contains first char
			//  	if not, add in children (map)
			//		if yes, then move to next char and call  insertWord()
			char ch = word.charAt(0);
			if (!children.containsKey(ch)) {
				children.put(ch, new TrieNode(ch));
				children.get(ch).parent = this;
			}

			if (word.length() > 1) {
				children.get(ch).insertWord(word.substring(1));
			} else {
				children.get(ch).isWord = true;
			}
		}

		public List<String> search() {
			List<String> result = new ArrayList<>();
			if (this.isWord) {
				System.out.println("**this.char*** " + this.character);
				result.add(this.toString());
			}

			for (TrieNode child: children.values()) {
				result.addAll(child.search());
			}

			return result;
		}

		public String toString() {
			StringBuilder strb = new StringBuilder();
			TrieNode curr = this;
            while (curr != null && curr.parent != null) {
				strb.insert(0, curr.character);
				curr = curr.parent;
			}

			return strb.toString();
		}
	}
}