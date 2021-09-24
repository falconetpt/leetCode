package exercises.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PalindromePartitioning {
  public List<List<String>> partition(final String s) {
    final var result = Arrays.stream(s.split(""))
      .collect(Collectors.toCollection(ArrayList::new));

    return List.of();
  }
}
