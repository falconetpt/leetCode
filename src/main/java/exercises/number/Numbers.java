package exercises.number;

import java.util.stream.IntStream;

public class Numbers {
  public int addDigits(final int num) {
    if (num < 10) {
      return num;
    } else {
      final var strNum = String.valueOf(num);
      final var newNum = IntStream.range(0, strNum.length())
        .map(i -> strNum.charAt(i) - '0')
        .sum();
      return addDigits(newNum);
    }
  }
}
