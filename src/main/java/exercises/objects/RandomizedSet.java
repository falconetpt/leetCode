package exercises.objects;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {
  private final Set<Integer> set;
  private final Random random;

  public RandomizedSet() {
    set = new HashSet<>();
    random = new Random();
  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  public boolean insert(int val) {
    return set.add(val);
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  public boolean remove(int val) {
    return set.remove(val);
  }

  /** Get a random element from the set. */
  public int getRandom() {
    return set.toArray(Integer[]::new)[random.nextInt(set.size())];
  }
}
