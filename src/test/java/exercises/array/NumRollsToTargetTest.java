package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumRollsToTargetTest {

  private NumRollsToTarget numRollsToTarget;


  @Before
  public void setUp() throws Exception {
    numRollsToTarget = new NumRollsToTarget();
  }

  @Test
  public void numRollsToTarget_1_6_3() {
    assertEquals(1, numRollsToTarget.numRollsToTarget(1, 6, 3));
  }

  @Test
  public void numRollsToTarget_2_6_3() {
    assertEquals(2, numRollsToTarget.numRollsToTarget(2, 6, 3));
  }
}