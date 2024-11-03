package exercises.u.exercises;

import java.util.List;

public class MinBitwiseArray {
  public int[] minBitwiseArray(List<Integer> nums) {
    final var ans = new int[nums.size()];

    for(int i = 0; i < nums.size(); i++) {
      final var element = nums.get(i);

      if ((ans[i] | element + 1) == element) {
        ans[i] = i;
      }
    }

    return new int[0];
  }
}
