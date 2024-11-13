package meetingRoom;

import java.util.HashSet;
import java.util.TreeSet;

public class Dota2Senate {
  public String predictPartyVictory(String senate) {
    if (senate.length() == 1) return getString(senate.charAt(0));

    final var direList = new TreeSet<Integer>();
    final var radiantList = new TreeSet<Integer>();
    final var removedIndex = new HashSet<Integer>();

    populateTree(senate, radiantList, direList);

    for (int i = 0; i < senate.length(); i++) {
      final var value = senate.charAt(i);

      final var nextPool = value == 'R'
          ? direList
          : radiantList;

      if (removedIndex.contains(i)) continue;
      if (nextPool.isEmpty()) return getString(value);

      final var nextIndex = nextPool.ceiling(i) == null
          ? nextPool.ceiling(0)
          : nextPool.ceiling(i);

      nextPool.remove(nextIndex);
      removedIndex.add(nextIndex);

      System.out.println("value = " + value);
      System.out.println("nextPool = " + nextPool);
      System.out.println("nextIndex = " + nextIndex);
    }

    final var sb = new StringBuilder();

    for (int i = 0; i < senate.length(); i++) {
      if (direList.contains(i)) sb.append('D');
      if (radiantList.contains(i)) sb.append('R');
    }

    return predictPartyVictory(sb.toString());
  }

  private static void populateTree(String senate, TreeSet<Integer> radiantList, TreeSet<Integer> direList) {
    for (int i = 0; i < senate.length(); i++) {
      final var value = senate.charAt(i);

      if (value == 'R') {
        radiantList.add(i);
      } else {
        direList.add(i);
      }
    }
  }

  private String getString(final char e) {
    return e == 'R' ? "Radiant" : "Dire";
  }
}
