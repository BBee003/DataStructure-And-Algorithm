package com.dsalgo.solution.neetcode.algorithm.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestRepeatingCharacterReplacementTest {

    private LongestRepeatingCharacterReplacement solution;

    @BeforeEach
    void setUp() {
        solution = new LongestRepeatingCharacterReplacement();
    }

    // =========================
    // Edge Cases
    // =========================

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> solution._v1Solve(null, 2));
    }

    @Test
    void testEmptyString() {
        assertEquals(0, solution._v1Solve("", 0));
        assertEquals(0, solution._v1Solve("", 5));
    }

    @Test
    void testSingleCharacter() {
        assertEquals(1, solution._v1Solve("A", 0));
        assertEquals(1, solution._v1Solve("A", 10));
    }

    // =========================
    // Basic Cases
    // =========================

    @Test
    void testBasicExamples() {
        assertEquals(4, solution._v1Solve("ABAB", 2));
        assertEquals(4, solution._v1Solve("AABABBA", 1));
    }

    @Test
    void testAllSameCharacters() {
        assertEquals(5, solution._v1Solve("AAAAA", 0));
        assertEquals(5, solution._v1Solve("AAAAA", 2));
    }

    @Test
    void testNoReplacementAllowed() {
        assertEquals(3, solution._v1Solve("AAABBB", 0));
        assertEquals(1, solution._v1Solve("ABCDE", 0));
    }

    // =========================
    // Sliding Window Behavior
    // =========================

    @Test
    void testAlternatingCharacters() {
        assertEquals(3, solution._v1Solve("ABABAB", 1));
        assertEquals(5, solution._v1Solve("ABABAB", 2));
        assertEquals(6, solution._v1Solve("ABABAB", 3));
    }

    @Test
    void testMixedCharacters() {
        assertEquals(4, solution._v1Solve("AABBBCC", 1));
        assertEquals(5, solution._v1Solve("AABBBCC", 2));
        assertEquals(6, solution._v1Solve("AABBBCC", 3));
    }

    @Test
    void testWindowShrinkBehavior() {
        assertEquals(4, solution._v1Solve("ABBBAC", 1));
        assertEquals(5, solution._v1Solve("ABBBAC", 2));
    }

    // =========================
    // Large K Values
    // =========================

    @Test
    void testLargeK() {
        assertEquals(5, solution._v1Solve("ABCDE", 5));
        assertEquals(5, solution._v1Solve("ABCDE", 100));
    }

    @Test
    void testKGreaterThanLength() {
        assertEquals(3, solution._v1Solve("ABC", 10));
    }

    // =========================
    // Complex Patterns
    // =========================

    @Test
    void testComplexPattern1() {
        assertEquals(5, solution._v1Solve("AAABBBCCC", 2));
        assertEquals(6, solution._v1Solve("AAABBBCCC", 3));
        assertEquals(9, solution._v1Solve("AAABBBCCC", 6));
    }

    @Test
    void testComplexPattern2() {
        assertEquals(3, solution._v1Solve("ABACABA", 1));
        assertEquals(5, solution._v1Solve("ABACABA", 2));
        assertEquals(7, solution._v1Solve("ABACABA", 3));
    }

    @Test
    void testConsecutiveGroups() {
        assertEquals(4, solution._v1Solve("AAABBAA", 1));
        assertEquals(7, solution._v1Solve("AAABBAA", 2));
        assertEquals(7, solution._v1Solve("AAABBAA", 3));
    }

    // =========================
    // Edge Pattern Cases
    // =========================

    @Test
    void testTwoCharacters() {
        assertEquals(1, solution._v1Solve("AB", 0));
        assertEquals(2, solution._v1Solve("AB", 1));
    }

    @Test
    void testThreeCharacters() {
        assertEquals(2, solution._v1Solve("ABC", 1));
        assertEquals(3, solution._v1Solve("ABC", 2));
    }

    @Test
    void testSingleReplacementCases() {
        assertEquals(3, solution._v1Solve("AAB", 1));
        assertEquals(3, solution._v1Solve("ABA", 1));
        assertEquals(3, solution._v1Solve("BAA", 1));
    }

    // =========================
    // Long Input
    // =========================

    @Test
    void testLongString() {
        assertEquals(10, solution._v1Solve("AAAAAAAAAABBBBBBBBBB", 0));
        assertEquals(20, solution._v1Solve("AAAAAAAAAABBBBBBBBBB", 10));
    }

    // =========================
    // Stress Test
    // =========================

    @Test
    void testLargeInputPerformance() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            sb.append("AB");
        }
        String input = sb.toString();

        int result = solution._v1Solve(input, 5);

        assertTrue(result >= 5); // sanity check (not exact match)
    }
}