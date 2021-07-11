package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedianFinderTest {
  private MedianFinder medianFinder;

  @Before
  public void setUp() {
    medianFinder = new MedianFinder();
  }

  @Test
  public void findMedian_oddLength_returnsMiddleValue() {
    medianFinder.addNum(12);
    medianFinder.addNum(5);
    medianFinder.addNum(1);

    assertEquals(5, medianFinder.findMedian(), 0.0);
  }

  @Test
  public void findMedian_evenLength_returnsMiddleValue() {
    medianFinder.addNum(6);
    medianFinder.addNum(12);
    medianFinder.addNum(5);
    medianFinder.addNum(1);

    assertEquals(5.5, medianFinder.findMedian(), 0.0);
  }

}