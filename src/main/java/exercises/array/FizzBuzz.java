package exercises.array;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

  public List<String> fizzBuzz(int n) {
    final var map = new LinkedHashMap<Predicate<Integer>, String>();
    map.put((num) -> num % 3 == 0,  "Fizz");
    map.put((num) -> num % 5 == 0,  "Buzz");

    return IntStream.rangeClosed(1, n)
      .boxed()
      .map(num -> map.entrySet().stream().filter(e -> e.getKey().test(num)).map(e -> e.getValue()).reduce(String::concat).orElse(String.valueOf(num)))
      .collect(Collectors.toList());

  }
}
