package exercises.array;

import java.util.Arrays;

public class NumRollsToTarget {
  int MOD = (int)(1e9 + 7);

  public int numRollsToTarget(final int numberOfDices,
                              final int numberOfFaces,
                              final int target) {
    int[][] memo = new int[numberOfDices+1][target+1];
    for(int i = 0;i<=numberOfDices;i++){
      Arrays.fill(memo[i], -1);
    }

    return helper(numberOfDices, numberOfFaces, target, memo);
  }

  private int helper(final int numberOfDices,
                     final int numberOfFaces,
                     final int target,
                     final int[][] memo) {
    if (numberOfDices == 0 && target == 0) return 1;
    if (target > 0 && numberOfDices > 0) {
      if (memo[numberOfDices][target] != -1) return memo[numberOfDices][target];

      int result = 0;
      for (int i = 1; i <= numberOfFaces; i++) {
        result += helper(numberOfDices - 1, numberOfFaces, target - i, memo);
      }

      memo[numberOfDices][target] = result;

      return result;
    } else {
      return 0;
    }
  }
}
