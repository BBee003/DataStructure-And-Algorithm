package com.dsalgo.solution.neetcode.algorithm.binarysearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FindMinimuminRotatedSortedArrayTest {

    private FindMinimuminRotatedSortedArray solution;

    @BeforeEach
    void setUp() {
        solution = new FindMinimuminRotatedSortedArray();
    }

    @Nested
    @DisplayName("Edge Cases")
    class EdgeCases {

        @Test
        @DisplayName("Empty array should throw IllegalArgumentException")
        void testEmptyArray() {
            int[] emptyArray = {};
            IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> solution._v1Solve(emptyArray)
            );
            assertEquals("Input nums is empty", exception.getMessage());
        }

        @Test
        @DisplayName("Single element array should return that element")
        void testSingleElement() {
            int[] singleElement = {5};
            assertEquals(5, solution._v1Solve(singleElement));
        }

        @Test
        @DisplayName("Two elements array")
        void testTwoElements() {
            int[] array1 = {2, 1};
            assertEquals(1, solution._v1Solve(array1));
            
            int[] array2 = {1, 2};
            assertEquals(1, solution._v1Solve(array2));
        }
    }

    @Nested
    @DisplayName("Normal Rotated Arrays")
    class NormalRotatedArrays {

        @Test
        @DisplayName("Array rotated once")
        void testRotatedOnce() {
            int[] nums = {4, 1, 2, 3};
            assertEquals(1, solution._v1Solve(nums));
        }

        @Test
        @DisplayName("Array rotated multiple times")
        void testRotatedMultipleTimes() {
            int[] nums = {3, 4, 5, 1, 2};
            assertEquals(1, solution._v1Solve(nums));
        }

        @Test
        @DisplayName("Array rotated to middle")
        void testRotatedToMiddle() {
            int[] nums = {5, 6, 1, 2, 3, 4};
            assertEquals(1, solution._v1Solve(nums));
        }

        @Test
        @DisplayName("Array rotated to end (same as original)")
        void testRotatedToEnd() {
            int[] nums = {1, 2, 3, 4, 5};
            assertEquals(1, solution._v1Solve(nums));
        }
    }

    @Nested
    @DisplayName("Special Cases")
    class SpecialCases {

        @Test
        @DisplayName("Array with duplicate minimum at rotation point")
        void testDuplicateMinimum() {
            int[] nums = {2, 1, 1, 2, 2};
            assertEquals(1, solution._v1Solve(nums));
        }

        @Test
        @DisplayName("All elements same")
        void testAllSameElements() {
            int[] nums = {2, 2, 2, 2, 2};
            assertEquals(2, solution._v1Solve(nums));
        }
    }

    @Nested
    @DisplayName("Negative Numbers")
    class NegativeNumbers {

        @Test
        @DisplayName("Array with negative numbers")
        void testNegativeNumbers() {
            int[] nums = {-3, -2, -1, -10, -9};
            assertEquals(-10, solution._v1Solve(nums));
        }

        @Test
        @DisplayName("Mixed positive and negative numbers")
        void testMixedNumbers() {
            int[] nums = {4, 5, 6, -2, -1, 0, 1, 2, 3};
            assertEquals(-2, solution._v1Solve(nums));
        }
    }

    @Nested
    @DisplayName("Boundary Values")
    class BoundaryValues {

        @Test
        @DisplayName("Integer maximum values")
        void testIntegerMaxValues() {
            int[] nums = {Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE, 
                         Integer.MIN_VALUE, Integer.MIN_VALUE + 1};
            assertEquals(Integer.MIN_VALUE, solution._v1Solve(nums));
        }

        @Test
        @DisplayName("Integer minimum values")
        void testIntegerMinValues() {
            int[] nums = {Integer.MIN_VALUE + 100, Integer.MIN_VALUE + 200, Integer.MIN_VALUE};
            assertEquals(Integer.MIN_VALUE, solution._v1Solve(nums));
        }
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("Parameterized test cases")
    void parameterizedTest(int[] nums, int expected) {
        assertEquals(expected, solution._v1Solve(nums));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new int[]{3, 4, 5, 1, 2}, 1),
            Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0),
            Arguments.of(new int[]{11, 13, 15, 17, 2, 5, 6, 8, 10}, 2),
            Arguments.of(new int[]{1}, 1),
            Arguments.of(new int[]{2, 1}, 1),
            Arguments.of(new int[]{1, 2}, 1),
            Arguments.of(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 1}, 1),
            Arguments.of(new int[]{6, 7, 0, 1, 2, 4, 5}, 0),
            Arguments.of(new int[]{10, 1, 10}, 1),
            Arguments.of(new int[]{1, 10, 10}, 1)
        );
    }

    @Nested
    @DisplayName("Algorithm Correctness")
    class AlgorithmCorrectness {

        @Test
        @DisplayName("Algorithm handles sorted array correctly")
        void testSortedArray() {
            int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            assertEquals(1, solution._v1Solve(nums));
        }

        @Test
        @DisplayName("Algorithm handles reverse rotation correctly")
        void testReverseRotation() {
            int[] nums = {9, 1, 2, 3, 4, 5, 6, 7, 8};
            assertEquals(1, solution._v1Solve(nums));
        }

        @Test
        @DisplayName("Algorithm handles minimum at different positions")
        void testMinimumAtDifferentPositions() {
            // Minimum at position 1
            int[] nums1 = {5, 1, 2, 3, 4};
            assertEquals(1, solution._v1Solve(nums1));
            
            // Minimum at position 2
            int[] nums2 = {5, 6, 1, 2, 3, 4};
            assertEquals(1, solution._v1Solve(nums2));
            
            // Minimum at position 3
            int[] nums3 = {5, 6, 7, 1, 2, 3, 4};
            assertEquals(1, solution._v1Solve(nums3));
        }
    }
}
