package exercises.u.exercises;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DividePlayers {
  public long dividePlayers(int[] skill) {

    if (skill.length == 2) return (long) skill[0] * skill[1]; // base case

    final var sum = Arrays.stream(skill).sum();
    final var avg = sum * 2 / skill.length;

    if (avg * skill.length < sum) return -1; // no avg value to match similar skill sets


    //System.out.println(avg);

    final var occurrences = Arrays
        .stream(skill)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


    long result = 0;

    Arrays.sort(skill);

    for (int i = 0; i < skill.length / 2; i++) {
      //System.out.println("=======");
      final var toLookFor = avg - skill[i];
      //System.out.println(toLookFor);
      //System.out.println(occurrences);
      final var requiredElements = toLookFor == skill[i]
          ? 1l
          : 0l;

      if (occurrences.getOrDefault(toLookFor, 0L) > requiredElements) {
        result += toLookFor * skill[i];
        occurrences.put(toLookFor, occurrences.get(toLookFor) - 1);
        occurrences.put(skill[i], occurrences.get(skill[i]) - 1);
      } else {
        return -1;
      }
    }

    return result;
  }
}
