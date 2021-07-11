package exercises.array.array;

import java.util.stream.IntStream;

class NumArray {

  private int[] baseNums;
  private int[] accumulatedNums;

  public NumArray(int[] baseNums) {
    this.baseNums = baseNums;
    accumulatedNums = createAccumulatedNums();
  }

  private int[] createAccumulatedNums() {
    final var result = new int[baseNums.length];
    var total = 0;

    for (int i = 0, n = baseNums.length; i < n; i++) {
      total += baseNums[i];
      result[i] = total;
    }

    return result;
  }

  public void update(int index, int val) {
    final var difference = val - baseNums[index];
    baseNums[index] = val;

    IntStream.range(index, baseNums.length)
      .forEach(i -> accumulatedNums[i] += difference);
  }

  public int sumRange(int left, int right) {
    if (left == right) return baseNums[left];
    return accumulatedNums[right] - accumulatedNums[left] + accumulatedNums[left];
  }
}
