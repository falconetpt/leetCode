package exercises.array;

public class ConvertToTitle {
  public String convertToTitle(int columnNumber) {
    if (columnNumber == 0) {
      return "";
    } else {
      final var str = ((columnNumber -1) % 26) + 'A';
      return convertToTitle( (columnNumber-1) / 26 )
        + (char) str;
    }
  }
}
