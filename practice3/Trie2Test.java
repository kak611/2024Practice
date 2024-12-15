class Trie2Test {
	public static void main(String[] args) {
		Trie2 trie = new Trie2();

		System.out.println("contains 'apply'?: " + trie.containsWord("apply"));
		trie.addWord("app");
		trie.addWord("application");
		trie.addWord("apple");
		trie.addWord("bat");

		System.out.println("find words with 'ap':" + trie.getWords("ap"));
		trie.getWords("appl"); // should get empty
		
		trie.addWord("appl");
		trie.addWord("applocation");
		trie.addWord("apply");

		System.out.println("###START##");

		System.out.println("find words with 'appl':" + trie.getWords("appl"));
		System.out.println("###END##");

		System.out.println("contains 'apply'?: " + trie.containsWord("apply"));
	}
}