package exercises.number;

public class FindComplement {
  public int findComplement(final int num) {
    var remainingNum = num;
    var result = 0;
    var index = 0;

    while (remainingNum > 0) {
      final var remainder = remainingNum % 2;
      remainingNum /= 2;

      if (remainder == 0) {
        result += (int) Math.pow(2, index);
      }

      index++;
    }

    return result;
  }
}
