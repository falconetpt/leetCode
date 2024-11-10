package questions75;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

public class ReverseVowels {
  public String reverseVowels(String s) {
    final var vowels = new LinkedList<Data>();
    final var charArr = new char[s.length()];
    final var set = Set.of(
        'a', 'e', 'i', 'o', 'u',
        'A', 'E', 'I', 'O', 'U'
    );

    for (int i = 0; i < s.length(); i++) {
      final var element = s.charAt(i);

      if (set.contains(element)) {
        vowels.addFirst(new Data(i, element));
      }
      charArr[i] = element;
    }

    while(vowels.size() > 1) {
      final var elementLast = vowels.pollLast();
      final var elementFirst = vowels.pollFirst();
      charArr[elementFirst.index] = elementLast.c;
      charArr[elementLast.index] = elementFirst.c;
    }

    return String.valueOf(charArr);
  }

  private record Data(int index, char c){}
}
