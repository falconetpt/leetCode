package exercises.u.exercises;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AutoCompleteSystemTest {
  private AutoCompleteSystem autoCompleteSystem;

  @Test
  public void test() throws Exception {
    autoCompleteSystem = new AutoCompleteSystem(
        new String[]{"i love you", "island", "iroman", "i love leetcode"},
        new int[] { 5, 3, 2, 2 }
    );

    final var search = autoCompleteSystem.search("i");
    System.out.println("search = " + Arrays.toString(search));
    final var search2 = autoCompleteSystem.search("i ");
    System.out.println("search = " + Arrays.toString(search2));
  }
}