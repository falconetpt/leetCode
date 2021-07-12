package exercises.string;

import java.util.HashMap;
import java.util.Map;

public class IsoMorphicString {
  public boolean isIsomorphic(final String s, final String t) {
    if (s.length() != t.length()) return false;
    return isIsomorphic(s, t, 0, new HashMap<>(), new HashMap<>());
  }

  private boolean isIsomorphic(final String s,
                               final String t,
                               final int i,
                               final Map<Character, Character> characterCharacterHashMap,
                               final Map<Character, Character> characterCharacterHashMap2) {
    if (i >= s.length()) {
      return true;
    } else {
      final var char1 = s.charAt(i);
      final var char2 = t.charAt(i);

      if ((characterCharacterHashMap.containsKey(char1) && characterCharacterHashMap.get(char1) != char2)
        || (characterCharacterHashMap2.containsKey(char2)) && characterCharacterHashMap2.get(char2) != char1) return false;

      characterCharacterHashMap.putIfAbsent(char1, char2);
      characterCharacterHashMap2.putIfAbsent(char2, char1);

      return isIsomorphic(s, t, i + 1, characterCharacterHashMap, characterCharacterHashMap2);
    }
  }
}
