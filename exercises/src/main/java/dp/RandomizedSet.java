package dp;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {
  private final Random random;
  private final Set<Integer> set;

  public RandomizedSet() {
    set = new HashSet<>();
    random = new Random();
  }

  public boolean insert(int val) {
    if (set.contains(val)) return false;
    return set.add(val);
  }

  public boolean remove(int val) {
    if (set.contains(val)) return set.remove(val);
    return false;
  }

//  public int getRandom() {
//    return  set.stream().skip(random.nextLong(set.size()))
//        .findFirst()
//        .orElse(null);
//  }
}
