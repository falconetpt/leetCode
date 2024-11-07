package u.exercises;

public class CountHillsValeys {
  public int countHillValley(int[] nums) {
    var hills = 0;
    var valleys = 0;
    var right = 0;

    for (int i = 1; i + right < nums.length - 1; i++) {
      int currentElement = nums[i + right];
      int prevElement = nums[i + right - 1];
      int nextElement = nums[i + right + 1];

      while (currentElement == nextElement && (i + right + 2) < nums.length) {
        right++;
        currentElement = nums[i + right];
        nextElement = nums[i + right + 1];
      }

      if (currentElement > prevElement && currentElement > nextElement) hills++;
      if (currentElement < prevElement && currentElement < nextElement) valleys++;

    }

    return hills + valleys;
  }
}
