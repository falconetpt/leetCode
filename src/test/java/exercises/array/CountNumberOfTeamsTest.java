package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountNumberOfTeamsTest {
  private CountNumberOfTeams countNumberOfTeams;

  @Before
  public void setUp() throws Exception {
    countNumberOfTeams = new CountNumberOfTeams();
  }

  @Test
  public void numTeams_randomNums() {
    assertEquals(3, countNumberOfTeams.numTeams(new int[]{ 2, 5, 3, 4, 1}));
  }

  @Test
  public void numTeams_randomNums2() {
    assertEquals(0, countNumberOfTeams.numTeams(new int[]{ 2, 1, 3 }));
  }
}