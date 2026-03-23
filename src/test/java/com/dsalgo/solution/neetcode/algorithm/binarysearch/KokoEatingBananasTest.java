package com.dsalgo.solution.neetcode.algorithm.binarysearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class KokoEatingBananasTest {

    private KokoEatingBananas kokoEatingBananas;

    @BeforeEach
    void setUp() {
        kokoEatingBananas = new KokoEatingBananas();
    }

    @Test
    @DisplayName("Test basic example from LeetCode")
    void testBasicExample() {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(4, result);
    }

    @Test
    @DisplayName("Test example with more hours than piles")
    void testMoreHoursThanPiles() {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 5;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(30, result);
    }

    @Test
    @DisplayName("Test example with large hours")
    void testLargeHours() {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 6;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(23, result);
    }

    @Test
    @DisplayName("Test single pile with exact hours")
    void testSinglePileExactHours() {
        int[] piles = {10};
        int h = 10;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Test single pile with one hour")
    void testSinglePileOneHour() {
        int[] piles = {10};
        int h = 1;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(10, result);
    }

    @Test
    @DisplayName("Test all piles same size")
    void testAllPilesSameSize() {
        int[] piles = {5, 5, 5, 5};
        int h = 8;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Test minimum eating rate")
    void testMinimumEatingRate() {
        int[] piles = {1, 1, 1, 1};
        int h = 4;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Test large pile sizes")
    void testLargePileSizes() {
        int[] piles = {1000000, 1000000, 1000000};
        int h = 3;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(1000000, result);
    }

    @Test
    @DisplayName("Test hours equals number of piles")
    void testHoursEqualsNumberOfPiles() {
        int[] piles = {3, 6, 7, 11};
        int h = 4;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(11, result);
    }

    @Test
    @DisplayName("Test very large hours")
    void testVeryLargeHours() {
        int[] piles = {3, 6, 7, 11};
        int h = 100;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Test two piles")
    void testTwoPiles() {
        int[] piles = {3, 6};
        int h = 4;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Test increasing pile sizes")
    void testIncreasingPileSizes() {
        int[] piles = {1, 2, 3, 4, 5};
        int h = 10;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Test decreasing pile sizes")
    void testDecreasingPileSizes() {
        int[] piles = {5, 4, 3, 2, 1};
        int h = 10;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(2, result);
    }

    @Test
    @DisplayName("Test boundary condition - smallest possible input")
    void testBoundaryConditionSmallestInput() {
        int[] piles = {1};
        int h = 1;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Test when eating rate must be maximum pile size")
    void testEatingRateMustBeMaxPileSize() {
        int[] piles = {10, 20, 30};
        int h = 3;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(30, result);
    }

    @Test
    @DisplayName("Test empty piles array should throw exception")
    void testEmptyPilesArray() {
        int[] piles = {};
        int h = 8;
        assertThrows(IllegalArgumentException.class, () -> {
            kokoEatingBananas._v1Solve(piles, h);
        });
    }

    @Test
    @DisplayName("Test with all zero piles")
    void testAllZeroPiles() {
        int[] piles = {0, 0, 0};
        int h = 5;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Test mathematical precision with division")
    void testMathematicalPrecisionWithDivision() {
        int[] piles = {1, 2, 3};
        int h = 3;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Test when hours exactly matches minimum possible")
    void testHoursExactlyMatchesMinimumPossible() {
        int[] piles = {1, 1, 1};
        int h = 3;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Test binary search boundary conditions")
    void testBinarySearchBoundaryConditions() {
        int[] piles = {1, 1000000000};
        int h = 2;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(1000000000, result);
    }

    @Test
    @DisplayName("Test edge case where k equals pile size exactly")
    void testEdgeCaseKEqualsPileSizeExactly() {
        int[] piles = {4, 8, 12};
        int h = 6;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(4, result);
    }

    @Test
    @DisplayName("Test when optimal rate creates exact hour match")
    void testOptimalRateCreatesExactHourMatch() {
        int[] piles = {6, 6, 6};
        int h = 6;
        int result = kokoEatingBananas._v1Solve(piles, h);
        assertEquals(3, result);
    }
}
