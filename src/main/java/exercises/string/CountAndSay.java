package exercises.string;

public class CountAndSay {
  public String countAndSay(int n) {
    return countAndSay(n - 1, "1");
  }

  private String countAndSay(final int n, final String s) {
    if (n == 0) {
      return s;
    } else {
      return countAndSay(n - 1, convertToCount(s));
    }
  }

  private String convertToCount(final String s) {
    final var result = new StringBuilder();
    var lastOne = ' ';
    var count = 0;

    for (int i = 0; i < s.length(); i++) {
      final var element = s.charAt(i);

      if (element == lastOne) {
        count++;
      } else {
        if (count > 0) result.append(count + "" + lastOne);
        count = 1;
        lastOne = element;
      }
    }

    result.append(count + "" + lastOne);

    return result.toString();
  }
}
