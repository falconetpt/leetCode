package meetingRoom;

public class Subsequence {
  public boolean isSubsequence(String s, String t) {
    var sIndex = 0;
    var tIndex = 0;

    while (sIndex < s.length() && tIndex < t.length()) {
      final var sChar = s.charAt(sIndex);
      final var tChar = t.charAt(tIndex);

      if (sChar == tChar) sIndex++;
      tIndex++;
    }

    return sIndex == s.length();
  }
}
