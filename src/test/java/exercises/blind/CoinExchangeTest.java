package exercises.blind;


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
  public void test() {
    coinExchange.coinChange(new int[]{1, 2, 5 }, 11);
  }
}