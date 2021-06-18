package exercises.array;

import java.util.stream.IntStream;

class NumArray {

  private int[] baseNums;
  private int[] accumulatedNums;

  public NumArray(int[] baseNums) {
    this.baseNums = baseNums;
    accumulatedNums = createAccumulatedNums();
  }

  private int[] createAccumulatedNums() {
    final var result = new int[baseNums.length + 1];
    var total = 0;

    for (int i = 0, n = baseNums.length; i < n; i++) {
      total += baseNums[i];
      result[i + 1] = total;
    }

    return result;
  }

  public void update(int index, int val) {
    final var difference = val - baseNums[index];
    baseNums[index] = val;

    IntStream.range(index, baseNums.length)
      .forEach(i -> baseNums[i] += difference);
  }

  public int sumRange(int left, int right) {
    return accumulatedNums[right + 1] - accumulatedNums[left];
  }
}
