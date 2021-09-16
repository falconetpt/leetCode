package exercises.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TurbulentArrayTest {
  private TurbulentArray turbulentArray;

  @Before
  public void setUp() throws Exception {
    turbulentArray = new TurbulentArray();
  }

  @Test
  public void maxTurbulenceSize1() {
    assertEquals(6, turbulentArray.maxTurbulenceSize(new int[] {2,0,2,4,2,5,0,1,2,3}));
  }

  @Test
  public void maxTurbulenceSize2() {
    assertEquals(5, turbulentArray.maxTurbulenceSize(new int[] {9,4,2,10,7,8,8,1,9}));
  }

  @Test
  public void maxTurbulenceSize3() {
    assertEquals(2, turbulentArray.maxTurbulenceSize(new int[] {4,8,12,16}));
  }

  @Test
  public void maxTurbulenceSize4() {
    assertEquals(5, turbulentArray.maxTurbulenceSize(new int[] {0,1,1,0,1,0,1,1,0,0}));
  }
}