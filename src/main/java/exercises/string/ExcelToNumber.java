package exercises.string;

public class ExcelToNumber {
  public int titleToNumber(final String columnTitle) {
    return titleToNumber(columnTitle, 0, columnTitle.length() - 1, 0);
  }

  private int titleToNumber(final String columnTitle, final int i,
                            final int mult, final int result) {
    if (i == columnTitle.length() - 1) {
      return result + charToInt(columnTitle.charAt(i));
    } else {
      return
        titleToNumber(columnTitle, i + 1, mult - 1,
          (int) Math.pow(26, mult) *  charToInt(columnTitle.charAt(i)) + result
        );
    }
  }

  private int charToInt(final char c) {
    return c - 'A' + 1;
  }
}
