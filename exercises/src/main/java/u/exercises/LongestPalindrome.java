package u.exercises;

public class LongestPalindrome {
  public String longestPalindrome(String s) {
    String max = "";

    for(int i = 0; i < s.length(); i++) {
      for (int j = s.length(); j > i ; j--) {
        if (j-i <= max.length()) break;
        final var newStr = s.substring(i, j);
        if(isPalindrome(newStr)) {
          max = newStr;
        }
      }
    }
    return max;
  }

  public boolean isPalindrome(String s) {
    final var sb = new StringBuilder(s);
    return sb.toString().equals(sb.reverse().toString());
  }
}
