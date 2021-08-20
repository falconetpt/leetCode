package exercises.array;

public class MergeSorted {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    final var result = new int[nums1.length];

    var i1 = 0;
    var i2 = 0;

    while (i1 < m || i2 < n) {
      final var firstValue = i1 < m
        ? nums1[i1]
        : Integer.MAX_VALUE;
      final var secValue = i2 < n
        ? nums2[i2]
        : Integer.MAX_VALUE;

      if (firstValue < secValue) {
        result[i1+i2] = firstValue;
        i1++;
      } else {
        result[i1+i2] = secValue;
        i2++;
      }
    }
    for (int i = 0; i < result.length; i++) {
      nums1[i] = result[i];
    }
  }
}
