package exercises.string;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class GenerateValidParenthesisTest {

  @Test
  public void generateParenthesis() {
    final var expected = Stream.of(
      "()()()()","(()(()))","(()())()","()()(())",
      "(((())))","(())()()","()((()))","()(())()","()(()())","(()()())","((()()))","((()))()","((())())"
    ).sorted()
      .collect(Collectors.toList());
    assertEquals(expected, new GenerateValidParenthesis().generateParenthesis(4).stream().sorted().collect(Collectors.toList()));
  }
}