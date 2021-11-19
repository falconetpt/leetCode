package exercises.number;

public class HammingDistance {
  public int hammingDistance(final int x, final int y) {
    final var unmatchedBits = x ^ y;

    return hammingDistance(unmatchedBits);
  }

  private int hammingDistance(final int unmatchedBits) {
    if (unmatchedBits == 0) {
      return 0;
    } else {
      final var number = unmatchedBits % 2;


      return number
        + hammingDistance(unmatchedBits / 2);
    }
  }
}
