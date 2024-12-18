package dp;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

class MovieRentingSystem {

  private final Map<String, MoviePrice> priceMap;
  private final Map<Integer, TreeSet<MoviePrice>> unrentedMovies;
  private final TreeSet<MoviePrice> rentedMovies;


  public MovieRentingSystem(int n, int[][] entries) {
    priceMap = new HashMap<>();
    final Comparator<MoviePrice> comparator = Comparator.comparing(mp -> mp.price);
    final var comparatorFinal = comparator.thenComparing(d -> d.shop)
        .thenComparing(d -> d.movie);

    unrentedMovies = new HashMap<>();

    for (final var entry : entries) {
      final var shopId = entry[0];
      final var movieId = entry[1];
      final var price = entry[2];
      final var moviePrice = new MoviePrice(shopId, movieId, price);

      priceMap.put(shopId + ":" + movieId, moviePrice);

      unrentedMovies.putIfAbsent(movieId, new TreeSet<>(comparatorFinal));
      unrentedMovies.get(entry[1]).add(moviePrice);
    }

    rentedMovies = new TreeSet<>(comparatorFinal);
  }

  /*

  ["MovieRentingSystem", [[0,1,3],[0,5,3],[0,7,3],[0,6,3],[0,2,3],[0,3,3],[0,4,3],[0,8,3]]]
  "rent", [0,1]
  "report",
  "rent", [0,4]
  "report",
  "rent",
  "report",
  "rent",
  "rent",
  "rent",
  "report"
  ]
[[1,,,[],,[],[0,3],[],[0,2],[0,6],[0,7], []]

*/
  public List<Integer> search(int movie) {
    return unrentedMovies.getOrDefault(movie, new TreeSet<>()).stream()
        .limit(5)
        .map(e -> e.shop)
        .toList();
  }

  public void rent(int shop, int movie) {
    final var element = priceMap.get(shop + ":" + movie);

    unrentedMovies.get(movie).remove(element);
    rentedMovies.add(element);

  }

  public void drop(int shop, int movie) {
    final var element = priceMap.get(shop + ":" + movie);
    rentedMovies.remove(element);
    unrentedMovies.get(movie).add(element);

  }

  public List<List<Integer>> report() {
    return rentedMovies.stream()
        .limit(5)
        .map(e -> List.of(e.shop, e.movie))
        .toList();
  }

  private record MoviePrice(int shop, int movie, int price) {}
}
