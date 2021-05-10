package exercises.sort;

import java.util.Arrays;

public class ConstructArray {
  public boolean isPossible(int[] target) {
    int max = (int) Arrays.stream( target )
      .count();

    return Arrays.stream(target)
      .noneMatch( i -> i > max );
  }
}
