package com.dsalgo.solution.neetcode.algorithm.slidingwindow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MinimumWindowSubstringTest {

    private final MinimumWindowSubstring solution = new MinimumWindowSubstring();

    @Test
    void testExample1_shouldReturnBANC() {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        assertEquals("BANC", solution._v2Solve(s, t));
    }

    @Test
    void testExample2_shouldReturnA() {
        String s = "a";
        String t = "a";

        assertEquals("a", solution._v2Solve(s, t));
    }

    @Test
    void testExample3_shouldReturnEmpty() {
        String s = "a";
        String t = "aa";

        assertEquals("", solution._v2Solve(s, t));
    }

    @Test
    void testEmptyS_shouldReturnEmpty() {
        String s = "";
        String t = "ABC";

        assertEquals("", solution._v2Solve(s, t));
    }

    @Test
    void testEmptyT_shouldReturnEmpty() {
        String s = "ADOBECODEBANC";
        String t = "";

        assertEquals("", solution._v2Solve(s, t));
    }

    @Test
    void testBothEmpty_shouldReturnEmpty() {
        String s = "";
        String t = "";

        assertEquals("", solution._v2Solve(s, t));
    }

    @Test
    void testTLongerThanS_shouldReturnEmpty() {
        String s = "ABC";
        String t = "ABCD";

        assertEquals("", solution._v2Solve(s, t));
    }

    @Test
    void testExactMatch_shouldReturnOriginal() {
        String s = "ABC";
        String t = "ABC";

        assertEquals("ABC", solution._v2Solve(s, t));
    }

    @Test
    void testSingleCharacterMatch_shouldReturnCharacter() {
        String s = "XYZABC";
        String t = "A";

        assertEquals("A", solution._v2Solve(s, t));
    }

    @Test
    void testSingleCharacterNoMatch_shouldReturnEmpty() {
        String s = "XYZ";
        String t = "A";

        assertEquals("", solution._v2Solve(s, t));
    }

    @Test
    void testAllCharactersPresent_shouldReturnFirstOccurrence() {
        String s = "BAC";
        String t = "ABC";

        assertEquals("BAC", solution._v2Solve(s, t));
    }

    @Test
    void testRepeatedCharactersInT() {
        String s = "AAABBB";
        String t = "AAB";

        assertEquals("AAB", solution._v2Solve(s, t));
    }

    @Test
    void testMultipleValidWindows_shouldReturnSmallest() {
        String s = "AAABBBCCC";
        String t = "ABC";

        assertEquals("ABBBC", solution._v2Solve(s, t));
    }

    @Test
    void testWindowAtStart() {
        String s = "ABCXYZ";
        String t = "ABC";

        assertEquals("ABC", solution._v2Solve(s, t));
    }

    @Test
    void testWindowAtEnd() {
        String s = "XYZABC";
        String t = "ABC";

        assertEquals("ABC", solution._v2Solve(s, t));
    }

    @Test
    void testAllSameCharacters() {
        String s = "AAAAAAA";
        String t = "AAA";

        assertEquals("AAA", solution._v2Solve(s, t));
    }

    @Test
    void testNoCommonCharacters_shouldReturnEmpty() {
        String s = "XYZ";
        String t = "ABC";

        assertEquals("", solution._v2Solve(s, t));
    }

    @Test
    void testLongerStringWithSmallWindow() {
        String s = "THISISATESTSTRING";
        String t = "TST";

        assertEquals("TST", solution._v2Solve(s, t));
    }

    @Test
    void testOverlappingWindows() {
        String s = "ABABABAB";
        String t = "AAB";

        assertEquals("ABA", solution._v2Solve(s, t));
    }

    @Test
    void testMinimumWindowSize() {
        String s = "AB";
        String t = "AB";

        assertEquals("AB", solution._v2Solve(s, t));
    }

    @Test
    void testLargeInputPerformance() {
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        
        // Create a large string with pattern
        for (int i = 0; i < 1000; i++) {
            s.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        t.append("XYZ");

        // This should complete without timeout and return a valid result
        String result = solution._v2Solve(s.toString(), t.toString());
        assertEquals("XYZ", result);
    }

    @Test
    void testCaseSensitivity() {
        String s = "abcABC";
        String t = "ABC";

        assertEquals("ABC", solution._v2Solve(s, t));
    }

    @Test
    void testNonAlphabeticCharacters() {
        String s = "123!@#ABC";
        String t = "ABC";

        assertEquals("ABC", solution._v2Solve(s, t));
    }
}
