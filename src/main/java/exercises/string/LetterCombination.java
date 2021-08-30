package exercises.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombination {
  private final static Map<Character, List<Character>> digitToLetters = Map.of(
    '2', List.of('a', 'b', 'c'),
    '3', List.of('d', 'e', 'f'),
    '4', List.of('g', 'h', 'i'),
    '5', List.of('j', 'k', 'l'),
    '6', List.of('m', 'n', 'o'),
    '7', List.of('p', 'q', 'r', 's'),
    '8', List.of('t', 'u', 'v'),
    '9', List.of('w', 'x', 'y', 'z')
  );

  public List<String> letterCombinations(final String digits) {
    return letterCombinations(digits, 0, "", new ArrayList<>());
  }

  private List<String> letterCombinations(final String digits, final int i, final String s, final List<String> result) {
    if (i >= digits.length()) {
      if (s.length() > 0) result.add(s);
      return result;
    } else {
      final var element = digits.charAt(i);
      digitToLetters.get(element)
        .forEach(c -> letterCombinations(digits, i + 1, s + c, result));
      return result;
    }
  }
}
