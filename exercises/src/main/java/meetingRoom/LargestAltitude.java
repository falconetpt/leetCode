package meetingRoom;

public class LargestAltitude {
  public int largestAltitude(int[] gain) {
    var sum = 0;
    var max = sum;

    for(final var value : gain) {
      sum += value;
      max = Math.max(max,sum);
    }

    return max;

  }
}
