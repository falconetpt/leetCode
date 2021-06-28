package exercises.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinExchangeTest {
  @Test
  void test1() {
    assertEquals( 20, new CoinExchange().coinChange( new int[] {186,419,83,408}, 6249 ) );
  }
}