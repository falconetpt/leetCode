package exercises.number;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
  public  BinarySearch binarySearch = new BinarySearch();

  @Test
  public void emptyListReturnsNoIndex() {
    assertEquals(-1, binarySearch.search(new int[] {}, 12));
  }

  @Test
  public void singleElementListReturnsNoIndex() {
    assertEquals(-1, binarySearch.search(new int[] {2}, 43));
  }

  @Test
  public void singleElementListReturnsFirstIndex() {
    assertEquals(0, binarySearch.search(new int[] {79}, 79));
  }

  @Test
  public void multipleElementListReturnsGoodIndex() {
    assertEquals(4, binarySearch.search(new int[] {-1,0,3,5,9,12}, 9));
  }

  @Test
  public void multipleElementListReturnsNoIndex() {
    assertEquals(-1, binarySearch.search(new int[] {-1,0,3,5,9,12}, 2));
  }
}