package com.dsalgo.solution.neetcode.algorithm.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LargestRectangleInHistogramTest {

    private LargestRectangleInHistogram largestRectangleInHistogram;

    @BeforeEach
    void setUp() {
        largestRectangleInHistogram = new LargestRectangleInHistogram();
    }

    @Test
    void testBasicExample() {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(10, result);
    }

    @Test
    void testSingleBar() {
        int[] heights = {5};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(5, result);
    }

    @Test
    void testTwoBarsIncreasing() {
        int[] heights = {1, 2};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(2, result);
    }

    @Test
    void testTwoBarsDecreasing() {
        int[] heights = {2, 1};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(2, result);
    }

    @Test
    void testTwoBarsEqual() {
        int[] heights = {3, 3};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(6, result);
    }

    @Test
    void testAllSameHeight() {
        int[] heights = {2, 2, 2, 2, 2};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(10, result);
    }

    @Test
    void testIncreasingHeights() {
        int[] heights = {1, 2, 3, 4, 5};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(9, result);
    }

    @Test
    void testDecreasingHeights() {
        int[] heights = {5, 4, 3, 2, 1};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(9, result);
    }

    @Test
    void testMountainShape() {
        int[] heights = {1, 3, 5, 3, 1};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(9, result);
    }

    @Test
    void testValleyShape() {
        int[] heights = {5, 1, 5};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(5, result);
    }

    @Test
    void testAlternatingHeights() {
        int[] heights = {2, 1, 2, 1, 2};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(5, result);
    }

    @Test
    void testZeroHeights() {
        int[] heights = {0, 0, 0, 0};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(0, result);
    }

    @Test
    void testMixedWithZeros() {
        int[] heights = {2, 0, 2, 0, 2};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(2, result);
    }

    @Test
    void testSingleZero() {
        int[] heights = {0};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(0, result);
    }

    @Test
    void testLargeValues() {
        int[] heights = {1000, 1000, 1000};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(3000, result);
    }

    @Test
    void testTwoLargeBars() {
        int[] heights = {1, 5, 5, 1};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(10, result);
    }

    @Test
    void testOneTallBar() {
        int[] heights = {1, 1, 10, 1, 1};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(10, result);
    }

    @Test
    void testEmptyArray() {
        int[] heights = {};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(0, result);
    }

    @Test
    void testNullArray() {
        int[] heights = null;
        assertThrows(NullPointerException.class, () -> {
            largestRectangleInHistogram._v1Solve(heights);
        });
    }

    @Test
    void testLargeArray() {
        int[] heights = new int[1000];
        for (int i = 0; i < 1000; i++) {
            heights[i] = 1;
        }
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(1000, result);
    }

    @Test
    void testSingleHeightOne() {
        int[] heights = {1};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(1, result);
    }

    @Test
    void testAllOnes() {
        int[] heights = {1, 1, 1, 1, 1};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(5, result);
    }

    @Test
    void testThreeBars() {
        int[] heights = {2, 3, 2};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(6, result);
    }

    @Test
    void testFourBarsSquare() {
        int[] heights = {2, 2, 2, 2};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(8, result);
    }

    @Test
    void testPeakAtEnd() {
        int[] heights = {1, 2, 3, 4};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(6, result);
    }

    @Test
    void testPeakAtStart() {
        int[] heights = {4, 3, 2, 1};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(6, result);
    }

    @Test
    void testRandomPattern1() {
        int[] heights = {6, 2, 5, 4, 5, 1, 6};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(12, result);
    }

    @Test
    void testRandomPattern2() {
        int[] heights = {3, 6, 5, 7, 4, 8, 1, 0};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(20, result);
    }

    @Test
    void testVerySmallHeights() {
        int[] heights = {1, 1, 1};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(3, result);
    }

    @Test
    void testAlternatingHighLow() {
        int[] heights = {10, 1, 10, 1, 10};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(10, result);
    }

    @Test
    void testTwoElements() {
        int[] heights = {1, 1};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(2, result);
    }

    @Test
    void testThreeElementsIncreasing() {
        int[] heights = {1, 2, 3};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(4, result);
    }

    @Test
    void testThreeElementsDecreasing() {
        int[] heights = {3, 2, 1};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(4, result);
    }

    @Test
    void testGptSample() {
        int[] heights = {7, 1, 7, 2, 2, 4};
        int result = largestRectangleInHistogram._v1Solve(heights);
        assertEquals(8, result);
    }
}
