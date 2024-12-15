class TrieTest {
	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.addWord("one");
		trie.addWord("bat");
		trie.addWord("ball");
		trie.addWord("apple");
		trie.addWord("application");
		trie.addWord("App");

		System.out.println(trie.getWords("ap"));
		System.out.println("contains 'ab'? : " + trie.containsWord("ab"));
		System.out.println("contains 'ball'? : " + trie.containsWord("ball"));
	}
}