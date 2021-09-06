package exercises.objects;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LRUCache {
  private final int capacity;
  private final PriorityQueue<CacheInfo> lestRecentlyUsed;
  private final Map<Integer, CacheInfo> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.lestRecentlyUsed = new PriorityQueue<>(Comparator.comparing(CacheInfo::getUses));
    this.map = new HashMap<>();
  }

  public int get(int key) {
    final var element = map.getOrDefault(key, new CacheInfo(0, -1));
    final var value = element.getValue();
    lestRecentlyUsed.remove(element);
    lestRecentlyUsed.add(element);
    return value;
  }

  public void put(int key, int value) {
    final var cacheInfo = new CacheInfo(key, value);
    if (map.containsKey(key)) {
      map.put(key, cacheInfo);
    } else {
      System.out.println(map.size());
      if (map.size() == capacity) {
        final var element = lestRecentlyUsed.poll();
        map.remove(element.key);
      }
      map.put(key, cacheInfo);
      lestRecentlyUsed.add(cacheInfo);
    }
  }

  private class CacheInfo {
    private int uses;
    private int key;
    private int value;

    public CacheInfo(final int key, final int value) {
      this.key = key;
      this.uses = 0;
      this.value = value;
    }

    public int getUses() {
      return uses;
    }

    public void setUses(final int uses) {
      this.uses = uses;
    }

    public int getKey() {
      return key;
    }

    public void setKey(final int key) {
      this.key = key;
    }

    public int getValue() {
      uses++;
      return value;
    }

    public void setValue(final int value) {
      this.value = value;
    }
  }
}
