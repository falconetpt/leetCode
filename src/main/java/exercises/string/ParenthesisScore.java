package exercises.string;

import java.util.LinkedList;

public class ParenthesisScore {
  private static final char OPEN_PARENTHESIS = '(';
  private static final char CLOSE_PARENTHESIS = ')';

  public int scoreOfParentheses(final String s) {
    return scoreOfParentheses(s, 0).value;
  }

  private ScoreEvaluation scoreOfParentheses(final String s,
                                             final int index) {
    final var linked = new LinkedList<Character>();
    var total = 0;
    var nextIndex = index;
    var multiplier = false;

    while (nextIndex < s.length()) {
      final var prev = linked.isEmpty()
        ? ' '
        : linked.peekFirst();
      final var element = s.charAt(nextIndex);

      if (prev == OPEN_PARENTHESIS && element == prev) {
        final var score = scoreOfParentheses(s, nextIndex);
        total += 2 * score.value;
        nextIndex = score.nextIndex;
        multiplier = true;
      } else {
        if (linked.isEmpty()) {
          if (element == CLOSE_PARENTHESIS) return new ScoreEvaluation(nextIndex, total);
          linked.addLast(element);
        } else  {
          linked.pollFirst();
          if (multiplier) {
            multiplier = false;
          } else {
            total++;
          }
        }
        nextIndex++;
      }
    }

    return new ScoreEvaluation(nextIndex, total);
  }

  private class ScoreEvaluation {
    private final int nextIndex;
    private final int value;

    public ScoreEvaluation(final int nextIndex,
                           final int value) {
      this.nextIndex = nextIndex;
      this.value = value;
    }
  }
}
