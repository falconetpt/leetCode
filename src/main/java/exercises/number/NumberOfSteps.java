package exercises.number;

public class NumberOfSteps {
  public int numberOfSteps (int num) {
    if (num == 1) {
      return 1;
    } else {
      return num % 2 == 0
              ? 1 + numberOfSteps(num / 2)
              : numberOfSteps(num - 1);
    }
  }
}
