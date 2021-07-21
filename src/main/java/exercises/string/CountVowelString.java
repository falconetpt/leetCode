package exercises.string;

public class CountVowelString {
  public int countVowelStrings(final int n) {
    final var matrix = new int[n][5];
    matrix[0] = new int[] {1, 1, 1, 1, 1};

    return sumOfVowels(1, matrix, 5);
  }

  private int sumOfVowels(final int i, final int[][] matrix, final int sum) {
    if (i >= matrix.length) {
      return sum;
    } else {
      final var currentValue = matrix[i];
      currentValue[0] = sum;
      var runningSum = sum;
      var newSum = sum;

      for (int j = 1; j < currentValue.length; j++) {
        runningSum = runningSum - matrix[i - 1][j -1];
        currentValue[j] = runningSum;
        newSum += currentValue[j];
      }

      return sumOfVowels(i + 1, matrix, newSum);
    }
  }
}
