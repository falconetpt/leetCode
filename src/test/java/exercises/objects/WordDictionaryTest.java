package exercises.objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordDictionaryTest {
    private WordDictionary wordDictionary = new WordDictionary();

    @Test
    @DisplayName( "Should add and search the same word" )
    public void scenario1() {
        wordDictionary.addWord( "abc" );
        assertTrue( wordDictionary.search( "abc" ) );
        assertFalse( wordDictionary.search( "abd" ) );
        assertTrue( wordDictionary.search( "ab." ) );
        assertFalse( wordDictionary.search( "ab.." ) );
    }

}