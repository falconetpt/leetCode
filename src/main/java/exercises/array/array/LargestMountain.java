package exercises.array.array;

import java.util.stream.IntStream;

public class LargestMountain {
    public int longestMountain(int[] arr) {
        return IntStream.range( 1, arr.length - 1 )
                .filter( i -> arr[i-1] < arr[i] && arr[i] > arr[i+1] )
                .map( i -> expandValue(arr, i) )
                .max()
                .orElse( 0 );
    }

    private int expandValue(int[] arr, int i) {
        int minIndex = i - 1;
        int maxIndex = i + 1;

        while (minIndex -1 >= 0 && arr[minIndex-1] < arr[minIndex]) {
            minIndex--;
        }

        while (maxIndex + 1 < arr.length && arr[maxIndex] > arr[maxIndex + 1]) {
            maxIndex++;
        }

        return maxIndex - minIndex + 1;
    }
}
