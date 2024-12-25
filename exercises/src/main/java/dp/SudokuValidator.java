package dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.IntStream;

public class SudokuValidator {
  public boolean isValidSudoku(char[][] board) {
    final var rowMap = new HashMap<Integer, Set<Integer>>();
    final var colMap = new HashMap<Integer, Set<Integer>>();
    final var boxMap = new HashMap<Pair, Set<Integer>>();
    final var emptyValues = new LinkedList<Pair>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        final var element = board[i][j];
        if (element != '.') {
          rowMap.putIfAbsent(i, new HashSet<>());
          colMap.putIfAbsent(j, new HashSet<>());
          final var boxPair = getBoxPair(i, j);
          boxMap.putIfAbsent(boxPair, new HashSet<>());
          final var numeric = Character.getNumericValue(element);
          if (rowMap.get(i).contains(numeric)) return false;
          if (colMap.get(j).contains(numeric)) return false;
          if (boxMap.get(boxPair).contains(numeric)) return false;
          rowMap.get(i).add(numeric);
          colMap.get(j).add(numeric);
          boxMap.get(boxPair).add(numeric);
        } else {
          emptyValues.addLast(new Pair(i, j));
        }
      }
    }

    return true;

  }

  private static Pair getBoxPair(int i, int j) {
    return new Pair(i / 3, j / 3);
  }

  private record Pair(int row, int col) {}
}
