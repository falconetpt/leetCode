package exercises.string;

import java.util.LinkedList;
import java.util.Set;

public class CalculatorWithMult {
  private final static Set<Character> chars = Set.of(
    '+',
    '-',
    '*',
    '/'
  );

  private final static Set<Character> priority_chars = Set.of(
    '*',
    '/'
  );

  public int calculate(final String s) {
    final var newStr = s.trim()
      .replace(" ", "");
    var elements = extractedList( newStr);

    var prev = (int) elements.pollFirst();

    while (!elements.isEmpty()) {
      final var operation = (char) elements.pollFirst();
      final var next = (int) elements.pollFirst();

      switch (operation){
        case '+':
          prev += next;
          break;
        case '-':
          prev -= next;
          break;
      }

    }

    return prev;
  }

  private LinkedList<Object> extractedList(final String newStr) {
    final var elements = new LinkedList<>();
    var value = 0;

    for (final var element : newStr.toCharArray()) {
      if (chars.contains(element)) {
        final var lastOperator = elements.isEmpty()
          ? '+'
          : (char) elements.pollLast();
        final var lastValue = elements.isEmpty()
          ? 0
          : (int) elements.pollLast();

        if (priority_chars.contains(lastOperator)) {
          switch (lastOperator) {
            case '/':
              elements.addLast(lastValue / value);
              break;
            case '*':
              elements.addLast(lastValue * value);
              break;
          }
        } else {
          elements.addLast(lastValue);
          elements.addLast(lastOperator);
          elements.addLast(value);
        }
        elements.addLast(element);
        value = 0;
      } else {
        value = value * 10 + element - '0';
      }
    }

    final var lastOperator = elements.isEmpty()
      ? '+'
      : (char) elements.pollLast();
    final var lastValue = elements.isEmpty()
      ? 0
      : (int) elements.pollLast();

    if (priority_chars.contains(lastOperator)) {
      switch (lastOperator) {
        case '/':
          elements.addLast(lastValue / value);
          break;
        case '*':
          elements.addLast(lastValue * value);
          break;
      }
    } else {
      elements.addLast(lastValue);
      elements.addLast(lastOperator);
      elements.addLast(value);
    }

    return elements;
  }
}
