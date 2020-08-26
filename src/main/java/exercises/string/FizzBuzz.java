package exercises.string;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        return IntStream.rangeClosed( 1, n ).boxed()
                .map( this::convertToString )
                .collect( Collectors.toList());
    }

    private String convertToString(int n) {
        if (n % 15 == 0) {
            return "FizzBuzz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else if (n % 3 == 0) {
            return "Fizz";
        } else {
            return String.valueOf( n );
        }
    }
}
