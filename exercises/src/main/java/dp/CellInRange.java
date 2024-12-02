package dp;

import java.util.ArrayList;
import java.util.List;

public class CellInRange {
  public List<String> cellsInRange(String s) {
    final var arr = s.split(":");
    final var firstColumn = arr[0];
    final var secColumn = arr[1];
    final var firstLetter = firstColumn.charAt(0);
    final var secLetter = secColumn.charAt(0);
    final var firstRow = firstColumn.charAt(1);
    final var secRow = secColumn.charAt(1);
    final var result = new ArrayList<String>();

    for (int i = firstLetter; i <= secLetter; i++) {
      for (int j = firstRow; j <= secRow; j++) {
        final var col = (char) i;
        result.add(col + "" + (char) j);
      }
    }

    return result;
  }
}
