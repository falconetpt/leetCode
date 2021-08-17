package exercises.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class SumBinary {
  public String addBinary(final String a, final String b) {
    final var aStack = Arrays.stream(a.split(""))
      .collect(Collectors.toCollection(LinkedList::new));
    final var bStack = Arrays.stream(b.split(""))
      .collect(Collectors.toCollection(LinkedList::new));
    var remainder = "0";
    var result = new StringBuilder();

    while (!aStack.isEmpty() || !bStack.isEmpty()) {
      final var aValue = aStack.isEmpty()
        ? "0"
        : aStack.pollLast();
      final var bValue = bStack.isEmpty()
        ? "0"
        : bStack.pollLast();

      if (aValue.equals("1") && bValue.equals("1")) {
        if (remainder.equals("1")) {
          result.append("1");
        } else {
          result.append("0");
        }

        remainder = "1";
      } else if (aValue.equals("1") || bValue.equals("1")) {
        if (remainder.equals("1")) {
          result.append("0");
          remainder = "1";
        } else {
          result.append("1");
        }
      } else {
        result.append(remainder);
        remainder = "0";
      }

    }

    if (remainder.equals("1")) result.append(remainder);

    return (result.reverse())
      .toString();
  }
}
