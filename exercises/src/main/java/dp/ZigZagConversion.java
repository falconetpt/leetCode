package dp;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ZigZagConversion {
  public String convert(String s, int numRows) {
    final var result = new StringBuilder[numRows];
    var index = 0;
    var sign = 1;

    IntStream.range(0, numRows).forEach(i -> result[i] = new StringBuilder());


    for (int i = 0; i < s.length(); i++) {
      final var str = s.charAt(i);
      result[index].append(str);

      index = index + sign;
      if (index >= numRows) {
        index -= 2;
        index = Math.max(index, 0);
        sign = -1;
      } else if (index < 0) {
        index = Math.min(1, numRows - 1);
        sign = 1;
      }

    }

    return Arrays.stream(result)
        .map(StringBuilder::toString)
        .collect(Collectors.joining());
  }
}
