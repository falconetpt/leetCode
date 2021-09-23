package exercises.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BreakPalindrome {
  public String breakPalindrome(final String palindrome) {
    if(palindrome.length() < 2) return "";
    final var palindromes = Arrays.stream(palindrome.split(""))
      .collect(Collectors.toCollection(LinkedList::new));
    final var frequency = palindromes.stream()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    final var result = new StringBuffer();
    var index = 0;

    while (!palindromes.isEmpty()) {
      final var element = palindromes.pollFirst()
        .charAt(0);

      if (palindromes.size() == 0) {
        result.append(element == 'a' ? 'b' : 'a');
      } else {
        if (element != 'a'
          && frequency.getOrDefault('a', 0L) + 1 % 2 == palindrome.length() % 2
          && palindrome.length() % 2 == 1
          && index != palindrome.length() /2
        ) {
          result.append('a');
          result.append(palindrome.substring(index + 1));
          return result.toString();
        } else {
          result.append('a');
        }
      }

      index++;
    }

    return result.toString();
  }
}
