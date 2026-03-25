package com.dsalgo.solution.neetcode.algorithm.binarysearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class MedianofTwoSortedArraysTest {

    private MedianofTwoSortedArrays medianFinder;

    @BeforeEach
    void setUp() {
        medianFinder = new MedianofTwoSortedArrays();
    }

    @Test
    @DisplayName("Test both arrays empty")
    void testBothArraysEmpty() {
        int[] nums1 = {};
        int[] nums2 = {};
        
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> medianFinder._v1Solve(nums1, nums2)
        );
        assertEquals("Empty input nums1 and nums2", exception.getMessage());
    }

    @Test
    @DisplayName("Test first array empty, second non-empty")
    void testFirstArrayEmpty() {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        
        assertEquals(2.0, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test second array empty, first non-empty")
    void testSecondArrayEmpty() {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {};
        
        assertEquals(2.5, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test both arrays with single element")
    void testBothSingleElement() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        
        assertEquals(1.5, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test both arrays with same single element")
    void testBothSameSingleElement() {
        int[] nums1 = {5};
        int[] nums2 = {5};
        
        assertEquals(5.0, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test one array single element, other multiple")
    void testOneSingleElementOtherMultiple() {
        int[] nums1 = {3};
        int[] nums2 = {1, 2, 4, 5, 6};
        
        assertEquals(3.5, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test arrays with same length")
    void testSameLengthArrays() {
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        
        assertEquals(3.5, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test arrays with different lengths")
    void testDifferentLengthArrays() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4, 5, 6, 7, 8};
        
        assertEquals(4.5, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test odd total length")
    void testOddTotalLength() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5};
        
        assertEquals(3.0, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test even total length")
    void testEvenTotalLength() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        
        assertEquals(2.5, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test arrays with negative numbers")
    void testNegativeNumbers() {
        int[] nums1 = {-5, -3, -1};
        int[] nums2 = {-4, -2, 0};
        
        assertEquals(-2.5, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test arrays with mixed positive and negative")
    void testMixedPositiveNegative() {
        int[] nums1 = {-3, -1, 2};
        int[] nums2 = {0, 4, 5};
        
        assertEquals(1.0, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test arrays with duplicates")
    void testDuplicates() {
        int[] nums1 = {1, 2, 2, 3};
        int[] nums2 = {2, 2, 4, 5};
        
        assertEquals(2.0, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test arrays with all same elements")
    void testAllSameElements() {
        int[] nums1 = {2, 2, 2};
        int[] nums2 = {2, 2, 2};
        
        assertEquals(2.0, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test large arrays")
    void testLargeArrays() {
        int[] nums1 = new int[1000];
        int[] nums2 = new int[1000];
        
        for (int i = 0; i < 1000; i++) {
            nums1[i] = i * 2;
            nums2[i] = i * 2 + 1;
        }
        
        assertEquals(999.5, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test one array much larger than other")
    void testUnevenArrays() {
        int[] nums1 = {1};
        int[] nums2 = new int[100];
        for (int i = 0; i < 100; i++) {
            nums2[i] = i + 2;
        }
        
        assertEquals(51.0, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test arrays with min integer values")
    void testMinIntegerValues() {
        int[] nums1 = {Integer.MIN_VALUE, Integer.MIN_VALUE + 1};
        int[] nums2 = {Integer.MIN_VALUE + 2};
        
        assertEquals(Integer.MIN_VALUE + 1.0, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test arrays with zero values")
    void testZeroValues() {
        int[] nums1 = {0, 0, 0};
        int[] nums2 = {0, 0};
        
        assertEquals(0.0, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test non-overlapping ranges")
    void testNonOverlappingRanges() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {100, 101, 102};
        
        assertEquals(51.5, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test interleaved arrays")
    void testInterleavedArrays() {
        int[] nums1 = {1, 4, 7, 10};
        int[] nums2 = {2, 5, 8, 11};
        
        assertEquals(6, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test one array completely before other")
    void testOneArrayBeforeOther() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};
        
        assertEquals(3.5, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test single element arrays with odd total")
    void testSingleElementOddTotal() {
        int[] nums1 = {1};
        int[] nums2 = {2, 3};
        
        assertEquals(2.0, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test single element arrays with even total")
    void testSingleElementEvenTotal() {
        int[] nums1 = {1};
        int[] nums2 = {2};
        
        assertEquals(1.5, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test three element arrays")
    void testThreeElementArrays() {
        int[] nums1 = {1, 5, 9};
        int[] nums2 = {2, 6, 10};
        
        assertEquals(5.5, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test boundary case with small arrays")
    void testBoundarySmallArrays() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        
        assertEquals(2.0, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test LeetCode example 1")
    void testLeetCodeExample1() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        
        assertEquals(2.0, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test LeetCode example 2")
    void testLeetCodeExample2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        
        assertEquals(2.5, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test complex scenario with mixed sizes and values")
    void testComplexScenario() {
        int[] nums1 = {-10, -5, 0, 3, 7};
        int[] nums2 = {-8, -3, 1, 4, 9, 12};
        
        assertEquals(1.0, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test array with consecutive numbers")
    void testConsecutiveNumbers() {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {6, 7, 8, 9, 10};
        
        assertEquals(5.5, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test array with same numbers")
    void testSameNumbers() {
        int[] nums1 = {5, 5, 5};
        int[] nums2 = {5, 5};
        
        assertEquals(5.0, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test precision with large numbers")
    void testPrecisionLargeNumbers() {
        int[] nums1 = {1000000, 1000001};
        int[] nums2 = {1000002, 1000003};
        
        assertEquals(1000001.5, medianFinder._v1Solve(nums1, nums2));
    }

    @Test
    @DisplayName("Test edge case with single element result")
    void testEdgeCaseSingleElementResult() {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {5};
        
        assertEquals(3.0, medianFinder._v1Solve(nums1, nums2));
    }
}
