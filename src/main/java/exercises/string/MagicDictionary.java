package exercises.string;

import java.util.Arrays;
import java.util.Objects;

class MagicDictionary {
  private Letter letter;

  /** Initialize your data structure here. */
  public MagicDictionary() {
    letter = new Letter();
  }

  public void buildDict(final String[] dictionary) {
    Arrays.stream(dictionary)
      .forEach(this::addWord);
  }

  private void addWord(final String s) {
    addLettersToArr(s, letter.letters, 0);
  }

  private void addLettersToArr(final String s, final Letter[] letters, final int i) {
    if (i < s.length()) {
      final var charValue = s.charAt(i);
      final var index = charValue - 'a';
      if (letters[index] == null) letters[index] = new Letter();
      if (i == s.length() - 1) letters[index].isWord = true;
      addLettersToArr(s, letters[index].letters, i + 1);
    }
  }

  public boolean search(final String searchWord) {
    return search(searchWord, letter, 0, 0);
  }

  private boolean search(final String searchWord,
                         final Letter letter,
                         final int index,
                         int countDifferent) {
    if (index >= searchWord.length()) {
      return countDifferent == 1
        && letter.isWord;
    } else {
      final var charElement = searchWord.charAt(index);
      final var nextIndex = charElement - 'a';

      if (letter.letters[nextIndex] != null) {
        return search(searchWord, letter.letters[nextIndex], index + 1, countDifferent);
      } else {
        return Arrays.stream(letter.letters)
          .filter(Objects::nonNull)
          .anyMatch(l -> search(searchWord, l, index + 1, countDifferent + 1));
      }
    }
  }

  private class Letter {
    private Letter[] letters = new Letter[26];
    private boolean isWord;
  }
}
