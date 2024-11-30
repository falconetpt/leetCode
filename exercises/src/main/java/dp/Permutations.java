package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Permutations {
  public List<List<Integer>> permute(int[] nums) {
    if (nums.length == 0) return new ArrayList<>();
    final var numbers = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
    return permute(numbers, new ArrayList<Integer>(), new ArrayList<List<Integer>>());
  }

  private List<List<Integer>> permute(HashSet<Integer> numbers, ArrayList<Integer> integers, ArrayList<List<Integer>> result) {
    if (numbers.isEmpty()) {
      result.add(integers);
      return result;
    } else {
      for (final var number : numbers) {
        final var newNumbers = new HashSet<>(numbers);
        newNumbers.remove(number);
        final var newList = new ArrayList<>(integers);
        newList.add(number);
        permute(newNumbers, newList, result);
      }

      return result;
    }
  }
}
