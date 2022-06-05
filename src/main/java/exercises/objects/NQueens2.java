package exercises.objects;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class NQueens2 {
  private Set<Integer> col = new HashSet<>();
  private Set<Integer> diag1 = new HashSet<>();
  private Set<Integer> diag2 = new HashSet<>();
  private AtomicInteger result = new AtomicInteger(0);

  public int totalNQueens(int n) {
    dfs(0, n);
    return result.get();
  }


  private void dfs(int row, int n){
    if (row == n){
      result.incrementAndGet();
      return;
    }
    for (int i = 0; i < n; i++){
      if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) continue;

      col.add(i);
      diag1.add(row + i);
      diag2.add(row - i);

      dfs(row + 1, n);

      col.remove(i);
      diag1.remove(row + i);
      diag2.remove(row - i);
    }
  }
}
