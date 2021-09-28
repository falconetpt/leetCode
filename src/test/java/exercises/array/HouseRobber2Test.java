package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseRobber2Test {
  private HouseRobber2 houseRobber2;

  @Before
  public void setUp() throws Exception {
    houseRobber2 = new HouseRobber2();
  }

  @Test
  public void rob() {
    assertEquals(3, houseRobber2.rob(new int[] { 1, 1, 1, 2}));
  }
}