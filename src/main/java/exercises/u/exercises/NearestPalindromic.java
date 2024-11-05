package exercises.u.exercises;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NearestPalindromic {
  public String nearestPalindromic(String n) {
    // base case
    if(n.length() == 1) return String.valueOf(Integer.parseInt(n) - 1);


    final var prevChunk = generateNextPrev(n);

    if (isPalindrome(n)) {
      if (n.length() == 2) {
        final var element = Integer.parseInt(n.charAt(0) + "") -  1;
        prevChunk.add(element + "" + element);
      } else {
        prevChunk.add(palindromeString(n));
      }

    } else {
      prevChunk.add(nonPalindromeString(n));
    }


    final var nBigInt = new BigInteger(n);
    return prevChunk.stream()
        .filter(this::isPalindrome)
        .filter(s -> !s.equals(n))
        .map(BigInteger::new)
        .sorted()
        .peek(System.out::println)
        .min(Comparator.comparing(a -> a.subtract(nBigInt).abs()))
        .map(BigInteger::toString)
        .orElse("");
  }

  private List<String> generateNextPrev(String n) {
    final var length = n.length();
    final var list = new ArrayList<String>();

    final var prev = IntStream.range(0, length - 1)
        .boxed()
        .map(i -> "9")
        .reduce("", (a, b) -> a + b);

    final var next = 1 + IntStream.rangeClosed(0, length -2)
        .boxed()
        .map(i -> "0")
        .reduce("", (a, b) -> a + b) + 1;

    list.add(prev);
    list.add(next);
    list.add(prev + "9");

    return list;
  }

  private String palindromeString(String n) {
    final var isEven = n.length() % 2 == 0
        ? 1
        : 0;
    final var sb = new StringBuilder(n.substring(0, n.length() / 2 - isEven));

    System.out.println("==== SB " + sb);
    final var reverse = new StringBuilder(sb).reverse().toString();

    if (isEven == 1) {
      final var startingPoint =  n.length() / 2 - isEven;
      final var mid = n.charAt(startingPoint);
      final var last = Integer.parseInt(mid + "") - 1;
      sb.append(last);
    } else {
      final var mid = Integer.parseInt("" + n.charAt(n.length() / 2 + 1)) - 1;
      sb.append(mid);
    }

    System.out.println("==== SB2 " + sb);


    return sb.append(reverse).toString();
  }

  private String nonPalindromeString(String n) {
    final var isOdd = n.length() % 2 == 1
        ? 1
        : 0;
    final var sb = new StringBuilder(n.substring(0, n.length() / 2));

    System.out.println("==== SB " + sb);
    final var reverse = new StringBuilder(sb).reverse().toString();

    if (isOdd == 1) sb.append(n.charAt(n.length() / 2));
    System.out.println("==== SB2 " + sb);


    return sb.append(reverse).toString();
  }

  private boolean isPalindrome(String n) {
    final var reversed = new StringBuilder(n).reverse().toString();
    return n.equals(reversed);
  }
}
