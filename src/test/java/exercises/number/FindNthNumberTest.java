package exercises.number;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class FindNthNumberTest {
  private FindNthNumber findNthNumber = new FindNthNumber();

  @Test
  void test1() {
    assertEquals(3, findNthNumber.findNthDigit(3));
  }

  @Test
  void test2() {
    assertEquals(9, findNthNumber.findNthDigit(9));
  }

  @Test
  void test3() {
    assertEquals(0, findNthNumber.findNthDigit(11));
  }

  @Test
  void test4() {
    assertEquals(1, findNthNumber.findNthDigit(10));
  }

}