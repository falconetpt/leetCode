package exercises.array;

import java.util.Arrays;

public class BulbSwitch {
  public int bulbSwitch(int n) {
    if (n < 2) {
      return 0;
    }

    final var array = new int[n];
    Arrays.fill(array, 1);
    var result = n;


    for (var i = 2; i <= n; i++) {
      for (var point = i; point * i <= n; point++) {
        final var value = point * i;
        array[value - 1] *= -1;
        result += array[value - 1];
      }
    }

    return result;
  }
}
