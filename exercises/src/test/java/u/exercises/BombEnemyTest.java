package u.exercises;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class BombEnemyTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void bombEnemy() {
    final var input =  new String[][] {
        {"0","E","0","0"},
        {"E","0","W","E"},
        {"0","E","0","0"},
    };

    final var input2 =  new String[][] {
        {"W","W","W"},
        {"0","0","0"},
        {"E","E","E"},
    };


    final var value1 = new BombEnemy().bombEnemy(input);

    assertEquals(3, value1);
    final var value2 = new BombEnemy().bombEnemy(input2);
    assertEquals(1, value2);
  }
}