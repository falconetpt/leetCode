package exercises.blind;

import java.util.Arrays;
import java.util.Objects;

public class WordDictionary {

  private Trie root;

  public WordDictionary() {
    root = new Trie();
  }

  public void addWord(final String word) {
    root.insert(word);
  }

  public boolean search(final String word) {
    return root.search(word);
  }

  private class Trie {
    private Trie[] words;
    private boolean isWord;

    public Trie() {
      words = new Trie[26];
      isWord = false;
    }

    public void insert(String word) {
      insert(word, 0);
    }

    private void insert(final String word, final int i) {
      if (i >= word.length()) {
        this.isWord = true;
      } else {
        final var element = word.charAt(i) - 'a';
        if (words[element] == null) words[element] = new Trie();
        words[element].insert(word, i + 1);
      }
    }

    public boolean search(String word) {
      return search(word, 0);
    }

    private boolean search(final String word, final int i) {
      if (i >= word.length()) {
        return this.isWord;
      } else {
        if (word.charAt(i) == '.') return Arrays.stream(words)
          .filter(Objects::nonNull)
          .anyMatch(w -> w.search(word, i + 1));
        final var element = word.charAt(i) - 'a';
        if (words[element] == null) return false;
        return words[element].search(word, i + 1);
      }
    }
  }
}
