package com.dsalgo.solution.neetcode.algorithm.slidingwindow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PermutationInStringTest {

    private final PermutationinString solution = new PermutationinString();

    @Test
    void testExample1_shouldReturnTrue() {
        String s1 = "abc";
        String s2 = "lecabee";

        assertTrue(solution._v2Solve(s1, s2));
    }

    @Test
    void testExample2_shouldReturnFalse() {
        String s1 = "abc";
        String s2 = "lecaabee";

        assertFalse(solution._v2Solve(s1, s2));
    }

    @Test
    void testExactMatch_shouldReturnTrue() {
        String s1 = "abc";
        String s2 = "abc";

        assertTrue(solution._v2Solve(s1, s2));
    }

    @Test
    void testSingleCharacterMatch_shouldReturnTrue() {
        String s1 = "a";
        String s2 = "a";

        assertTrue(solution._v2Solve(s1, s2));
    }

    @Test
    void testSingleCharacterNoMatch_shouldReturnFalse() {
        String s1 = "a";
        String s2 = "b";

        assertFalse(solution._v2Solve(s1, s2));
    }

    @Test
    void testPermutationAtStart_shouldReturnTrue() {
        String s1 = "ab";
        String s2 = "baaaa";

        assertTrue(solution._v2Solve(s1, s2));
    }

    @Test
    void testPermutationAtEnd_shouldReturnTrue() {
        String s1 = "ab";
        String s2 = "aaaab";

        assertTrue(solution._v2Solve(s1, s2));
    }

    @Test
    void testRepeatedCharacters_shouldReturnTrue() {
        String s1 = "aab";
        String s2 = "eidbaaooo";

        assertTrue(solution._v2Solve(s1, s2));
    }

    @Test
    void testRepeatedCharactersNoMatch_shouldReturnFalse() {
        String s1 = "aab";
        String s2 = "eidboaooo";

        assertFalse(solution._v2Solve(s1, s2));
    }

    @Test
    void testS1LongerThanS2_shouldReturnFalse() {
        String s1 = "abcd";
        String s2 = "abc";

        assertFalse(solution._v2Solve(s1, s2));
    }

    @Test
    void testAllSameCharacters_shouldReturnTrue() {
        String s1 = "aaa";
        String s2 = "aaaaaa";

        assertTrue(solution._v2Solve(s1, s2));
    }

    @Test
    void testNoOverlapCharacters_shouldReturnFalse() {
        String s1 = "xyz";
        String s2 = "abcdefg";

        assertFalse(solution._v2Solve(s1, s2));
    }

    @Test
    void testNeetCode() {
        String s1 = "hello";
        String s2 = "ooolleoooleh";

        assertFalse(solution._v2Solve(s1, s2));
    }
}