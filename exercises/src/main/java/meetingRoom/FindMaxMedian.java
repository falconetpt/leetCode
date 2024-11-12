package meetingRoom;

import java.util.stream.IntStream;

public class FindMaxMedian {
  public double findMaxAverage(int[] nums, int k) {
    var sum = IntStream.range(0, k)
        .map(i -> nums[i])
        .sum();
    var max = (double) sum / k;

    for (int i = k; i < nums.length; i++) {
      final var earlier = nums[i-k];
      sum -= earlier;
      sum += nums[i];

      max = Math.max(max, (double) sum / k);
    }

    return max;
  }
}
