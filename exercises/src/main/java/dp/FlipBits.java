package dp;

import java.util.Comparator;
import java.util.HashMap;

public class FlipBits {
  public int maxEqualRowsAfterFlips(int[][] matrix) {
    final var frequencyMap = new HashMap<String, Integer>();


    fillFrequencyMap(matrix, frequencyMap);

    return frequencyMap.values()
        .stream()
        .max(Integer::compareTo)
        .orElse(1);
  }

  private void fillFrequencyMap(int[][] matrix, HashMap<String, Integer> frequencyMap) {
    for (int i = 0; i < matrix.length; i++) {
      final var currentStr = new StringBuilder();
      final var flippedStr = new StringBuilder();

      for (int j = 0; j < matrix[i].length; j++) {
        final var value = matrix[i][j];

        currentStr.append(value);
        flippedStr.append(value ^ 1); // XOR if 1 then 0, if 0 then 1
      }

      frequencyMap.put(currentStr.toString(), frequencyMap.getOrDefault(currentStr.toString(), 0) + 1);
      frequencyMap.put(flippedStr.toString(), frequencyMap.getOrDefault(flippedStr.toString(), 0) + 1);
    }
  }
}
