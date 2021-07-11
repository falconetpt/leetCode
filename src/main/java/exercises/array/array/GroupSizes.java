package exercises.array.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupSizes {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        return groupThePeople( groupSizes, 0, new HashMap<>(), new ArrayList<>(  ) );
    }

    private List<List<Integer>> groupThePeople(int[] groupSizes,
                                               int i,
                                               Map<Integer, List<Integer>> frequency,
                                               List<List<Integer>> result) {
        if (i >= groupSizes.length) {
            return result;
        } else {
            int groupSize = groupSizes[i];
            frequency.putIfAbsent( groupSize, new ArrayList<>(  ) );
            List<Integer> indexesWithGroupSize = frequency.get( groupSize );
            indexesWithGroupSize.add( i );

            if (frequency.get( groupSize ).size() == groupSize) {
                result.add( indexesWithGroupSize );
                frequency.remove( groupSize );
            }

            return groupThePeople( groupSizes, i + 1, frequency, result );
        }
    }
}
