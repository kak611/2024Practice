import java.util.*;

class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        if (word == null || word.isEmpty()) return;
        root.addWord(word.toLowerCase());
    }

    public List<String> getWords(String prefix) {
        TrieNode node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            node = node.getNode(Character.toLowerCase(prefix.charAt(i)));
            if (node == null) return new ArrayList<>();
        }
        return node.getWords();
    }

    class TrieNode {
        private TrieNode parent;
        private char character;
        private Map<Character, TrieNode> children;
        private boolean isWord;

        public TrieNode() {
            children = new HashMap<>();
            isWord = false;
        }

        public TrieNode(char character) {
            this();
            this.character = character;
        }

        public TrieNode getNode(char ch) {
            return this.children.get(ch);
        }

        public void addWord(String word) {
            if (word == null || word.isEmpty()) return;
            char c = word.charAt(0);
            if (!children.containsKey(c)) {
                children.put(c, new TrieNode(c));
                children.get(c).parent = this;
            }
            if (word.length() > 1) {
                children.get(c).addWord(word.substring(1));
            } else {
                children.get(c).isWord = true;
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
                sb.insert(0, current.character);
                current = current.parent;
            }
            return sb.toString();
        }
    }
}