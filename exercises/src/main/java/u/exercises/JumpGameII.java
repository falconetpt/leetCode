package u.exercises;

public class JumpGameII {
  public int jump(int[] nums) {
    if (nums.length <= 1) return 0;
    final var dp = new int[nums.length];
    dp[nums.length -1] = 0;


    for(var i = nums.length - 2; i >= 0; i--) {
      var min = nums[i] == 0
          ? Integer.MAX_VALUE - 100000
          : Integer.MAX_VALUE;
      //System.out.println("Top" + nums[i]);
      for(int j = i + 1; j < i + nums[i] + 1 && j < nums.length; j++) {
        //System.out.println("Bottom" + nums[j]);

        min = Math.min(min, 1 + dp[j]);
      }

      //System.out.println("Min: " + min);
      dp[i] = min;
    }

    return dp[0];
  }
}
