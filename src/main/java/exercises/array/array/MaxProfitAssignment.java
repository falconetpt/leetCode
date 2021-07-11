package exercises.array.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxProfitAssignment {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer, Integer> association = new HashMap<>(  );
        IntStream.range( 0, difficulty.length ).boxed()
                .forEach( i -> association
                        .put( profit[i], Math.min( difficulty[i],
                                association.getOrDefault( profit[i], Integer.MAX_VALUE ) ) ));

        LinkedList<Integer> profitList = Arrays.stream( profit ).boxed()
                .sorted( (a, b) -> - a.compareTo( b ) )
                .collect( Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> workerList = Arrays.stream( worker ).boxed()
                .sorted( (a, b) -> - a.compareTo( b ) )
                .collect( Collectors.toCollection(LinkedList::new));


        return maxProfit(workerList, profitList, association, 0);
    }

    private int maxProfit(LinkedList<Integer> workerList,
                          LinkedList<Integer> profitList,
                          Map<Integer, Integer> association,
                          int result) {
        if (workerList.isEmpty() || profitList.isEmpty()) {
            return result;
        } else {
            int nextProfit = profitList.peekFirst();
            int nextWorker = workerList.peekFirst();

            if (association.get( nextProfit ) > nextWorker) {
                profitList.pop();
                return maxProfit( workerList, profitList, association, result );
            } else {
                workerList.pop();
                return maxProfit( workerList, profitList, association, result + nextProfit );
            }
        }
    }
}
