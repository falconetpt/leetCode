package exercises.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReversePolishNotation {
  public int evalRPN(final String[] tokens) {
    if (tokens.length == 1) return Integer.parseInt(tokens[0]);

    final var list = new LinkedList<Integer>();

    Integer total = null;

    for (int i = 0; i < tokens.length; i++) {
      final var next = tokens[i];

      if (Stream.of("+", "-", "/", "*").anyMatch(x -> x.equalsIgnoreCase(next))
        && total == null) {
        final var prev = list.pollLast();
        total = list.pollLast();

        switch (next) {
          case "+":
            total += prev;
            break;
          case "/":
            total /= prev;
            break;
          case "-":
            total -= prev;
            break;
          case "*":
            total *= prev;
            break;
        }
      } else {
        switch (next) {
          case "+":
            total += list.pollLast();
            break;
          case "/":
            total = list.pollLast() / total;
            break;
          case "-":
            total = list.pollLast() - total;
            break;
          case "*":
            total *= list.pollLast();
            break;
          default:
            list.add(Integer.valueOf(next));
        }
      }
    }

    return total;
  }
}
