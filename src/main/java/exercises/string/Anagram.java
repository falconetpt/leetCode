package exercises.string;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {
  public boolean isAnagram(String s, String t) {
    return Arrays.stream(s.split(""))
            .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()
            )).equals(
                    Arrays.stream(t.split(""))
                    .collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
  }
}
