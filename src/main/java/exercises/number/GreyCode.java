package exercises.number;

import java.util.ArrayList;
import java.util.List;

public class GreyCode {

//  00, 01, 11, 10
//  000, 001, 011, 111, 110, 100
//  000, 001, 011, 010, 110, 111, 101, 100
//  0000, 0001, 0011, 0111, 1111, 1110, 1100, 1000
  public List<Integer> grayCode(int n) {
    final var result = new ArrayList<Integer>();
    var total = 0;
    result.add(total);
    var iterations = 2 << n;

    for (int i = 1; i < iterations; i++) {
      if(i > n) {
        total = total << 1 & (iterations - 1);
      } else {
        total = (total << 1) | 1;
      }
      result.add(total);
    }

    return result;
  }
}
