package exercises.array;

public class ValidateStackSequences {
  public boolean validateStackSequences(final int[] pushed,
                                        final int[] popped) {
    final int beginningIndex = beginningIndex(pushed, popped);
    if (beginningIndex == -1) return false;
    var counter = 0;

    for (int i = 0; i < pushed.length; i++) {
      final var index = i + beginningIndex >= pushed.length
        ? beginningIndex - ++counter
        : beginningIndex + i;

      if (pushed[i] != pushed[i + beginningIndex]) return false;
    }
    
    return true;
  }

  private int beginningIndex(final int[] pushed, final int[] popped) {
    for (int i = 0; i < pushed.length; i++) {
      if (pushed[i] == popped[0]) return i;
    }
    return -1;
  }
}
