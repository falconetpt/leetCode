package exercises.blind;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CombinationSumTest {
  private CombinationSum combinationSum;

  @Before
  public void setUp() throws Exception {
    combinationSum = new CombinationSum();
  }

  @Test
  public void combinationSum() {

    combinationSum.combinationSum(new int[] { 2,3,6,7 }, 7);
  }
}