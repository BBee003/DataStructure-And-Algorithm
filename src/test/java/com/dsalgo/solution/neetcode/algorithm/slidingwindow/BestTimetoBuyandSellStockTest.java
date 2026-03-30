package com.dsalgo.solution.neetcode.algorithm.slidingwindow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BestTimetoBuyandSellStockTest {

    private BestTimetoBuyandSellStock solution;

    @BeforeEach
    void setUp() {
        solution = new BestTimetoBuyandSellStock();
    }

    @Test
    void testEmptyArray() {
        int[] prices = {};
        assertEquals(0, solution._v1Solve(prices), "Empty array should return 0");
    }

    @Test
    void testSingleElement() {
        int[] prices = {5};
        assertEquals(0, solution._v1Solve(prices), "Single element should return 0");
    }

    @Test
    void testAllIncreasingPrices() {
        int[] prices = {1, 2, 3, 4, 5};
        assertEquals(4, solution._v1Solve(prices), "All increasing prices should return max profit (5-1)");
    }

    @Test
    void testAllDecreasingPrices() {
        int[] prices = {5, 4, 3, 2, 1};
        assertEquals(0, solution._v1Solve(prices), "All decreasing prices should return 0");
    }

    @Test
    void testMixedPrices() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertEquals(5, solution._v1Solve(prices), "Should return max profit of 5 (buy at 1, sell at 6)");
    }

    @Test
    void testMaxProfitAtEnd() {
        int[] prices = {3, 2, 6, 5, 0, 3};
        assertEquals(4, solution._v1Solve(prices), "Should return max profit of 4 (buy at 2, sell at 6)");
    }

    @Test
    void testSamePrices() {
        int[] prices = {3, 3, 3, 3, 3};
        assertEquals(0, solution._v1Solve(prices), "All same prices should return 0");
    }

    @Test
    void testLargeArray() {
        int[] prices = new int[1000];
        for (int i = 0; i < 1000; i++) {
            prices[i] = i + 1;
        }
        assertEquals(999, solution._v1Solve(prices), "Large increasing array should return max profit");
    }

    @Test
    void testTwoElements() {
        int[] prices = {2, 1};
        assertEquals(0, solution._v1Solve(prices), "Two decreasing elements should return 0");
    }

    @Test
    void testTwoIncreasingElements() {
        int[] prices = {1, 5};
        assertEquals(4, solution._v1Solve(prices), "Two increasing elements should return profit");
    }

    @Test
    void testRandomPrices() {
        int[] prices = {2, 4, 1, 7, 5, 3, 6, 4};
        assertEquals(6, solution._v1Solve(prices), "Should return max profit of 6 (buy at 1, sell at 7)");
    }

    @Test
    void testPeakAndValley() {
        int[] prices = {5, 1, 5, 1, 5, 1, 5};
        assertEquals(4, solution._v1Solve(prices), "Should return max profit of 4");
    }

    @Test
    void testMixedPositiveAndNegative() {
        int[] prices = {-1, 2, -3, 4, -5, 6};
        assertEquals(11, solution._v1Solve(prices), "Should handle mixed positive and negative prices");
    }

    @Test
    void testZeroPrices() {
        int[] prices = {0, 0, 0, 0};
        assertEquals(0, solution._v1Solve(prices), "All zero prices should return 0");
    }
}
