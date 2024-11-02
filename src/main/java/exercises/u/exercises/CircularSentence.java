package exercises.u.exercises;

public class CircularSentence {
  public boolean isCircularSentence(String sentence) {
    final var sentenceBreakDown = sentence.split(" ");

    for (int i = 0; i < sentenceBreakDown.length; i++) {
      final var current = sentenceBreakDown[i];

      final var next = sentenceBreakDown[(i + 1) % sentenceBreakDown.length];

      final var lastCharOnCurrent = current.charAt(current.length() - 1);
      final var firstCharOnNext = next.charAt(0);

      if (lastCharOnCurrent != firstCharOnNext) return false;
    }

    return true;
  }
}
