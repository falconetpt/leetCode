package exercises.string;

import exercises.array.SurroundedAreas;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicatesInPath {
  public List<List<String>> findDuplicate(String[] paths) {

    final var map = new HashMap<String, List<String>>(  );

    Arrays.stream(paths)
      .flatMap( this::getPath )
      .peek( p -> map.putIfAbsent( p.content, new ArrayList<>(  ) ) )
      .forEach( p -> map.get( p.content ).add( p.path ) );

    return map.values()
      .stream()
      .filter( i -> i.size() > 1 )
      .collect( Collectors.toList() );
  }


  public Stream<Path> getPath(final String s) {
    final var elements = s.split( " " );
    final var basePath = elements[0];
    final var result = new ArrayList<Path>(  );

    for (int i = 1; i < elements.length; i++) {
      final var content = elements[i].split( "[(]" );
      final var filePath = basePath + "/" + content[0];
      final var path = new Path();
      path.path = filePath;
      path.content = content[1].replace( ")", "" );
      result.add( path );
    }

    return result.stream();
  }

  class Path {
    private String path;
    private String content;
  }
}
