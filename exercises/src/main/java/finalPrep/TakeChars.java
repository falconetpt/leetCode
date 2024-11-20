package finalPrep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class TakeChars {
  public int takeCharacters(String s, int k) {
    if (k == 0 ) return 0;
    final var forwardCount = generateForwardCount(s);
    final var backwardCount = generateBackwardCount(s);
    final var memo = new HashMap<Point, Integer>();

    final var result = takeCharacters(s, forwardCount, backwardCount, 0, s.length() - 1 , k, memo);

    return result == Integer.MAX_VALUE
        ? -1
        : result;
  }

  private int takeCharacters(String s, int[][] forwardCount, int[][] backwardCount, int start, int end, int k,
                             HashMap<Point, Integer> memo) {
    final var point = new Point(start, end);
    if (memo.containsKey(point)) return memo.get(point);
    if (start >= end) return Integer.MAX_VALUE;

    final var forwardValue = forwardCount[start];
    final var backwardValue = backwardCount[end];

    // System.out.println(start + ":" + end);
    // System.out.println("------");
    // System.out.println(Arrays.toString(forwardValue));
    //       System.out.println(Arrays.toString(backwardValue));


    final var check = IntStream.range(0, 3)
        .map(i -> forwardValue[i] + backwardValue[i])
        .allMatch(v -> v >= k);

    if (check) {
      final var startChar = s.charAt(start);
      final var endChar = s.charAt(end);

      final var offByOne = (forwardValue[startChar- 'a'] + backwardValue[startChar - 'a'] > k
          || forwardValue[endChar- 'a'] + backwardValue[endChar - 'a'] > k)
          ? -1
          : 0;
      return start + backwardCount.length - end + offByOne + 1;
    }

    final var result = Math.min(takeCharacters(s, forwardCount, backwardCount, start + 1, end, k, memo),
        takeCharacters(s, forwardCount, backwardCount, start, end - 1, k, memo));

    memo.put(point, result);

    return result;
  }

  private int[][] generateBackwardCount(String s) {
    final var result = new int[s.length()][3]; // 3 because we need to track a,b,c
    var rollingSum = new int[3];

    for (int i = s.length() - 1; i >= 0; i--) {
      final var element = s.charAt(i);
      rollingSum[element - 'a']++;

      result[i] = Arrays.copyOf(rollingSum, rollingSum.length);
    }

    return result;
  }

  private int[][] generateForwardCount(String s) {
    final var result = new int[s.length()][3]; // 3 because we need to track a,b,c
    var rollingSum = new int[3];

    for (int i = 0; i < s.length(); i++) {
      final var element = s.charAt(i);
      rollingSum[element - 'a']++;

      result[i] = Arrays.copyOf(rollingSum, rollingSum.length);
    }

    return result;
  }


  private record Point(int x, int y){}
}
