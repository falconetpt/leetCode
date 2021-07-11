package exercises.array.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PartitionDisjoint {
    public int partitionDisjoint(int[] A) {
        Map<Integer, Long> map = Arrays.stream(A).boxed()
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) );
        PriorityQueue<Integer> priorityQueue = Arrays.stream( A ).boxed().distinct()
                .collect( Collectors.toCollection( PriorityQueue::new ) );

        return determineLengthLeft(A, 0, map, priorityQueue, new ArrayList<>(  ), Integer.MIN_VALUE );
    }

    private int determineLengthLeft(int[] a, int index,
                                    Map<Integer, Long> map, PriorityQueue<Integer> priorityQueue,
                                    List<Integer> result,
                                    int max) {
        if (result.size() > 0 && (priorityQueue.isEmpty() || max <= priorityQueue.peek()) ) {
            return result.size();
        } else {
            int countValues = map.get( a[index] ).intValue();

            if (countValues > 0) {
                map.put( a[index], (long) (countValues - 1) );
                result.add( a[index] );
            } else {
                result.add( a[index] );
            }

            if(countValues - 1 == 0) {
                priorityQueue.remove( a[index] );
            }

            return determineLengthLeft( a, index + 1, map, priorityQueue, result, Math.max( max, a[index] ));
        }
    }

    /**
     * https://leetcode.com/problems/partition-array-into-disjoint-intervals/submissions/
     *
     * Given an array A, partition it into two (contiguous) subarrays left and right so that:
     *
     * Every element in left is less than or equal to every element in right.
     * left and right are non-empty.
     * left has the smallest possible size.
     * Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.
     *
     *
     *
     * Example 1:
     *
     * Input: [5,0,3,8,6]
     * Output: 3
     * Explanation: left = [5,0,3], right = [8,6]
     * Example 2:
     *
     * Input: [1,1,1,0,6,12]
     * Output: 4
     * Explanation: left = [1,1,1,0], right = [6,12]
     *
     *
     * Note:
     *
     * 2 <= A.length <= 30000
     * 0 <= A[i] <= 10^6
     * It is guaranteed there is at least one way to partition A as described.
     *
     * ========================================================================
     *
     * Solution of leetCode pretty amazing, i was doing the same idea but with a priority queue :) :
     *
     * public int partitionDisjoint(int[] A) {
     *         int N = A.length;
     *         int[] maxleft = new int[N];
     *         int[] minright = new int[N];
     *
     *         int m = A[0];
     *         for (int i = 0; i < N; ++i) {
     *             m = Math.max(m, A[i]);
     *             maxleft[i] = m;
     *         }
     *
     *         m = A[N-1];
     *         for (int i = N-1; i >= 0; --i) {
     *             m = Math.min(m, A[i]);
     *             minright[i] = m;
     *         }
     *
     *         for (int i = 1; i < N; ++i)
     *             if (maxleft[i-1] <= minright[i])
     *                 return i;
     *
     *         throw null;
     *     }
     */
}
