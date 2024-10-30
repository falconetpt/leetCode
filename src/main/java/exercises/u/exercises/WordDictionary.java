package exercises.u.exercises;

import java.util.Arrays;
import java.util.Objects;

public class WordDictionary {
  private WordTree wordTree;

  public WordDictionary() {
    wordTree = new WordTree();
  }

  public void addWord(String word) {
    wordTree.addWord(word, 0);
  }

  public boolean search(String word) {
    return wordTree.search(word, 0);
  }


  private class WordTree {
    private WordTree[] wordTrees;
    private boolean isWord;

    private WordTree() {
      wordTrees = new WordTree[26];
    }

    private void addWord(String word, int index) {
      final var currentCharIndex = word.charAt(index) - 'a';

      if (wordTrees[currentCharIndex] == null) wordTrees[currentCharIndex] = new WordTree();

      if (index == word.length() - 1) {
        wordTrees[currentCharIndex].isWord = true;
      } else {
        wordTrees[currentCharIndex].addWord(word, index + 1);
      }
    }

    private boolean search(String word, int index) {
      final var currentChar = word.charAt(index);

      if (currentChar == '.') {
        return Arrays.stream(wordTrees).filter(Objects::nonNull)
            .anyMatch(w -> w.search(word, index + 1));
      } else {
        final var currentCharIndex = currentChar - 'a';
        if (wordTrees[currentCharIndex] == null) return false;

        if (index == word.length() - 1) {
          return wordTrees[currentCharIndex].isWord;
        } else {
          return wordTrees[currentCharIndex].search(word, index + 1);
        }
      }
    }
  }
}
