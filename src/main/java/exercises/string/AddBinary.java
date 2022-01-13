package exercises.string;

public class AddBinary {
  public String addBinary(final String a,
                          final String b) {
    final var result = convertNumeric(a) + convertNumeric(b);
    return convertToBinary(result, new StringBuilder());
  }

  private String convertToBinary(final int result, final StringBuilder stringBuilder) {
    if (result == 0) {
      return stringBuilder.reverse()
        .toString();
    } else {
      stringBuilder.append(result % 2);
      return convertToBinary(result / 2, stringBuilder);
    }
  }

  private int convertNumeric(final String a) {
    var counter = 0;
    var result = 0;

    for (int i = a.length() - 1; i >= 0; i--) {
      if (a.charAt(i) == '1') result += Math.pow(2, counter);
      counter++;
    }

    return result;
  }
}
