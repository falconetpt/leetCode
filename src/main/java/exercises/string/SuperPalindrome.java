package exercises.string;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class SuperPalindrome {
  public int superpalindromesInRange(final String left,
                                     final String right) {
    final long squareLeft = (long) Math.sqrt( Double.valueOf( left ) );
    final long squareRight = (long) Math.sqrt( Double.valueOf( right ) );


    return (int) LongStream.rangeClosed( squareLeft, squareRight )
      .parallel()
      .boxed()
      .filter( i -> new StringBuilder( String.valueOf( i ) ).reverse().toString().equals( String.valueOf( i ) ))
      .peek( System.out::println )
      .map( i -> i *  i )
      .map( String::valueOf )
      .filter( i -> new StringBuilder( i ).reverse().toString().equals( i ) )
      .count();
  }
}
