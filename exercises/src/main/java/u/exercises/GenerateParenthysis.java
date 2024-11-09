package u.exercises;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthysis {
  public List<String> generateParenthesis(int n) {
    final var result = new ArrayList<String>();


    return  generateParenthesis(n, "", 0, 0, result);
  }

  private ArrayList<String> generateParenthesis(int n, String s,
                                                int open, int close, ArrayList<String> result) {
    if (result.size() == n * 2) {
      return result;
    } else {

      if (open < n) {
        generateParenthesis(n, s + ")", open + 1, close, result);
      }

      if (close < open) {
        generateParenthesis(n, s + ")", open, close + 1, result);
      }

      return result;
    }
  }
}
