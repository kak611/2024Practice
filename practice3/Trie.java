import java.util.*;

class Trie {

	TrieNode root;

	public Trie() {
		this.root = new TrieNode();
	}

	public void addWord(String word) {
		if (word == null || word.length() == 0) return;

		root.addWord(word.toLowerCase());
	}

	public List<String> getWords(String prefix) {
		TrieNode node = root;
		for (int i = 0; i < prefix.length(); i++) {
			node = node.getNode(Character.toLowerCase(prefix.charAt(i)));
			if (node == null) return new ArrayList<String>();
		}
		return node.getWords();
	}

	public boolean containsWord(String word) {
		if (word == null || word.length() == 0) return false;

		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			node = node.getNode(Character.toLowerCase(ch));
			if (node == null) return false;
		}

		return node.isWord;
	}

	class TrieNode {
		TrieNode parent;
		char c;
		HashMap<Character, TrieNode> children;
		boolean isWord;
		boolean isLeaf;
	
		public TrieNode() {
			children = new HashMap<>();
			isWord = false;
			isLeaf = true;
		}

		public TrieNode(char c) {
			this();
			this.c = c;
		}

		public boolean isLeaf() {
			return children.isEmpty();
		}

		public TrieNode getNode(char ch) {
			return children.get(ch);
		}

		public void addWord(String word) {
			if (word == null || word.length() == 0) return;

			char ch = word.charAt(0);
			if (!children.containsKey(ch)) {
				children.put(ch, new TrieNode(ch));
				children.get(ch).parent = this;
				isLeaf = false;
			}
			if (word.length() > 1) {
				children.get(ch).addWord(word.substring(1));
			} else {
				children.get(ch).isWord = true;
			}
		}

		public List<String> getWords() {
            List<String> result = new ArrayList<>();
            if (this.isWord) {
                result.add(toString());
            }
            for (TrieNode child : children.values()) {
                result.addAll(child.getWords());
            }
            return result;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            TrieNode current = this;
            while (current != null && current.parent != null) {
                sb.insert(0, current.c);
                current = current.parent;
            }
            return sb.toString();
        }

	}

}