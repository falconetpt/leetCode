package exercises.number;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EvalRPN {
  private static final Map<String, BiFunction<Integer, Integer, Integer>>
    OPERATIONS = Map.of(
    "+", Integer::sum,
    "*", (a, b) -> a * b,
    "/", (a, b) -> a / b,
    "-", (a, b) -> a - b
  );

  public int evalRPN(final String[] tokens) {
    final var linkedList = Arrays.stream(tokens)
      .collect(Collectors.toCollection(LinkedList::new));

    return evalRPN(linkedList);
  }

  private int evalRPN(final LinkedList<String> linkedList) {
    if (linkedList.size() == 1) {
      return Integer.parseInt(linkedList.pollFirst());
    } else {
      final var next = new LinkedList<String>();

      while (!linkedList.isEmpty()) {
        final var token = linkedList.pollFirst();
        System.out.println(token);


        if (OPERATIONS.containsKey(token)) {
          final var second = next.pollLast();
          final var first = next.pollLast();


          if (Stream.of(second, first).noneMatch(OPERATIONS::containsKey)) {
            next.addLast(OPERATIONS.get(token)
              .apply(Integer.parseInt(first), Integer.parseInt(second))
              .toString());

          } else {
            next.addLast(first);
            next.addLast(second);
          }
        } else {
          next.addLast(token);
        }
      }

      return evalRPN(next);
    }
  }
}
