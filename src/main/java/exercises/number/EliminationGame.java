package exercises.number;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EliminationGame {
  public int lastRemaining(final int n) {
    final var list = IntStream.rangeClosed(1, n)
      .boxed()
      .collect(Collectors.toList());

    return lastRemaining(list, 0);
  }

  private int lastRemaining(final List<Integer> list, final int remainder) {
    if (list.size() == 1) {
      return list.get(0);
    } else {
      System.out.println("list.get(0) = " + list.get(0));
      System.out.println("list.get(list.size() - 1) = " + list.get(list.size() - 1));
      if (remainder == 0) {
        removeBeginningToEnd(list);
      } else {
        removeEndToBeginning(list);
      }

      return lastRemaining(list, (remainder + 1) % 2);
    }
  }

  private void removeBeginningToEnd(final List<Integer> list) {
    final var valuesToRemove = new ArrayList<Integer>();
    for (int i = 0; i < list.size(); i += 2) {
      valuesToRemove.add(list.get(i));
    }
    list.removeAll(valuesToRemove);
  }

  private void removeEndToBeginning(final List<Integer> list) {
    final var valuesToRemove = new ArrayList<Integer>();
    for (int i = list.size() - 1; i >= 0 ; i -= 2) {
      valuesToRemove.add(list.get(i));
    }
    list.removeAll(valuesToRemove);
  }
}
