package exercises.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintWordsVertically {
    public List<String> printVertically(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>(  );
        }

        LinkedList<String> words = Arrays.stream(s.split( " " ))
                .collect( Collectors.toCollection( LinkedList::new));

        int maxLength = words.stream().map( String::length )
                .reduce( 0, (a, b) -> a > b ? a : b);

        StringBuilder[] result = new StringBuilder[maxLength];
        IntStream.range( 0, result.length ).forEach( i -> result[i] = new StringBuilder(  ) );

        generateVerticalWording(words, result, maxLength);

        return Arrays.stream( result )
                .map( StringBuilder::toString )
                .map( str -> str.replaceFirst("\\s++$", "") )
                .collect( Collectors.toList());
    }

    private void generateVerticalWording(final LinkedList<String> words,
                                         final StringBuilder[] result,
                                         final int maxLength) {
        if (!words.isEmpty()) {
            String next = words.pop();

            IntStream.range( 0, maxLength ).boxed().forEach( i ->
                    result[i].append( i >= next.length() ? " " : next.charAt( i ) )
            );

            generateVerticalWording( words, result, maxLength );
        }
    }


}
