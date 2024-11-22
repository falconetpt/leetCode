package dp;

public class DecodeWays {
  public int numDecodings(String s) {
    if (s.length() == 0) return 0;
    final var dp = new int[s.length() + 2];
    var last = s.charAt(s.length() - 1);
    dp[s.length() - 1] = last == '0' ? 0 : 1;

    for (int i = s.length() - 2; i >= 0; i--) {
      final var current = s.charAt(i);

      // System.out.println(current + ":" + Arrays.toString(dp));
      // System.out.println(Integer.parseInt(current + "" + last));

      if (current != '0') {
        dp[i] = dp[i + 1];

        if (Integer.parseInt(current + "" + last) < 27) {
          dp[i] += i + 2 >= s.length() ? 1 : dp[i+2];
        }
      }
      last = current;

    }

    return dp[0];
  }
}
