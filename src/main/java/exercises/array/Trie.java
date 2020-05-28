package exercises.array;

import java.util.HashSet;
import java.util.Set;

class Trie {
    private Set<String> savedWords;
    private TrieNode root;


    /** Initialize your data structure here. */
    public Trie() {
        savedWords = new HashSet<>(  );
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        savedWords.add( word );
        root.saveWord( word );
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return  savedWords.contains( word );
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return root.findWord( prefix );
    }


    private class TrieNode {
        TrieNode[] nodes = new TrieNode[26];

        public TrieNode() {

        }

        public void saveWord(String word) {
            if (word.length() > 0) {
                int first = word.charAt( 0 ) - 'a';
                if (nodes[first] == null) nodes[first] = new TrieNode();
                nodes[first].saveWord( word.substring( 1 ) );
            }
        }

        public boolean findWord(String word) {
            if (word.isEmpty()) {
                return true;
            } else {
                int first = word.charAt( 0 ) - 'a';
                return nodes[first] != null && nodes[first].findWord( word.substring( 1 ) );
            }
        }
    }
}