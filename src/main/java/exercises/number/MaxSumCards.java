package exercises.number;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxSumCards {
  public int maxScore(int[] cardPoints, int k) {
    if (k >= cardPoints.length) return Arrays.stream(cardPoints).sum();

    int baseValue = Arrays.stream(cardPoints, 0, k)
      .sum();
    int localAnswer = baseValue;

    for (int i = 0; i < k; i++) {
      localAnswer -= cardPoints[k - i - 1];
      localAnswer += cardPoints[cardPoints.length - 1 - i];
      baseValue = Math.max(localAnswer, baseValue);
    }

    return baseValue;
  }
}
