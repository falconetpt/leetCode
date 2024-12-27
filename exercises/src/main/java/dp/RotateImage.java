package dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RotateImage {
  public void rotate(int[][] matrix) {
    final var linkedList = new LinkedList<LinkedList<Integer>>();

    for (int i = 0; i < matrix.length; i++) {
      final var localList = new LinkedList<Integer>();
      for (int j = 0; j < matrix[0].length; j++) {
        localList.add(matrix[i][j]);
      }
      linkedList.addFirst(localList);
    }

    for (int i = 0; i < matrix[0].length; i++) {
      final var list = linkedList.pollFirst();
      for (int j = 0; j < matrix.length; j++) {
        matrix[j][i] = list.pollFirst();
      }
    }
  }
}
