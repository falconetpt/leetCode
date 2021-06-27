package exercises.array;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Candy {
  public int candy(final int[] ratings) {
    final var result = new int[ratings.length];

    IntStream.range(0, ratings.length)
      .filter(index -> isValey(ratings, index))
      .peek(index -> result[index] = 1)
      .peek(index -> fillArray(ratings, index + 1, result, ratings[index], 2, 1))
      .forEach(index -> fillArray(ratings, index - 1, result, ratings[index], 2, -1));

    return Arrays.stream(result)
      .sum();
  }

  private void fillArray(final int[] ratings,
                         final int index,
                         final int[] result,
                         final int prevRating,
                         final int candy,
                         final int multiplier) {
    if (index >= 0 && index < ratings.length && ratings[index] > prevRating) {
      result[index] = Math.max(candy, result[index]);
      fillArray(ratings, index + multiplier, result, ratings[index], candy + 1, multiplier);
    }
  }

  private boolean isValey(final int[] ratings, final int index) {
    return (index + 1 >= ratings.length || ratings[index] <= ratings[index + 1])
        && (index - 1 < 0 || ratings[index] <= ratings[index - 1]);
  }
}
