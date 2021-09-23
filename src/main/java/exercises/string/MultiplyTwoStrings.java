package exercises.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class MultiplyTwoStrings {
  public String multiply(final String num1, final String num2) {
    final var num1List = convertStringToNumArray(num1);
    final var num2List = convertStringToNumArray(num2);

    return sumNumbers(
      num1List, num2List,
      num2List.size() - 1, 0, new LinkedList<>()
    );

  }


  private String sumStrings(final String str1, final String str2) {
    var remainder = 0;
    var result = new StringBuffer();

    for (int i = 0; i < Math.max(str1.length(), str2.length()); i++) {
      final var str1Index = str1.length() - i -1;
      final var str2Index = str2.length() - i -1;
      final var value1 = str1Index >= 0
        ? str1.charAt(str1Index) - '0'
        : 0;
      final var value2 = str2Index >= 0
        ? str2.charAt(str2Index) - '0'
        : 0;

      final var newValue = value1 + value2 + remainder;
      result.insert(0, newValue % 10);
      remainder = newValue / 10;
    }

    return result.toString();
  }

  private String sumNumbers(final List<Integer> num1List,
                            final List<Integer> num2List,
                            final int index2,
                            final int multiplier,
                            final LinkedList<String> integers) {
    if (index2 < 0) {
      return integers.stream()
        .reduce("0", this::sumStrings);
    } else {
      final var num2 = num2List.get(index2);
      var remainder = 0;
      final var total = new StringBuilder();

      for (int i = num1List.size() - 1; i >= 0; i--) {
        System.out.println(num2);
        System.out.println(num1List.get(i));
        final var number = num2 * num1List.get(i) + remainder;
        total.insert(0, number % 10);
        remainder = number / 10;
      }

      IntStream.range(0, multiplier).forEach(i -> total.append(0));
      integers.add(total.toString());

      return sumNumbers(num1List, num2List, index2 - 1, multiplier + 1, integers);
    }
  }

  private List<Integer> convertStringToNumArray(final String numbers) {
    final var result = new ArrayList<Integer>();

    for (final var number : numbers.toCharArray()) {
      result.add(number - '0');
    }

    return result;
  }
}
