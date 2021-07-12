package exercises.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsoMorphicStringTest {
  private IsoMorphicString isoMorphicString;

  @Before
  public void setup() {
    isoMorphicString = new IsoMorphicString();
  }

  @Test
  public void isIsomorphic_differentStringLengths_returnFalse() {
    assertFalse(isoMorphicString.isIsomorphic("egg", "toox"));
  }

  @Test
  public void isIsomorphic_eggAndToo_returnTrue() {
    assertTrue(isoMorphicString.isIsomorphic("egg", "too"));
  }

  @Test
  public void isIsomorphic_eggAndTop_returnFalse() {
    assertFalse(isoMorphicString.isIsomorphic("egg", "top"));
  }

}