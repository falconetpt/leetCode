package exercises.number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class CoinExchangeTest {
  private CoinExchange coinExchange;

  @BeforeEach
  private void setup() {
    coinExchange = new CoinExchange();
  }

  @Test
  void test1() {
    assertEquals(3, coinExchange.coinChange(new int[] {1,2,5}, 11));
  }

  @Test
  void test2() {
    assertEquals(20, coinExchange.coinChange(new int[] {186,419,83,408}, 6249));
  }

}