package exercises.array;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class PermutateUniqueTest {
  private PermutateUnique permutateUnique;

  @Before
  public void setUp() throws Exception {
    permutateUnique = new PermutateUnique();
  }

  @Test
  public void permuteUnique1() {
    assertEquals(
      Set.of(List.of(1)),
      new HashSet<>(permutateUnique.permuteUnique(new int[] {1}))
    );
  }

  @Test
  public void permuteUnique2() {
    assertEquals(
      Set.of(List.of(1, 1)),
      new HashSet<>(permutateUnique.permuteUnique(new int[] {1, 1}))
    );
  }

  @Test
  public void permuteUnique3() {
    assertEquals(
      Set.of(List.of(1, 2), List.of(2, 1)),
      new HashSet<>(permutateUnique.permuteUnique(new int[] {1, 2}))
    );
  }

}