package exercises.array.array;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LexographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        return IntStream.rangeClosed(1, n).boxed()
                .sorted( Comparator.comparing( String::valueOf ) )
                .collect( Collectors.toList());
    }
}
