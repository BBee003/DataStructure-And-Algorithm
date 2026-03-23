package com.dsalgo.solution.neetcode.algorithm.binarysearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    private BinarySearch binarySearch;

    @BeforeEach
    void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    @DisplayName("Test target found in the middle")
    void testTargetFoundInMiddle() {
        int[] nums = {1, 3, 5, 7, 9};
        int target = 5;
        int expected = 2;
        assertEquals(expected, binarySearch._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test target found at the beginning")
    void testTargetFoundAtBeginning() {
        int[] nums = {1, 3, 5, 7, 9};
        int target = 1;
        int expected = 0;
        assertEquals(expected, binarySearch._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test target found at the end")
    void testTargetFoundAtEnd() {
        int[] nums = {1, 3, 5, 7, 9};
        int target = 9;
        int expected = 4;
        assertEquals(expected, binarySearch._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test target not found - should return -1")
    void testTargetNotFound() {
        int[] nums = {1, 3, 5, 7, 9};
        int target = 4;
        int expected = -1;
        assertEquals(expected, binarySearch._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test empty array")
    void testEmptyArray() {
        int[] nums = {};
        int target = 5;
        int expected = -1;
        assertEquals(expected, binarySearch._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test single element array - target found")
    void testSingleElementArrayTargetFound() {
        int[] nums = {5};
        int target = 5;
        int expected = 0;
        assertEquals(expected, binarySearch._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test single element array - target not found")
    void testSingleElementArrayTargetNotFound() {
        int[] nums = {5};
        int target = 3;
        int expected = -1;
        assertEquals(expected, binarySearch._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test two element array - first element")
    void testTwoElementArrayFirstElement() {
        int[] nums = {2, 8};
        int target = 2;
        int expected = 0;
        assertEquals(expected, binarySearch._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test two element array - second element")
    void testTwoElementArraySecondElement() {
        int[] nums = {2, 8};
        int target = 8;
        int expected = 1;
        assertEquals(expected, binarySearch._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test large array")
    void testLargeArray() {
        int[] nums = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = i * 2; // Even numbers from 0 to 1998
        }
        int target = 500; // Should be at index 250
        int expected = 250;
        assertEquals(expected, binarySearch._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test negative numbers")
    void testNegativeNumbers() {
        int[] nums = {-10, -5, 0, 5, 10};
        int target = -5;
        int expected = 1;
        assertEquals(expected, binarySearch._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test target smaller than all elements")
    void testTargetSmallerThanAll() {
        int[] nums = {1, 3, 5, 7, 9};
        int target = -1;
        int expected = -1;
        assertEquals(expected, binarySearch._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test target larger than all elements")
    void testTargetLargerThanAll() {
        int[] nums = {1, 3, 5, 7, 9};
        int target = 10;
        int expected = -1;
        assertEquals(expected, binarySearch._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test array with duplicate elements")
    void testArrayWithDuplicates() {
        int[] nums = {1, 2, 2, 2, 3, 4};
        int target = 2;
        // Note: The current implementation may return any index where the target is found
        int result = binarySearch._v1Solve(nums, target);
        assertTrue(result >= 1 && result <= 3, "Should return an index between 1 and 3");
        assertEquals(nums[result], target, "The returned index should contain the target value");
    }

    @Test
    @DisplayName("Test array with same elements")
    void testArrayWithSameElements() {
        int[] nums = {5, 5, 5, 5, 5};
        int target = 5;
        int result = binarySearch._v1Solve(nums, target);
        assertTrue(result >= 0 && result < nums.length, "Should return a valid index");
        assertEquals(nums[result], target, "The returned index should contain the target value");
    }

    @Test
    @DisplayName("Test array with same elements - target not found")
    void testArrayWithSameElementsTargetNotFound() {
        int[] nums = {5, 5, 5, 5, 5};
        int target = 3;
        int expected = -1;
        assertEquals(expected, binarySearch._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test boundary conditions - minimum values")
    void testBoundaryConditionsMinValues() {
        int[] nums = {Integer.MIN_VALUE, -1000, 0, 1000, Integer.MAX_VALUE};
        int target = Integer.MIN_VALUE;
        int expected = 0;
        assertEquals(expected, binarySearch._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test boundary conditions - maximum values")
    void testBoundaryConditionsMaxValues() {
        int[] nums = {Integer.MIN_VALUE, -1000, 0, 1000, Integer.MAX_VALUE};
        int target = Integer.MAX_VALUE;
        int expected = 4;
        assertEquals(expected, binarySearch._v1Solve(nums, target));
    }
}
