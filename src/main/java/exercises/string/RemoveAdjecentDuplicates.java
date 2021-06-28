package exercises.string;

import java.util.LinkedList;

public class RemoveAdjecentDuplicates {
  public String removeDuplicates(final String s) {
    final var linkedList = new LinkedList<Character>(  );

    return removeDuplicates( s, 0, linkedList )
      .stream()
      .map( String::valueOf )
      .reduce( "", String::concat );
  }

  private LinkedList<Character> removeDuplicates(final String s,
                                                 final int i,
                                                 final LinkedList<Character> linkedList) {
    if (i >= s.length()) {
      return linkedList;
    } else if (linkedList.isEmpty()) {
      linkedList.add( s.charAt( i ) );
      return removeDuplicates( s, i + 1, linkedList );
    } else {
      final var element = linkedList.peekLast();

      final var c = s.charAt( i );

      if (element == c) {
        linkedList.pollLast();
      } else {
        linkedList.add( c );
      }

      return removeDuplicates( s, i + 1, linkedList );
    }
  }
}
