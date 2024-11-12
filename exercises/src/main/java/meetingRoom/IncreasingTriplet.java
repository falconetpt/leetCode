package meetingRoom;

public class IncreasingTriplet {
  public boolean increasingTriplet(int[] nums) {
    final var dp = new int[2];
    dp[0] = Integer.MAX_VALUE;
    dp[1] = Integer.MAX_VALUE;

    // [2,6,5,6,4,7]
    for (final int element : nums) {
      final var prevStart = dp[0];
      final var prevMax = dp[1];

      if (element > prevMax) return true;

      if (element > prevStart) dp[1] = element;

      if (element < prevStart) dp[0] = element;
    }

    return false;
  }
}
