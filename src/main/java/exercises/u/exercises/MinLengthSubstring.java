package exercises.u.exercises;

public class MinLengthSubstring {
  private static final String AB = "AB";
  private static final String CD = "CD";

  public int minLength(final String s) {
    final var replacedAB = s.replaceFirst(AB, "");
    final var replacedCD = replacedAB.replaceFirst(CD, "");

    if (s.length() == replacedAB.length() && s.length() == replacedCD.length()) {
      return s.length();
    }

    return minLength(replacedCD);
  }
}
