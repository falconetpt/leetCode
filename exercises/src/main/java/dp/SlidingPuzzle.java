package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SlidingPuzzle {
  private final static List<int[]> MOVES = List.of(
      new int[] { 0, 1 },

      new int[] { 1, 0 },
      new int[] { -1, 0 },
      new int[] { 0, -1 }
  );

  public int slidingPuzzle(int[][] board) {
    final var cache = new HashMap<String, Integer>();

    final var zeroIndex =  getZeroIndex(board);

    return getMoves(board, cache, zeroIndex, 0);
  }

  private int getMoves(int[][] board, HashMap<String, Integer> cache, int[] zeroIndex, int count) {
    final var boardHash = IntStream.range(0, board.length)
        .boxed()
        .map(i -> Arrays.toString(board[i]))
        .collect(Collectors.joining(","));

    if (cache.containsKey(boardHash)) return cache.get(boardHash);
    if (isSorted(board, zeroIndex)) return count;

    var min = Integer.MAX_VALUE;

    cache.put(boardHash, -1);


    for (final var move : MOVES) {
      final var nextRow = zeroIndex[0] + move[0];
      final var nextCol = zeroIndex[1] + move[1];
      System.out.println("-------");
      System.out.println("Zero index: " + zeroIndex[0] + ":" + zeroIndex[1]);
      System.out.println("Move index: " + move[0] + ":" + move[1]);


      System.out.println(boardHash);
      System.out.println(nextRow + ":" + nextCol);
      System.out.println(cache);
      System.out.println(nextRow >= 0 && nextRow < board.length
          && nextCol >= 0 && nextCol < board[nextRow].length);


      if (nextRow >= 0 && nextRow < board.length
          && nextCol >= 0 && nextCol < board[nextRow].length) {
        final var element = board[nextRow][nextCol];
        board[zeroIndex[0]][zeroIndex[1]] = element;
        board[nextRow][nextCol] = 0;

        final var next = getMoves(board, cache, new int[] { nextRow, nextCol }, count + 1);

        board[zeroIndex[0]][zeroIndex[1]] = 0;
        board[nextRow][nextCol] = element;

        System.out.println("next" + next);

        if (next != -1) min = Math.min(min, 1 + next);
        if (next == 0) return 1;
      }
    }

    System.out.println("-----TopLevel:" + boardHash);
    final var value = min == Integer.MAX_VALUE
        ? -1
        : min;

    cache.put(boardHash, value);

    return value;
  }

  private int[] getZeroIndex(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 0) return new int[] { i, j };
      }
    }

    return new int[] { -1, -1 };
  }


  private boolean isSorted(final int[][] board, final int[] zeroIndex) {
    if (zeroIndex[0] != 1 || zeroIndex[1] !=  2) return false;
    var next = 1;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (next % 6 == board[i][j]) {
          next++;
        } else {
          return false;
        }
      }
    }

    return true;
  }
}
