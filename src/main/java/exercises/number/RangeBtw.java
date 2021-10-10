package exercises.number;

import java.util.stream.IntStream;

public class RangeBtw {
  public int rangeBitwiseAnd(final int left, final int right) {
    if (left == 1 && right != 1) return 0;
    if (left == right) return left;
    var newLeft = left;
    var newRight = right;
    var result = newLeft & newRight;

    while (newLeft <= newRight) {
      result = result
        & newLeft & newRight;
      if (result == 0) {
        return 0;
      } else {
        newLeft++;
        newRight--;
      }
    }
    return result;
  }
}
