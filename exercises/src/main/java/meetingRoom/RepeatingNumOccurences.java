package meetingRoom;

import java.util.Arrays;
import java.util.HashSet;

public class RepeatingNumOccurences {
  public boolean uniqueOccurrences(int[] arr) {
    Arrays.sort(arr);
    final var seen = new HashSet<Integer>();
    var last = arr[0];
    var count = 1;

    for (int i = 1; i < arr.length; i++) {
      final var num = arr[i];

      if (num != last) {
        if (seen.contains(count)) return false;
        seen.add(count);
        count = 1;
        last = num;
      } else {
        count++;
      }
    }

    if (seen.contains(count)) return false;


    return true;
  }
}
