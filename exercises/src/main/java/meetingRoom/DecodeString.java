package meetingRoom;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DecodeString {
  private final char recurse = '[';
  private final Character ignore = ']';
  private final String numberRegex = "[0-9]";

  public String decodeString(String s) {
    final var list = new LinkedList<Character>();

    for (int i = 0; i < s.length(); i++) {
      final var value = s.charAt(i);
      if (value == ignore) {
        decodeString(list);
      } else {
        list.addLast(value);
      }
    }

    return list.stream().map(String::valueOf)
        .collect(Collectors.joining());
  }

  private void decodeString(LinkedList<Character> list) {
    final var string = new StringBuilder();
    var repeat = 0;
    var seen = 0;

    while (!list.isEmpty()) {

      final var prev = list.pollLast();

      if (seen > 0) {
        if(Character.isDigit(prev)) {
          System.out.println("is digit = " + Character.getNumericValue(prev));
          repeat += seen * Character.getNumericValue(prev);
          seen *= 10;
        } else {
          list.add(prev);
          break;
        }
      } else if (prev == recurse){
        seen = 1;
      } else {
        string.insert(0, prev);
      }

      //   System.out.println("prev =" + prev);
      // System.out.println("list =" + list);
      // System.out.println("string =" + string);
      // System.out.println("repeat =" + repeat);
      // System.out.println("seen =" + seen);
      // System.out.println("------");
    }

    final var charrArr = string.toString().repeat(repeat).toCharArray();

    IntStream.range(0, charrArr.length)
        .forEach(i -> list.addLast(charrArr[i]));

  }
}
