package exercises.array;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PascalTriangle {
    public List<Integer> getRow(int rowIndex) {
        List[] result = new List[rowIndex + 1];
        result[0] = Arrays.asList(1);

        getTriangle( rowIndex, 1, result );

        return result[rowIndex];
    }

    private List<Integer>[] getTriangle(int maxIndex, int currentIndex, List<Integer>[] result) {
        if (currentIndex > maxIndex) {
            return result;
        } else {
            result[currentIndex] = IntStream.range( 0, currentIndex + 1 ).boxed()
                    .map( i -> calculateNumber(i, result[currentIndex-1]) )
                    .collect( Collectors.toList());

            return getTriangle( maxIndex, currentIndex + 1, result );
        }
    }

    private int calculateNumber(int i, List<Integer> list) {
        return getValue( i - 1, list ) + getValue( i, list );
    }

    private int getValue(int i, List<Integer> list) {
        try {
            return list.get( i );
        } catch (Exception e) {
            return 0;
        }
    }
}
