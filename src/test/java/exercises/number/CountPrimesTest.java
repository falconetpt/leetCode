package exercises.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountPrimesTest {
  private CountPrimes countPrimes = new CountPrimes();

  @Test
  void countPrimes_1() {
    assertEquals( 0, countPrimes.countPrimes( 0 ) );
  }

  @Test
  void countPrimes_2() {
    assertEquals( 0, countPrimes.countPrimes( 1 ) );
  }

  @Test
  void countPrimes_3() {
    assertEquals( 0, countPrimes.countPrimes( 2 ) );
  }

  @Test
  void countPrimes_4() {
    assertEquals( 4, countPrimes.countPrimes( 10 ) );
  }
}