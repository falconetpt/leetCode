package exercises.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MinimumDeviation {

  public int minimumDeviation(final int[] nums) {
    final var bottomQueue = new PriorityQueue<>(Comparator.comparing(Number::getValue));
    final var topQueue = new PriorityQueue<Number>(Comparator.comparing(n -> -n.value));

    Arrays.stream(nums)
      .mapToObj(Number::new)
      .peek(bottomQueue::add)
      .forEach(topQueue::add);


    var minDeviation = topQueue.peek().value - bottomQueue.peek().value;

    var shorten = true;

    while (shorten) {
      final var bottom = bottomQueue.peek();

      final var firstTransformed = applyTransformation(bottom.value);

      if (firstTransformed > bottom.value) {
        bottom.value = firstTransformed;
        bottomQueue.add(bottomQueue.poll());
        topQueue.add(topQueue.poll());
      }

      final var top = topQueue.peek();
      final var lastTransformed = applyTransformation(top.value);

      if (lastTransformed < top.value) {
        top.value = lastTransformed;
        bottomQueue.add(bottomQueue.poll());
        topQueue.add(topQueue.poll());
      }

      System.out.println("firstTransformed = " + firstTransformed);
      System.out.println("lastTransformed = " + lastTransformed);
      System.out.println("bottom = " + bottom.value);
      System.out.println("top = " + top.value);
      final var prevMinDeviation = minDeviation;
      minDeviation = Math.min(minDeviation,
        topQueue.peek().value - bottomQueue.peek().value);

      shorten = minDeviation < prevMinDeviation;
    }

    return minDeviation;
  }

  private int applyTransformation(final int number) {
    return number % 2 == 0
      ? number / 2
      : number * 2;
  }

  private class Number {
    private Integer value;

    public Number(final int value) {
      this.value = value;
    }

    public Integer getValue() {
      return value;
    }
  }
}
