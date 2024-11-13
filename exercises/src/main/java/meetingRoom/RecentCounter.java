package meetingRoom;

import java.util.TreeSet;

class RecentCounter {
  private TreeSet<Integer> treeSet;

  public RecentCounter() {
    treeSet = new TreeSet<>();
  }

  public int ping(int t) {
    treeSet.add(t);

    return treeSet.subSet(t -3000, true, t, true).size();
  }
}
