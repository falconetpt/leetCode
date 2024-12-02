package dp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BalanceCheckTest {
  final BalanceCheck balanceCheck = new BalanceCheck();

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void payback() {
    final var result = balanceCheck.payback(new int[][]{
        {0,1,10},
        {2,0,5}
    });

    assertEquals(2, result);

    final var result2 = balanceCheck.payback(new int[][]{
        {0,1,10},
        {1,0,1},
        {1,2,5},
        {2,0,5}
    });

    assertEquals(1, result2);
  }
}