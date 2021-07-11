package exercises.array.array;

import java.util.LinkedList;

public class NumSubArrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        LinkedList<Integer> result = new LinkedList<>(  );

        return numOfSubarrays(arr, k, threshold, result, 0, 0);
    }

    private int numOfSubarrays(int[] arr, int k, int threshold,
                               LinkedList<Integer> result, int runningSum, int i) {
        if (i >= arr.length) {
            return runningSum / k >= threshold ? 1 : 0;
        } else {
            if (result.size() < k) {
                result.add( arr[i] );
                return numOfSubarrays( arr, k, threshold, result, runningSum + arr[i], i + 1 );
            } else {
                int latest = result.pollFirst();
                int valid = runningSum / k >= threshold ? 1 : 0;
                result.add( arr[i] );
                return valid
                        + numOfSubarrays( arr, k, threshold, result, runningSum + arr[i] - latest, i + 1 );
            }
        }
    }
}
