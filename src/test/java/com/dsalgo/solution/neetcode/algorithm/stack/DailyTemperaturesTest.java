package com.dsalgo.solution.neetcode.algorithm.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DailyTemperaturesTest {

    private DailyTemperatures dailyTemperatures;

    @BeforeEach
    void setUp() {
        dailyTemperatures = new DailyTemperatures();
    }

    @Test
    void testV1BasicExample() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};
        assertArrayEquals(expected, dailyTemperatures._v1Solve(temperatures));
    }

    @Test
    void testV2BasicExample() {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};
        assertArrayEquals(expected, dailyTemperatures._v2Solve(temperatures));
    }

    @Test
    void testV1SingleElement() {
        int[] temperatures = {30};
        int[] expected = {0};
        assertArrayEquals(expected, dailyTemperatures._v1Solve(temperatures));
    }

    @Test
    void testV2SingleElement() {
        int[] temperatures = {30};
        int[] expected = {0};
        assertArrayEquals(expected, dailyTemperatures._v2Solve(temperatures));
    }

    @Test
    void testV1AllIncreasing() {
        int[] temperatures = {30, 40, 50, 60};
        int[] expected = {1, 1, 1, 0};
        assertArrayEquals(expected, dailyTemperatures._v1Solve(temperatures));
    }

    @Test
    void testV2AllIncreasing() {
        int[] temperatures = {30, 40, 50, 60};
        int[] expected = {1, 1, 1, 0};
        assertArrayEquals(expected, dailyTemperatures._v2Solve(temperatures));
    }

    @Test
    void testV1AllDecreasing() {
        int[] temperatures = {90, 80, 70, 60};
        int[] expected = {0, 0, 0, 0};
        assertArrayEquals(expected, dailyTemperatures._v1Solve(temperatures));
    }

    @Test
    void testV2AllDecreasing() {
        int[] temperatures = {90, 80, 70, 60};
        int[] expected = {0, 0, 0, 0};
        assertArrayEquals(expected, dailyTemperatures._v2Solve(temperatures));
    }

    @Test
    void testV1AllSame() {
        int[] temperatures = {50, 50, 50, 50};
        int[] expected = {0, 0, 0, 0};
        assertArrayEquals(expected, dailyTemperatures._v1Solve(temperatures));
    }

    @Test
    void testV2AllSame() {
        int[] temperatures = {50, 50, 50, 50};
        int[] expected = {0, 0, 0, 0};
        assertArrayEquals(expected, dailyTemperatures._v2Solve(temperatures));
    }

    @Test
    void testV1AlternatingPattern() {
        int[] temperatures = {30, 50, 30, 50, 30};
        int[] expected = {1, 0, 1, 0, 0};
        assertArrayEquals(expected, dailyTemperatures._v1Solve(temperatures));
    }

    @Test
    void testV2AlternatingPattern() {
        int[] temperatures = {30, 50, 30, 50, 30};
        int[] expected = {1, 0, 1, 0, 0};
        assertArrayEquals(expected, dailyTemperatures._v2Solve(temperatures));
    }

    @Test
    void testV1LargeGap() {
        int[] temperatures = {30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};
        int[] expected = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
        assertArrayEquals(expected, dailyTemperatures._v1Solve(temperatures));
    }

    @Test
    void testV2LargeGap() {
        int[] temperatures = {30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};
        int[] expected = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
        assertArrayEquals(expected, dailyTemperatures._v2Solve(temperatures));
    }

    @Test
    void testV1EmptyArray() {
        int[] temperatures = {};
        int[] expected = {};
        assertArrayEquals(expected, dailyTemperatures._v1Solve(temperatures));
    }

    @Test
    void testV2EmptyArray() {
        int[] temperatures = {};
        int[] expected = {};
        assertArrayEquals(expected, dailyTemperatures._v2Solve(temperatures));
    }

    @Test
    void testV1TwoElements() {
        int[] temperatures = {30, 40};
        int[] expected = {1, 0};
        assertArrayEquals(expected, dailyTemperatures._v1Solve(temperatures));
    }

    @Test
    void testV2TwoElements() {
        int[] temperatures = {30, 40};
        int[] expected = {1, 0};
        assertArrayEquals(expected, dailyTemperatures._v2Solve(temperatures));
    }

    @Test
    void testV1TwoElementsDecreasing() {
        int[] temperatures = {40, 30};
        int[] expected = {0, 0};
        assertArrayEquals(expected, dailyTemperatures._v1Solve(temperatures));
    }

    @Test
    void testV2TwoElementsDecreasing() {
        int[] temperatures = {40, 30};
        int[] expected = {0, 0};
        assertArrayEquals(expected, dailyTemperatures._v2Solve(temperatures));
    }

    @Test
    void testV1ComplexPattern() {
        int[] temperatures = {55, 60, 50, 52, 53, 54, 51, 49, 56, 57};
        int[] expected = {1, 0, 1, 1, 1, 3, 2, 1, 1, 0};
        assertArrayEquals(expected, dailyTemperatures._v1Solve(temperatures));
    }

    @Test
    void testV2ComplexPattern() {
        int[] temperatures = {55, 60, 50, 52, 53, 54, 51, 49, 56, 57};
        int[] expected = {1, 0, 1, 1, 1, 3, 2, 1, 1, 0};
        assertArrayEquals(expected, dailyTemperatures._v2Solve(temperatures));
    }

    @Test
    void testV1AndV2Consistency() {
        int[][] testCases = {
            {73, 74, 75, 71, 69, 72, 76, 73},
            {30, 40, 50, 60},
            {90, 80, 70, 60},
            {50, 50, 50, 50},
            {30, 50, 30, 50, 30},
            {30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
            {55, 60, 50, 52, 53, 54, 51, 49, 56, 57}
        };

        for (int[] testCase : testCases) {
            int[] result1 = dailyTemperatures._v1Solve(testCase.clone());
            int[] result2 = dailyTemperatures._v2Solve(testCase.clone());
            assertArrayEquals(result1, result2, "Results should be consistent between v1 and v2");
        }
    }
}
