package exercises.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateValidParenthesis {
  public List<String> generateParenthesis(final int n) {
    final var set = new HashSet<String>();
    return new ArrayList<>(generateParenthesis(n, "", set));
  }

  private Set<String> generateParenthesis(final int n, final String s, final Set<String> set) {
    if (n == 0) {
      set.add(s);
      return set;
    } else {
      final var middle = "(" + s + ")";
      final var left = "()" + s;
      final var right = s + "()";

      generateParenthesis(n - 1, middle, set);
      generateParenthesis(n - 1, left, set);
      generateParenthesis(n - 1, right, set);

      return set;

    }
  }
}
