package exercises.array;

import java.util.stream.Stream;

public class OuterTrees {
  public int[][] outerTrees(final int[][] trees) {
    var maxX = trees[0];
    var maxY = trees[0];
    var minY = trees[0];
    var minX = trees[0];

    for (int i = 0; i < trees.length; i++) {
      final var element = trees[i];
      maxX = maxX[0] > element[0] ? maxX : element;
      maxY = maxY[1] > element[1] ? maxY : element;
      minX = minX[1] > element[1] ? minX : element;
      minY = minY[1] > element[1] ? minY : element;
    }

    return Stream.of(maxX, maxY, minX, maxY)
      .distinct()
      .toArray(int[][]::new);
  }
}
