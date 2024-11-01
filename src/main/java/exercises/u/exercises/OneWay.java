package exercises.u.exercises;

public class OneWay {
  public boolean oneWay(final String a, final String b) {
    if (a.equals(b)) return true;

    if (a.length() == b.length()) return canReplaceOneChar(a, b);
    if (Math.abs(a.length() - b.length()) > 1) return false;

    return a.length() > b.length()
        ? addOneChar(a, b)
        : addOneChar(b, a);

  }

  private boolean addOneChar(final String a, final String b) {
    int count = 0;

    for (int i = 0; i < a.length(); i++) {
      if (count > 1) return false;
      if (a.charAt(i) != b.charAt(i - count)) count++;
    }

    return true;
  }

  private boolean canReplaceOneChar(final String a, final String b) {
    int count = 0;

    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) count++;
    }

    return count < 2;
  }
}
