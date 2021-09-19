package exercises.array;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CandidateSumTest {
  private CandidateSum candidateSum;

  @Before
  public void setUp() throws Exception {
    candidateSum = new CandidateSum();
  }

  @Test
  public void combinationSum2() {
    assertEquals(List.of(), candidateSum.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
  }
}