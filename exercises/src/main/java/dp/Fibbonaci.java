package dp;

import java.util.HashMap;
import java.util.Map;

public class Fibbonaci {
  public int fib(int n) {
    final var map = new HashMap<Integer, Integer>();
    map.put(0, 0);
    map.put(1, 1);

    return fib(n, map);
  }

  public int fib(int n, Map<Integer, Integer> map) {
    if(map.containsKey(n)) return map.get(n);
    final var result = fib(n -1, map) + fib(n-2, map);
    map.put(n, result);

    return result;
  }
}
