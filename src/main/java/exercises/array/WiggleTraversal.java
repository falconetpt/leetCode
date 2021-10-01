package exercises.array;

public class WiggleTraversal {
  public int wiggleMaxLength(final int[] nums) {
    var result = 0;
    var count = 1;
    var start = nums[1] - nums[0];

    for (int i = 2; i < nums.length; i++) {
      final var next = nums[i] - nums[i - 1];

      if (start * next > 0) {
        result = Math.max(result, count + 1);
        count = 0;
      } else {
        count++;
      }
      start = next;
    }

    return Math.max(result, count + 1);
  }
}
