package exercises.objects;

public class Trie {
  private final Trie[] children;
  private boolean isWord;

  public Trie() {
    children = new Trie[26];
    isWord = false;
  }

  public void insert(final String word) {
    insert(word, 0);
  }

  private void insert(final String word, final int i) {
    if (i < word.length()) {
      final var element = word.charAt(i) - 'a';
      if (children[element] == null) children[element] = new Trie();
      if (i + 1 >= word.length()) {
        children[element].isWord = true;
      } else {
        children[element].insert(word, i + 1);
      }
    }
  }

  public boolean search(final String word) {
    return search(word, 0);
  }

  private boolean search(final String word, final int i) {
    final var element = word.charAt(i) - 'a';
    if (i + 1 >= word.length()) {
      return children[element] != null
        && children[element].isWord;
    } else {
      if (children[element] == null) return false;
      return children[element].search(word, i + 1);
    }
  }

  public boolean startsWith(final String prefix) {
    return startsWith(prefix, 0);
  }

  private boolean startsWith(final String word, final int i) {
    if (i >= word.length()) {
      return true;
    } else {
      final var element = word.charAt(i) - 'a';
      if (children[element] == null) return false;
      return children[element].startsWith(word, i + 1);
    }
  }
}
