package com.dsalgo.solution.neetcode.algorithm.slidingwindow;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowMaximumTest {

    private final SlidingWindowMaximum solution = new SlidingWindowMaximum();

    @Test
    void testExampleCase() {
        int[] nums = { 1, 2, 1, 0, 4, 2, 6 };
        int k = 3;
        int[] expected = { 2, 2, 4, 4, 6 };

        assertArrayEquals(expected, solution._v2Solve(nums, k));
    }

    @Test
    void testSingleElementWindow() {
        int[] nums = { 4, 3, 5, 2 };
        int k = 1;
        int[] expected = { 4, 3, 5, 2 };

        assertArrayEquals(expected, solution._v2Solve(nums, k));
    }

    @Test
    void testWindowEqualsArraySize() {
        int[] nums = { 2, 1, 3 };
        int k = 3;
        int[] expected = { 3 };

        assertArrayEquals(expected, solution._v2Solve(nums, k));
    }

    @Test
    void testAllSameElements() {
        int[] nums = { 5, 5, 5, 5 };
        int k = 2;
        int[] expected = { 5, 5, 5 };

        assertArrayEquals(expected, solution._v2Solve(nums, k));
    }

    @Test
    void testNegativeNumbers() {
        int[] nums = { -1, -3, -5, -2 };
        int k = 2;
        int[] expected = { -1, -3, -2 };

        assertArrayEquals(expected, solution._v2Solve(nums, k));
    }

    @Test
    void testIncreasingSequence() {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 3;
        int[] expected = { 3, 4, 5 };

        assertArrayEquals(expected, solution._v2Solve(nums, k));
    }

    @Test
    void testDecreasingSequence() {
        int[] nums = { 5, 4, 3, 2, 1 };
        int k = 3;
        int[] expected = { 5, 4, 3 };

        assertArrayEquals(expected, solution._v2Solve(nums, k));
    }

    @Test
    void testLargeKNearArraySize() {
        int[] nums = { 9, 11 };
        int k = 2;
        int[] expected = { 11 };

        assertArrayEquals(expected, solution._v2Solve(nums, k));
    }
}