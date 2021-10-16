package exercises.blind;

public class ContainerWithMostWater {
  public int maxArea(final int[] height) {
    var max = 0;
    var start = 0;
    var end = height.length - 1;

    while (start < end) {
      final var firstHeight = height[start];
      final var lastHeight = height[end];
      max = Math.max(max, Math.min(lastHeight, firstHeight) * (end - start));

      if (firstHeight < lastHeight) {
        start++;
      } else {
        end--;
      }
    }

    return max;
  }
}
