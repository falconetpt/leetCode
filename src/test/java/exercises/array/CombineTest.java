package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CombineTest {

  private Combine combine;

  @Before
  public void setUp() throws Exception {
    combine = new Combine();
  }

  @Test
  public void combine() {
    combine.combine(4, 2);
  }
}