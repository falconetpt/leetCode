package exercises.number;

import java.math.BigDecimal;
import java.util.stream.IntStream;

public class TrailingZeros {
  public int trailingZeroes(final int n) {
    var product = IntStream.rangeClosed(1, n)
      .boxed()
      .map( BigDecimal::valueOf)
      .reduce(BigDecimal.ONE, BigDecimal::multiply );
    final var ten = BigDecimal.valueOf( 10 );

    var counter = 0;

    while (product.intValue() > 0) {
      final var remainder = product.remainder( ten );
      product = product.divide( ten );

      if (remainder.intValue() > 0) {
        return counter;
      } else {
        counter++;
      }
    }

    return counter;
  }
}
