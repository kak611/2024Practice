import java.util.List;

public class TrieTest {

    public static void main(String[] args) {
        Trie trie = new Trie();
        
        // Adding words to the trie
        trie.addWord("apple");
        trie.addWord("app");
        trie.addWord("bat");
        trie.addWord("ball");
        trie.addWord("batman");

        // Test 1: Get words with a given prefix
        System.out.println("Words with prefix 'app':");
        List<String> wordsWithPrefixApp = trie.getWords("app");
        for (String word : wordsWithPrefixApp) {
            System.out.println(word);
        }
        
        // Test 2: Get words with a given prefix
        System.out.println("\nWords with prefix 'ba':");
        List<String> wordsWithPrefixBa = trie.getWords("ba");
        for (String word : wordsWithPrefixBa) {
            System.out.println(word);
        }

        // Test 3: No matching prefix
        System.out.println("\nWords with prefix 'xyz':");
        List<String> wordsWithPrefixXyz = trie.getWords("xyz");
        for (String word : wordsWithPrefixXyz) {
            System.out.println(word);  // Should be an empty list
        }

        // Test 4: Adding and searching for single word
        System.out.println("\nWords with prefix 'bat':");
        List<String> wordsWithPrefixBat = trie.getWords("bat");
        for (String word : wordsWithPrefixBat) {
            System.out.println(word);
        }

        // Test 5: Checking edge case for empty input
        System.out.println("\nWords with prefix '':");
        List<String> wordsWithEmptyPrefix = trie.getWords("");
        for (String word : wordsWithEmptyPrefix) {
            System.out.println(word);  // Should return all words
        }
    }
}