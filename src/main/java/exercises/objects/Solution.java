package exercises.objects;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    private Map<Integer, List<Integer>> list;
    Random randomizer = new Random();

    public Solution(int[] nums) {
        list = new HashMap<>(  );
        IntStream.range( 0, nums.length ).forEach( i -> {
            list.putIfAbsent( nums[i], new ArrayList<>(  ) );
            list.get( nums[i] ).add( i );
        } );
    }

    public int pick(int target) {
        List<Integer> localList = list.get(target);

        return localList.get(randomizer.nextInt(localList.size()));
    }
}
