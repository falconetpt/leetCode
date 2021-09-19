package exercises.string;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class AddOperationsTest {
  private AddOperations addOperations;

  @Before
  public void setUp() throws Exception {
    addOperations = new AddOperations();
  }

  @Test
  public void addOperators1() {
    assertEquals(Set.of("1+1"), new HashSet<>(addOperations.addOperators("11", 2)));
  }

  @Test
  public void addOperators2() {
    assertEquals(Set.of("1*2*3","1+2+3"), new HashSet<>(addOperations.addOperators( "123", 6)));
  }

  @Test
  public void addOperators3() {
    assertEquals(Set.of("2*3+2","2+3*2"), new HashSet<>(addOperations.addOperators( "232", 8)));
  }
}