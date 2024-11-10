package questions75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidCandies {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    final var max = Arrays.stream(candies)
        .max()
        .orElse(Integer.MIN_VALUE);
    final var result = new ArrayList<Boolean>();


    for (int i = 0; i < candies.length; i++) {
      final var candy = candies[i];
      result.add((candy + extraCandies) >= max);
    }

    return result;
  }
}
