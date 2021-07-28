package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionDisjTest {
  private PartitionDisj partitionDisj;

  @Before
  public void setUp() {
    partitionDisj = new PartitionDisj();
  }

  @Test
  public void partitionDisjoint_incresingTwoLengthArray_returns1() {
    assertEquals(1, partitionDisj.partitionDisjoint(new int[] { 0, 1 } ));
  }

  @Test
  public void partitionDisjoint_incresingThreeLengthArrayMiddleIsLowest_returns2() {
    assertEquals(2, partitionDisj.partitionDisjoint(new int[] { 2, 1, 3 } ));
  }

  @Test
  public void partitionDisjoint_returns3() {
    assertEquals(3, partitionDisj.partitionDisjoint(new int[] { 5,0,3,8,6 } ));
  }

  @Test
  public void partitionDisjoint_returns4() {
    assertEquals(4, partitionDisj.partitionDisjoint(new int[] { 1,1,1,0,6,12 } ));
  }

  @Test
  public void partitionDisjoint_returns7() {
    assertEquals(7, partitionDisj.partitionDisjoint(new int[] { 32,57,24,19,0,24,49,67,87,87 } ));
  }

  @Test
  public void partitionDisjoint_returns10() {
    assertEquals(11,
      partitionDisj.partitionDisjoint(new int[] { 29,33,6,4,42,0,10,22,62,16,46,75,100,67,70,74,87,69,73,88 } ));
  }
}