package com.dsalgo.solution.neetcode.algorithm.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongestSubstringWithoutRepeatingCharactersTest {

    private LongestSubstringWithoutRepeatingCharacters solution;

    @BeforeEach
    void setUp() {
        solution = new LongestSubstringWithoutRepeatingCharacters();
    }

    @Test
    void testEmptyString() {
        assertEquals(0, solution._v1Solve(""));
    }

    @Test
    void testSingleCharacter() {
        assertEquals(1, solution._v1Solve("a"));
    }

    @Test
    void testAllUniqueCharacters() {
        assertEquals(5, solution._v1Solve("abcde"));
        assertEquals(10, solution._v1Solve("abcdefghij"));
    }

    @Test
    void testAllSameCharacters() {
        assertEquals(1, solution._v1Solve("aaaa"));
        assertEquals(1, solution._v1Solve("bbbbbb"));
    }

    @Test
    void testBasicRepeatingCharacters() {
        assertEquals(3, solution._v1Solve("abcabcbb"));
        assertEquals(3, solution._v1Solve("pwwkew"));
    }

    @Test
    void testNoRepeatingCharacters() {
        assertEquals(6, solution._v1Solve("abcdef"));
    }

    @Test
    void testMixedCharacters() {
        assertEquals(7, solution._v1Solve("abcaefgh"));
        assertEquals(2, solution._v1Solve("abba"));
    }

    @Test
    void testEdgeCases() {
        assertEquals(1, solution._v1Solve("aa"));
        assertEquals(2, solution._v1Solve("ab"));
        assertEquals(0, solution._v1Solve(""));
        assertEquals(1, solution._v1Solve("a"));
    }

    @Test
    void testComplexPattern() {
        assertEquals(5, solution._v1Solve("tmmzuxt"));
        assertEquals(3, solution._v1Solve("dvdf"));
        assertEquals(8, solution._v1Solve("abcdeafgh"));
    }

    @Test
    void testRepeatingAtEnd() {
        assertEquals(4, solution._v1Solve("abcdabc"));
        assertEquals(3, solution._v1Solve("xyzxyz"));
    }

    @Test
    void testAlternatingPattern() {
        assertEquals(2, solution._v1Solve("ababab"));
        assertEquals(3, solution._v1Solve("abcabcabc"));
    }
}
