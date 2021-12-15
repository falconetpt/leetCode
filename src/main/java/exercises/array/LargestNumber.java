package exercises.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LargestNumber {
  public String maximumNumber(final String num, final int[] change) {
    final var numbers = IntStream.range(0, num.length())
      .map(i -> num.charAt(i) - '0')
      .toArray();

    var start = -1;

    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == change[numbers[i]]) {
        start = start == - 1
          ? start
          : start + 1;
      }
      if ((start == -1 || start == i - 1) && numbers[i] < change[numbers[i]]) {
        numbers[i] = change[numbers[i]];
        start = i;
      }
    }

    final var result = Arrays.stream(numbers)
      .mapToObj(String::valueOf)
      .toArray(String[]::new);

    return String.join("", result);
  }
}
