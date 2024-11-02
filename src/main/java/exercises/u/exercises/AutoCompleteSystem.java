package exercises.u.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class AutoCompleteSystem {
  private static final int TRIE_LENGTH = 27;
  private final WordTrie wordTrie;

  AutoCompleteSystem(String[] sentences, int[] times) {
    wordTrie = new WordTrie();
    fillWordTrie(sentences, times);
  }

  private void fillWordTrie(final String[] sentences,
                            final int[] times) {

    for (int i = 0; i < sentences.length; i++) {
      final var sentence = sentences[i];
      final var searches = times[i];
      wordTrie.addWord(sentence, 0, searches);
    }
  }

  public String[] search(String s) {
    final var queue = new PriorityQueue<WordTrie>(Comparator.comparing(w -> -w.times));
    return wordTrie.search(s, 0, queue)
        .stream()
        .limit(3)
        .map(w -> w.string)
        .toArray(String[]::new);
  }

  private static int getIndex(Character c) {
    if (c == ' ') return TRIE_LENGTH - 1;
    return c - 'a';
  }

  private class WordTrie {
    private WordTrie[] wordTrie;
    private boolean isWord;
    public String string;
    private int times;

    public WordTrie() {
      wordTrie = new WordTrie[TRIE_LENGTH];
    }

    public void addWord(String str, int index, int times) {
      if (index >= str.length()) {
        isWord = true;
        this.string = str;
        this.times = times;
      } else {
        final var currentChar = str.charAt(index);
        final var trieIndex = getIndex(currentChar);

        if (wordTrie[trieIndex] == null) wordTrie[trieIndex] = new WordTrie();
        wordTrie[trieIndex].addWord(str, index + 1, times);
      }
    }

    public PriorityQueue<WordTrie> search(String str, int index, PriorityQueue<WordTrie> result) {
      if (index >= str.length() || str.charAt(index) == '#') {
        if (isWord) result.add(this);
        Arrays.stream(wordTrie).filter(Objects::nonNull)
            .forEach(w -> w.search(str, index + 1, result));

        return result;
      } else {
        final var currentChar = str.charAt(index);

        final var charIndex = getIndex(currentChar);
        if (wordTrie[charIndex] == null) return result;
        return wordTrie[charIndex].search(str, index + 1, result);
      }
    }
  }
}
