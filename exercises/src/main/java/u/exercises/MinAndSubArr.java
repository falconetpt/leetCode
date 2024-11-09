package u.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MinAndSubArr {
  public long minEnd(int n, int x) {
    final var binary = convertToBinary(x);

    final var list = new ArrayList<Long>();
    expand(binary, list, binary.length() -1, x, 0);

    return binaryToLong(binary) + list.get(x - 1);
  }

  private void expand(String binary, List<Long> list, int index, int x, int pow) {
    if (x > 0) {
      final var element = index >= 0
          ? binary.charAt(index)
          : '0';

      if (element == '1') {
        expand(binary, list, index - 1, x, pow + 1);
      } else {
        final var value = (long) Math.pow(2, pow);
        list.add(value);
        IntStream.range(0, list.size() - 1)
            .boxed()
            .map(list::get)
                .forEach(v -> list.add(v + value));

        expand(binary, list, index -1, x -1, pow + 1);
      }
    }
  }

  private Long binaryToLong(String s) {
    long result = 0L;

    for(int i = 0; i < s.length(); i++) {
      result += s.charAt(i) == '1'
          ? Math.pow(2, s.length() - 1 - i)
          : 0;
    }

    return result;
  }




  public String convertToBinary(int x) {
    if(x == 0) {
      return "";
    } else {
      final var remainder = x % 2;
      return convertToBinary(x / 2) + remainder;
    }
  }
}
