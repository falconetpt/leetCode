package exercises.string;

public class ShiftLetters {
  public String shiftingLetters(final String s, final int[] shifts) {
    final var set = new int[shifts.length];
    set[shifts.length - 1] = shifts[shifts.length - 1] % 26;

    for (int i = shifts.length - 2; i >= 0; i--) {
      set[i] = (set[i + 1] + shifts[i]) % 26;
    }

    final var result = new StringBuffer();

    for (int i = 0; i < s.length(); i++) {
      result.append((char) ((s.charAt(i) + set[i] - 'a') % 26 + 97));
    }

    return result.toString();
  }
}
