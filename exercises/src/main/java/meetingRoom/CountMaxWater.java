package meetingRoom;

public class CountMaxWater {
  public int maxArea(int[] height) {
    var right = height.length - 1;
    var left = 0;

    var max = 0;

    while (left < right) {
      final var leftValue = height[left];
      final var rightValue = height[right];
      final var waterArea = (right - left) * Math.min(leftValue, rightValue);

      max = Math.max(max, waterArea);

      if (leftValue < rightValue) {
        left++;
      } else {
        right--;
      }
    }

    return max;
  }
}
