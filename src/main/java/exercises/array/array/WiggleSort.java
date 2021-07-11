package exercises.array.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        LinkedList<Integer> sortedNums = Arrays.stream(nums).boxed()
                .sorted()
                .collect( Collectors.toCollection( LinkedList::new ));

        wiggleSort( sortedNums, nums, true, 0 );
    }

    private void wiggleSort(LinkedList<Integer> sortedNums, int[] nums, boolean first, int i) {
        if (!sortedNums.isEmpty()) {
            int nextElement = first ? sortedNums.pollFirst() : sortedNums.pollLast();

            nums[i] = nextElement;

            wiggleSort( sortedNums, nums, !first, i + 1 );
        }
    }
}
