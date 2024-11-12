package meetingRoom;

public class CompressString {
  public int compress(char[] chars) {
    if (chars.length == 0) return 0;
    final var compressString = compressString(chars);

    fillArr(compressString, chars);

    return compressString.length();
  }

  private String compressString(char[] chars) {
    final var sb = new StringBuilder();
    var lastChar = chars[0];
    var count = 1;

    for (int i = 1; i < chars.length; i++) {
      final var currentElement = chars[i];

      if (currentElement == lastChar) {
        count++;
      } else {
        final var number = count == 1
            ? ""
            : String.valueOf(count);
        sb.append(lastChar + number);
        lastChar = currentElement;
        count = 1;
      }
    }

    final var number = count == 1
        ? ""
        : String.valueOf(count);
    sb.append(lastChar + number);

    return sb.toString();
  }

  private void fillArr(String string, char[] chars) {
    for (int i = 0; i < string.length(); i++) {
      chars[i] = string.charAt(i);
    }
  }
}
