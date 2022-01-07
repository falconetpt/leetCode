package exercises.array;

public class NumPairsDivisibleBy60 {
  public int numPairsDivisibleBy60(final int[] time) {
    var count = 0;

    for (int i = 0; i < time.length; i++) {
      for (int j = i + 1; j < time.length; j++) {
        if (time[i] + time[j] % 60 == 0) count++;
      }
    }

    return count;
  }
}
