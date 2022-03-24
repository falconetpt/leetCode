package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumRescueBoatsTest {
  private NumRescueBoats numRescueBoats;

  @Before
  public void setUp() throws Exception {
    numRescueBoats = new NumRescueBoats();
  }

  @Test
  public void numRescueBoats() {
    assertEquals(1, numRescueBoats.numRescueBoats(new int[] {1, 2}, 3));
  }
}