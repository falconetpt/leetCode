package dp;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RotatedArray {
  public List<Integer> spiralOrder(int[][] matrix) {
    final var moves = new LinkedList<Pair>();
    moves.add(new Pair(0, 1));
    moves.add(new Pair(1, 0));
    moves.add(new Pair(0, -1));
    moves.add(new Pair(-1, 0));

    final var result = new ArrayList<Integer>();
    final var seen = new HashSet<Pair>();
    var remaining = matrix[0].length * matrix.length;

    var currentPoint = new Pair(0, 0);

    while (remaining > 0) {
      result.add(matrix[currentPoint.x][currentPoint.y]);
      seen.add(currentPoint);

      var nextMove = moves.peekFirst();

      var nextPoint = new Pair(currentPoint.x + nextMove.x, currentPoint.y + nextMove.y);

      remaining--;

      while (remaining > 0 && (seen.contains(nextPoint) || !valid(matrix, nextPoint))) {
        nextMove = moves.pollFirst();
        moves.addLast(nextMove);
        nextMove = moves.peekFirst();
        nextPoint = new Pair(currentPoint.x + nextMove.x, currentPoint.y + nextMove.y);
      }


      currentPoint = nextPoint;

    }

    return result;
  }

  private boolean valid(int[][] matrix, Pair nextPoint) {
    try {
      final var element = matrix[nextPoint.x][nextPoint.y];
      return true;
    } catch (Exception e) {
      return false;
    }
  }


  private record Pair(int x, int y) { }
}
