package exercises.string;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class MagicDictionaryTest {
  private MagicDictionary magicDictionary;

  @BeforeEach
  private void setup() {
    magicDictionary = new MagicDictionary();
  }

  @Test
  void test1() {
    magicDictionary.buildDict(new String[]{ "hello", "leetcode" });

    assertFalse(magicDictionary.search("hello"));
    assertFalse(magicDictionary.search("hell"));
    assertTrue(magicDictionary.search("hhllo"));
    assertFalse(magicDictionary.search("leetcoded"));
  }

}