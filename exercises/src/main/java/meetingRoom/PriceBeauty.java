package meetingRoom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class PriceBeauty {
  public int[] maximumBeauty(int[][] items, int[] queries) {
    final var beautyTree = createBeautyMap(items);

    final var result = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {
      final var price = queries[i];
      final var maxBeauty = beautyTree.floorEntry(price);

      if (maxBeauty != null) {
        result[i] = maxBeauty.getValue();
      }
    }

    return result;
  }

  private static TreeMap<Integer, Integer> createBeautyMap(int[][] items) {
    final Comparator<int[]> comparingPrice = Comparator.comparing(a -> a[0]);
    final Comparator<int[]> comparingBeauty = comparingPrice.thenComparing(a -> -a[1]);

    Arrays.sort(items, comparingBeauty);
    final var beautyTree = new TreeMap<Integer, Integer>();
    var max = Integer.MIN_VALUE;

    for (int i = 0; i < items.length; i++) {
      final var element = items[i];
      final var price = element[0];
      final var beauty = element[1];

      if (beauty > max) {
        max = beauty;
        beautyTree.put(price, Math.max(beautyTree.getOrDefault(price, 0), beauty));
      }
    }

    return beautyTree;
  }
}
