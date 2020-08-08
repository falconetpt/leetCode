package exercises.objects;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * Ideal challenge to propose to candidates
 */
class WordDictionary {
    private WordTrie wordTrie;

    /** Initialize your data structure here. */
    public WordDictionary() {
        wordTrie = new WordTrie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        wordTrie.addWord( word );
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return wordTrie.hasWord( word );
    }


    private class WordTrie {
        private boolean isWord;
        private WordTrie[] children;

        public WordTrie() {
            children = new WordTrie[26];
        }

        public void addWord(final String value) {
            Optional.ofNullable(value).ifPresent( w -> addWord( w, 0 ) );
        }

        public boolean hasWord(final String value) {
            return Optional.ofNullable(value)
                    .map( w -> hasWord( w, 0 ) )
                    .orElse( false );
        }

        private boolean hasWord(final String value, final int index) {
            if (index == value.length() - 1) {
                int childrenIndex = value.charAt( index ) - 'a';
                return value.charAt( index ) == '.'
                        ? Arrays.stream(children)
                            .filter( Objects::nonNull )
                            .anyMatch( c -> c.isWord )
                        : Optional.ofNullable( children[childrenIndex] )
                            .map( c -> c.isWord )
                            .orElse( false );
            } else {
                if (value.charAt( index ) == '.') {
                    return Arrays.stream(children)
                            .filter( Objects::nonNull )
                            .map( c -> c.hasWord( value, index + 1 ) )
                            .reduce( false, (a, b) -> a || b);
                } else {
                    int childrenIndex = value.charAt( index ) - 'a';

                    if ( Objects.isNull( children[childrenIndex]) ) {
                        return false;
                    } else {
                        return children[childrenIndex].hasWord( value, index + 1);
                    }
                }
            }
        }

        private void addWord(final String value, final int index) {
            if (index == value.length() - 1) {
                int childrenIndex = value.charAt( index ) - 'a';
                if (Objects.isNull( children[childrenIndex] )) children[childrenIndex] = new WordTrie();

                children[childrenIndex].isWord = true;
            } else {
                int childrenIndex = value.charAt( index ) - 'a';

                if (Objects.isNull( children[childrenIndex] )) children[childrenIndex] = new WordTrie();
                children[childrenIndex].addWord( value, index + 1 );
            }
        }
    }
}