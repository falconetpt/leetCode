package dp;

import java.util.Map;

public class ExecuteInstructions {
  private final static Map<Character, int[]> MOVES = Map.of(
      'R', new int[] { 0, 1 },
      'U', new int[] { -1, 0 },
      'L', new int[] { 0, -1 },
      'D', new int[] { 1, 0 }
  );

  public int[] executeInstructions(int n, int[] startPos, String s) {
    final var result = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {
      var count = 0;
      var start = new int[] { startPos[0], startPos[1] };
      for (int j = i; j < s.length(); j++) {
        final var move = MOVES.get(s.charAt(j));
        start = new int[] { start[0] + move[0], start[1] + move[1] };

        if (start[0] < 0 || start[0] >= n) break;
        if (start[1] < 0 || start[1] >= n) break;
        count++;
      }
      result[i] = count;
    }


    return result;
  }
}
