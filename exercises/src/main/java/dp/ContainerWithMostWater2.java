package dp;

public class ContainerWithMostWater2 {
  public int maxArea(int[] height) {
    var left = 0;
    var right = height.length - 1;
    var result = 0;

    while (left < right) {
      final var leftHeight = height[left];
      final var rightHeight = height[right];
      final var minHeight = Math.min(leftHeight, rightHeight);

      result = Math.max((right - left) * minHeight, result);

      if (leftHeight > rightHeight) {
        right--;
      } else {
        left++;
      }
    }

    return result;
  }
}
