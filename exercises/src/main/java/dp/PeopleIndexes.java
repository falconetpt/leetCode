package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PeopleIndexes {
  public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
    final var result = new ArrayList<Integer>();
    final var seen = new ArrayList<Set<String>>();

    for(int i = 0; i < favoriteCompanies.size(); i++) {
      final var element = new HashSet<>(favoriteCompanies.get(i));

      if (seen.stream().noneMatch(s -> s.containsAll(element))) {
        result.add(i);
      }

      seen.add(element);
    }

    return result;
  }
}
