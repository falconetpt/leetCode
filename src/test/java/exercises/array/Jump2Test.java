package exercises.array;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Jump2Test {
  final Jump2 jump2 = new Jump2();

  @Test
  public void emptyArray_shouldReturn0() {
    assertEquals(0, jump2.jump(new int[] {}));
  }

  @Test
  public void singleElementArray_shouldReturn1() {
    assertEquals(0, jump2.jump(new int[] {2}));
  }

  @Test
  public void singleElementArray_shouldReturn0() {
    assertEquals(0, jump2.jump(new int[] {1}));
  }

  @Test
  public void multipleElementArray_shouldReturn2() {
    assertEquals(2, jump2.jump(new int[] {2,3,0,1,4}));
  }
  @Test
  public void multipleElementArray_shouldReturn1() {
    assertEquals(2, jump2.jump(new int[] {1,2,3}));
  }
}