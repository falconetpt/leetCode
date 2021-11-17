package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class LargestDivisibleSubsetTest {
  private LargestDivisibleSubset largestDivisibleSubset;

  @BeforeEach
  public void setup() {
    largestDivisibleSubset = new LargestDivisibleSubset();
  }

  @Test
  public void largestDivisibleSubset() {
    largestDivisibleSubset.largestDivisibleSubset(new int[] {1,4,8,3,2});
  }
}