package exercises.array.array;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Set<Pair>>  cache = new HashMap<>(  );
        Arrays.sort( nums );

        return getRanges(nums, cache);
    }

    private List<List<Integer>> getRanges(int[] nums, Map<Integer, Set<Pair>> cache) {
        Set<List<Integer>> result = new HashSet<>(  );

        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey( -nums[i] ) ) {

                for (Pair p : cache.get( -nums[i] )) {
                    if (p.indexOne > i) {
                        List<Integer> toAdd = new ArrayList<>(  );
                        toAdd.add( nums[i] );
                        toAdd.add( nums[p.indexOne] );
                        toAdd.add( nums[p.indexTwo] );
                        result.add(toAdd.stream().sorted().collect( Collectors.toList() ));
                    }
                }
            }
        }

        return new ArrayList<>( result );
    }

    private class Pair {
        private int indexOne;
        private int indexTwo;

        public Pair(int indexOne, int indexTwo) {
            this.indexOne = indexOne;
            this.indexTwo = indexTwo;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return indexOne == pair.indexOne &&
                    indexTwo == pair.indexTwo;
        }

        @Override
        public int hashCode() {
            return Objects.hash( indexOne, indexTwo );
        }
    }
}
