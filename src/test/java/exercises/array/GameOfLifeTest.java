package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameOfLifeTest {
  private GameOfLife gameOfLife;

  @Before
  public void setUp() throws Exception {
    gameOfLife = new GameOfLife();
  }

  @Test
  public void gameOfLife() {
    gameOfLife.gameOfLife(
      new int[][]{
        {0, 1, 0},
        {0, 0, 1},
        {1, 1, 1},
        {0, 0, 0}
      }
    );
  }
}