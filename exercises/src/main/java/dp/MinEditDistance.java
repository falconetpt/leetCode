package dp;

public class MinEditDistance {
  public int minDistance(String word1, String word2) {
    final var dp = new int[word1.length() + 1][word2.length() + 1];

    for (int i = 0; i < dp[0].length; i++) dp[0][i] = i;
    for (int i = 0; i < dp.length; i++) dp[i][0] = i;

    for (int i = 1; i < dp.length; i++) {
      final var word1Value = word1.charAt(i - 1);
      for (int j = 1; j < dp[i].length; j++) {
        final var word2Value = word2.charAt(j - 1);


        if (word1Value == word2Value) {
          dp[i][j] = dp[i-1][j-1];
        } else {
          final var min = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
          dp[i][j] = min + 1;
        }
      }
    }


    return dp[word1.length()][word2.length()];
  }
}
