package com.dsalgo.solution.neetcode.algorithm.binarysearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class SearchinRotatedSortedArrayTest {

    private SearchinRotatedSortedArray searchinRotatedSortedArray;

    @BeforeEach
    void setUp() {
        searchinRotatedSortedArray = new SearchinRotatedSortedArray();
    }

    @Test
    @DisplayName("Test target found in non-rotated sorted array")
    void testTargetFoundInNonRotatedArray() {
        int[] nums = {1, 3, 5, 7, 9};
        int target = 5;
        int expected = 2;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test target found in rotated array - rotation at middle")
    void testTargetFoundInRotatedArrayMiddleRotation() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int expected = 4;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test target found in rotated array - rotation at start")
    void testTargetFoundInRotatedArrayStartRotation() {
        int[] nums = {7, 0, 1, 2, 3, 4, 5, 6};
        int target = 3;
        int expected = 4;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test target found in rotated array - rotation at end")
    void testTargetFoundInRotatedArrayEndRotation() {
        int[] nums = {2, 3, 4, 5, 6, 7, 0, 1};
        int target = 6;
        int expected = 4;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test target found at first position in rotated array")
    void testTargetFoundAtFirstPosition() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 4;
        int expected = 0;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test target found at last position in rotated array")
    void testTargetFoundAtLastPosition() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 2;
        int expected = 6;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test target not found in rotated array")
    void testTargetNotFoundInRotatedArray() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        int expected = -1;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test empty array")
    void testEmptyArray() {
        int[] nums = {};
        int target = 5;
        int expected = -1;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test single element array - target found")
    void testSingleElementArrayTargetFound() {
        int[] nums = {5};
        int target = 5;
        int expected = 0;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test single element array - target not found")
    void testSingleElementArrayTargetNotFound() {
        int[] nums = {5};
        int target = 3;
        int expected = -1;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test two element array - no rotation")
    void testTwoElementArrayNoRotation() {
        int[] nums = {1, 2};
        int target = 2;
        int expected = 1;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test two element array - rotated")
    void testTwoElementArrayRotated() {
        int[] nums = {2, 1};
        int target = 1;
        int expected = 1;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test large rotated array")
    void testLargeRotatedArray() {
        int[] nums = new int[1000];
        for (int i = 0; i < 1000; i++) {
            nums[i] = i;
        }
        // Rotate the array by 373 positions
        int[] rotated = new int[1000];
        for (int i = 0; i < 1000; i++) {
            rotated[i] = nums[(i + 373) % 1000];
        }
        
        int target = 500; // Original position 500, new position (500 - 373 + 1000) % 1000 = 127
        int expected = 127;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(rotated, target));
    }

    @Test
    @DisplayName("Test array with negative numbers - rotated")
    void testNegativeNumbersRotated() {
        int[] nums = {-2, -1, 0, 1, 2};
        // Rotate by 2 positions
        int[] rotated = {0, 1, 2, -2, -1};
        int target = -1;
        int expected = 4;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(rotated, target));
    }

    @Test
    @DisplayName("Test target smaller than all elements in rotated array")
    void testTargetSmallerThanAllRotated() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = -1;
        int expected = -1;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test target larger than all elements in rotated array")
    void testTargetLargerThanAllRotated() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 10;
        int expected = -1;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test array with maximum rotation")
    void testMaximumRotation() {
        int[] nums = {1, 2, 3, 4, 5};
        // Rotate by length-1 positions (equivalent to reverse order except last element)
        int[] rotated = {2, 3, 4, 5, 1};
        int target = 1;
        int expected = 4;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(rotated, target));
    }

    @Test
    @DisplayName("Test no rotation (sorted array)")
    void testNoRotation() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int target = 4;
        int expected = 3;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test rotation by 1 position")
    void testRotationByOne() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] rotated = {2, 3, 4, 5, 1};
        int target = 1;
        int expected = 4;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(rotated, target));
    }

    @Test
    @DisplayName("Test boundary conditions - minimum values")
    void testBoundaryConditionsMinValues() {
        int[] nums = {Integer.MIN_VALUE, -1000, 0, 1000, Integer.MAX_VALUE};
        // Rotate by 2 positions
        int[] rotated = {0, 1000, Integer.MAX_VALUE, Integer.MIN_VALUE, -1000};
        int target = Integer.MIN_VALUE;
        int expected = 3;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(rotated, target));
    }

    @Test
    @DisplayName("Test boundary conditions - maximum values")
    void testBoundaryConditionsMaxValues() {
        int[] nums = {Integer.MIN_VALUE, -1000, 0, 1000, Integer.MAX_VALUE};
        // Rotate by 2 positions
        int[] rotated = {0, 1000, Integer.MAX_VALUE, Integer.MIN_VALUE, -1000};
        int target = Integer.MAX_VALUE;
        int expected = 2;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(rotated, target));
    }

    @Test
    @DisplayName("Test array with duplicate elements - rotated")
    void testArrayWithDuplicatesRotated() {
        int[] nums = {1, 2, 2, 3, 4, 4, 5};
        // Rotate by 3 positions
        int[] rotated = {3, 4, 4, 5, 1, 2, 2};
        int target = 2;
        int result = searchinRotatedSortedArray._v1Solve(rotated, target);
        assertTrue(result >= 4 && result <= 6, "Should return an index between 4 and 6");
        assertEquals(rotated[result], target, "The returned index should contain the target value");
    }

    @Test
    @DisplayName("Test array with same elements")
    void testArrayWithSameElements() {
        int[] nums = {5, 5, 5, 5, 5};
        int target = 5;
        int result = searchinRotatedSortedArray._v1Solve(nums, target);
        assertTrue(result >= 0 && result < nums.length, "Should return a valid index");
        assertEquals(nums[result], target, "The returned index should contain the target value");
    }

    @Test
    @DisplayName("Test array with same elements - target not found")
    void testArrayWithSameElementsTargetNotFound() {
        int[] nums = {5, 5, 5, 5, 5};
        int target = 3;
        int expected = -1;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test target in left portion of rotated array")
    void testTargetInLeftPortion() {
        int[] nums = {6, 7, 0, 1, 2, 4, 5};
        int target = 7;
        int expected = 1;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test target in right portion of rotated array")
    void testTargetInRightPortion() {
        int[] nums = {6, 7, 0, 1, 2, 4, 5};
        int target = 2;
        int expected = 4;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test three element array - rotated")
    void testThreeElementArrayRotated() {
        int[] nums = {2, 3, 1};
        int target = 1;
        int expected = 2;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test three element array - target in middle")
    void testThreeElementArrayTargetInMiddle() {
        int[] nums = {2, 3, 1};
        int target = 3;
        int expected = 1;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test LeetCode example 1")
    void testLeetCodeExample1() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int expected = 4;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test LeetCode example 2")
    void testLeetCodeExample2() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        int expected = -1;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test LeetCode example 3")
    void testLeetCodeExample3() {
        int[] nums = {1};
        int target = 0;
        int expected = -1;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(nums, target));
    }

    @Test
    @DisplayName("Test performance with large rotated array")
    void testPerformanceWithLargeRotatedArray() {
        int[] nums = new int[10000];
        for (int i = 0; i < 10000; i++) {
            nums[i] = i;
        }
        // Rotate by 5000 positions
        int[] rotated = new int[10000];
        for (int i = 0; i < 10000; i++) {
            rotated[i] = nums[(i + 5000) % 10000];
        }
        
        int target = 7500;
        int expected = 2500;
        assertEquals(expected, searchinRotatedSortedArray._v1Solve(rotated, target));
    }
}
