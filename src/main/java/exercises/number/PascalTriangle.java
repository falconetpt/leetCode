package exercises.number;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PascalTriangle {
  public List<List<Integer>> generate(final int numRows) {
    final var result = new LinkedList<List<Integer>>();
    result.add(List.of(1));
    return generate(numRows, 2, result);
  }

  private List<List<Integer>> generate(final int numRows,
                                       final int current,
                                       final LinkedList<List<Integer>> result) {
    if (current > numRows) {
      return result;
    } else {
      final var previous = result.peekLast();
      final var newList = IntStream.range(0, current)
        .boxed()
        .map(i -> getValue(previous, i-1) + getValue(previous, i))
        .collect(Collectors.toList());

      result.add(newList);

      return generate(numRows, current + 1, result);
    }
  }

  private Integer getValue(final List<Integer> previous, final int i) {
    try {
      return previous.get(i);
    } catch (final Exception e) {
      return 0;
    }
  }
}
