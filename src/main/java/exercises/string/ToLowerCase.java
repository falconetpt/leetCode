package exercises.string;

import java.util.stream.IntStream;

public class ToLowerCase {
  public String toLowerCase(final String s) {
    return IntStream.range( 0, s.length() )
      .mapToObj( i ->  mapValue(s.charAt( i )) )
      .reduce( "", String::concat );
  }

  private String mapValue(char c) {
    if (c - 'a' >= 0) {
      return String.valueOf( c );
    } else {
      if (c >= 65 && c <= 65 + 26) return String.valueOf( (char) (c + 32) );
      return String.valueOf( c );
    }

  }
}
