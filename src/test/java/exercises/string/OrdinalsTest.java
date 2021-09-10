package exercises.string;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class OrdinalsTest {

  @Test
  public void ordinals() {
    final var ordinals = new Ordinals();
    IntStream.range(0, 200).mapToObj(ordinals::ordinals).forEach(System.out::println);
  }
}