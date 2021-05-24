package exercises.string;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindPermutationsTest {
  private FindPermutations findPermutations = new FindPermutations();

  @Test
  void findPermutations1() {
    final var actual = findPermutations.findAndReplacePattern(
      new String[] {"abc", "abcd", "cde", "xxx", "xxy", "xyy"},
      "xyz"
    );
    assertEquals( List.of("abc", "cde"), actual );
  }

  @Test
  void findPermutations2() {
    final var actual = findPermutations.findAndReplacePattern(
      new String[] {"abc","deq","mee","aqq","dkd","ccc"},
      "abb"
    );
    assertEquals( List.of("mee","aqq"), actual );
  }
}