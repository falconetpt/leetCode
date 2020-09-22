package exercises.number;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        int lowPotence = String.valueOf( low ).length();
        int highPotence = String.valueOf( high ).length();

        List<Integer> values = generateNumbers(lowPotence, highPotence);

        return values.stream()
                .filter( x -> x >= low && x <= high )
                .collect( Collectors.toList());
    }

    private List<Integer> generateNumbers(int lowPotence, int highPotence) {
        return IntStream.rangeClosed( lowPotence, highPotence ).boxed()
                .filter( n -> n < 10 )
                .flatMap( n -> generateSequentialNumbers( n ).stream() )
                .collect( Collectors.toList() );
    }

    private List<Integer> generateSequentialNumbers(int n) {
        String range = "123456789";

        return IntStream.rangeClosed( 0, range.length() - n ).boxed()
                .map( s -> Integer.valueOf( range.substring( s, s + n ) ) )
                .collect( Collectors.toList());
    }


}
