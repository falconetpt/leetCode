package exercises.blind;

class Trie {
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
      final var element = word.charAt(i) - 'a';
      if (words[element] == null) return false;
      return words[element].search(word, i + 1);
    }
  }

  public boolean startsWith(String prefix) {
    return startsWith(prefix, 0);
  }

  private boolean startsWith(final String word, final int i) {
    if (i >= word.length()) {
      return true;
    } else {
      final var element = word.charAt(i) - 'a';
      if (words[element] == null) return false;
      return words[element].startsWith(word, i + 1);
    }
  }
}
