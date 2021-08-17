package exercises.number;

public class Sqrt {
  public int mySqrt(int x) {
    if(x < 2) return x;
    return mySqrt(0, x, x);
  }

  private int mySqrt(final double start, final double end, final int result) {
    final var middle = (start + end) / 2.0;

    if (Math.abs(middle * middle - result) < 0.01 ) {
      return (int) middle;
    }

    if (middle * middle > result) {
      return mySqrt(start, middle, result);
    } else {
      return mySqrt(middle, end, result);
    }
  }
}
