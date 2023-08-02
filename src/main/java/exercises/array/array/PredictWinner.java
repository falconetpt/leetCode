package exercises.array.array;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class PredictWinner {
  public boolean PredictTheWinner(int[] nums) {
    return minMax(nums, 0, nums.length - 1, true) > 0;
  }

    public int minMax(int[] nums, int start, int end, boolean isMaximizingPlayer) {
      if (start == end) {
        return isMaximizingPlayer ? nums[start] : -nums[start];
      }

      if (isMaximizingPlayer) {
        int maxScore = Integer.MIN_VALUE;
        for (int move : new int[]{start, end}) {
          int score = move + minMax(nums, (move == start) ? start + 1 : start, end, false);
          maxScore = Math.max(maxScore, score);
        }
        return maxScore;
      } else {
        int minScore = Integer.MAX_VALUE;
        for (int move : new int[]{start, end}) {
          int score = -move + minMax(nums, (move == start) ? start + 1 : start, end, true);
          minScore = Math.min(minScore, score);
        }
        return minScore;
      }
    }
}
