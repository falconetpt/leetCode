package exercises.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StraightHand {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W == 0) {
            PriorityQueue<Integer> sorted = Arrays.stream(hand).boxed()
                    .collect( Collectors.toCollection( PriorityQueue::new));
            return isNStraightHand( sorted.peek(), sorted, W );
        } else {
            return false;
        }
    }

    private boolean isNStraightHand(Integer prev, PriorityQueue<Integer> sorted, int w) {
        if (sorted.isEmpty()) {
            return true;
        } else {
            boolean result = IntStream.rangeClosed( prev, prev + w - 1 ).allMatch( sorted::remove );

            return result && isNStraightHand( sorted.peek(), sorted, w );
        }
    }
}
