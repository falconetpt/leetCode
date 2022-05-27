package exercises.string;

public class RemoveDuplicates {
  public String removeDuplicates(final String s,
                                 final int k) {
    var sb = new StringBuilder(s);
    var changed = true;

    while (changed) {
      var count = 1;
      var newSb = new StringBuilder();
      final var str = sb.toString();
      changed = false;

      for (int i = 1; i < str.length(); i++) {
        if (str.charAt(i) == str.charAt(i - 1)) {
          count++;
          if (count == k) {
            changed = true;
            count = 0;
          }
        } else {
          for (int j = Math.max(i - count, 0); j < i; j++) {
            newSb.append(str.charAt(j));
          }
          count = 1;
        }
      }
      for (int j = Math.max(str.length() - count, 0); j < str.length(); j++) {
        newSb.append(str.charAt(j));
      }

      sb = newSb;

    }

    return sb.toString();
  }
}
