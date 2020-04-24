package exercises.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        List<LinkedList<Integer>> newNums = new ArrayList<>();
        nums.forEach(e -> newNums.add(new LinkedList<>(e)));

        return smallestRange(newNums, Integer.MAX_VALUE, 0, 0);
    }

    private int[] smallestRange(List<LinkedList<Integer>> nums, int smallestRange, int start, int end) {
        int maxValue = nums.stream().map(LinkedList::peekFirst).filter(Objects::nonNull)
                .max(Integer::compareTo).orElse(Integer.MAX_VALUE);
        int minValue = nums.stream().map(LinkedList::peekFirst).filter(Objects::nonNull)
                .min(Integer::compareTo).orElse(Integer.MIN_VALUE);

        int currentRange = maxValue - minValue;
        int newRange = Math.min(currentRange, smallestRange);
        int newStart = newRange == smallestRange ? start : minValue;
        int newEnd = newRange == smallestRange ? end : maxValue;

        if (isValidEvaluation(nums)) {
            if(nums.stream().filter(x -> x.size() == 1).anyMatch(x -> x.peekFirst() == minValue)
                    && newRange == smallestRange) {
                return new int[] { newStart, newEnd };
            } else {
                popMinValueFromList(nums);
                return smallestRange(nums, newRange, newStart, newEnd);
            }
        } else {
            return new int[] { newStart, newEnd };
        }
    }

    private void popMinValueFromList(List<LinkedList<Integer>> nums) {
        nums.stream().filter(x -> x.size() > 1)
                .reduce((a, b) -> a.peekFirst().compareTo(b.peekFirst()) < 0 ? a : b)
                .ifPresent(LinkedList::pop);
    }

    private boolean isValidEvaluation(List<LinkedList<Integer>> nums) {
        return nums.stream().anyMatch(x -> x.size() > 1);
    }

    /**
     * https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
     *
     * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
     *
     *
     *
     * Example 1:
     *
     * Input: [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
     * Output: [20,24]
     * Explanation:
     * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
     * List 2: [0, 9, 12, 20], 20 is in range [20,24].
     * List 3: [5, 18, 22, 30], 22 is in range [20,24].
     *
     *
     * Note:
     *
     * The given list may contain duplicates, so ascending order means >= here.
     * 1 <= k <= 3500
     * -105 <= value of elements <= 105.
     */
}
