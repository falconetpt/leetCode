package exercises.array;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxArea {
  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    final var horizontalList = Stream.concat(Arrays.stream(horizontalCuts).boxed(), Stream.of(0, h))
      .sorted()
      .collect(Collectors.toList());

    final var verticalList = Stream.concat(Arrays.stream(verticalCuts).boxed(), Stream.of(0, w))
      .sorted()
      .collect(Collectors.toList());

    final var horizontalMax = IntStream.range(1, horizontalList.size())
      .map(i -> horizontalList.get(i) - horizontalList.get(i - 1))
      .max()
      .orElse(0);

    final var verticalMax = IntStream.range(1, verticalList.size())
      .map(i -> verticalList.get(i) - verticalList.get(i - 1))
      .max()
      .orElse(0);

    return verticalMax * horizontalMax;
  }
}
