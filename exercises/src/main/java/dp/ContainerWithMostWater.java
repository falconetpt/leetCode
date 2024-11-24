package dp;

public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    var left = 0;
    var right = height.length - 1;

    var max = 0;

    while (left < right) {
      final var heightMin = Math.min(height[left], height[right]);
      max = Math.max(max, heightMin * (right -left));

      if (height[left] > height[right]) {
        right--;
      } else {
        left++;
      }
    }


    return max;
  }
}
