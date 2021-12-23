package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindOrderTest {
  private FindOrder findOrder;

  @Before
  public void setUp() throws Exception {
    findOrder = new FindOrder();
  }

  @Test
  public void findOrder() {
    findOrder.findOrder(3,
      new int[][] {{0,1}, {0,2}, {1,2}});
  }
}