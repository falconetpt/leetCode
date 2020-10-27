package exercises.array;

import scala.util.Try;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ChampgneTower {
    public double champagneTower(final int poured,
                                 final int query_row,
                                 final int query_glass) {
        int totalCups = IntStream.rangeClosed( 0, query_row - 1 )
                .map( i -> i + 1 )
                .reduce( 0, Integer::sum );

        if (poured > totalCups + query_row ) {
            return 1;
        } else {
            if (totalCups + query_row < poured) return 0;

            List<List<Integer>> list = Stream.of( Collections.singletonList( 1 ))
                    .collect( Collectors.toList() );
            createPiramid(1, query_row, list);

            double ratio = query_glass == 0
                    || query_glass + 1 == list.get( query_row ).size() ? 0.25 : 0.5;

            return (poured - totalCups) * ratio *
                    list.get( query_row ).get( query_glass ) / (double) query_row;
        }
    }

    private void createPiramid(int index, int query_row, List<List<Integer>> list) {
        if(index <= query_row) {
            List<Integer> result = IntStream.range( 0, index + 1 ).boxed()
                    .map( x -> value( list, index - 1 , x ) )
                    .collect( Collectors.toList() );
            list.add( result );
            createPiramid( index + 1, query_row, list );
        }
    }

    private int value(final List<List<Integer>> list, int row, int col) {
        int x = getValue(list, row, col -1);
        int y = getValue(list, row, col);

        return x + y;
    }

    private int getValue(final List<List<Integer>> list, int row, int col) {
        try {
            return list.get( row ).get( col );
        } catch (Exception e) {
            return 0;
        }
    }
}
