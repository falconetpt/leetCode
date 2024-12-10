package dp;

public class IsArraySpecial {
  public boolean[] isArraySpecial(int[] nums, int[][] queries) {
    final var preCalArr = generatePreCalculatedArr(nums);
    final var result = new boolean[queries.length];

    for (int i = 0; i < queries.length; i++) {
      final var element = queries[i];
      final var from = element[0];
      final var to = element[1];

      result[i] = preCalArr[from][to];
    }

    return result;
  }

  private static boolean[][] generatePreCalculatedArr(int[] nums) {
    final var preCalcedArr = new boolean[nums.length][nums.length];

    for (int i = 0; i < nums.length; i++) {
      var last = nums[i] % 2;
      preCalcedArr[i][i] = true;

      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] % 2 != last) {
          last = nums[j] % 2;
          preCalcedArr[i][j] = true;
        } else {
          break;
        }
      }
    }

    return preCalcedArr;
  }
}
