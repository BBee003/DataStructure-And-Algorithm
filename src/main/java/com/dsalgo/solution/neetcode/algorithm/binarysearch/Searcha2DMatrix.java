package com.dsalgo.solution.neetcode.algorithm.binarysearch;

public class Searcha2DMatrix {

    /**
     * 
     * STEPS:
     *      1. Find the row first
     *          1. Pick middle array
     *          2. Check target value is in the range of middle array
     *          3. If not check target value is greater than last value or smaller than first value of middle array
     *          4. If target value is greater than last value,
     *              1. left = mid + 1;
     *          5. If target value is smaller than first value,
     *              1. right = mid - 1;
     *      2. Find the value by using binary search from that row
     * 
     * COMPLEXITY:
     *      1. Time: O(log m + log n)
     *      2. Space: O(1)
     */
    public boolean _v1Solve(int[][] nums, int target) {
        if (nums.length == 0 || nums[0].length == 0) return false;

        int left=0, right=nums.length-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if (nums[mid][0] <= target && target <= nums[mid][nums[mid].length-1]) {
                return _v1Search(nums[mid], target);
            } else if (target > nums[mid][nums[mid].length-1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }

    // Time: O(log n)
    // Space: O(1)
    private boolean _v1Search(int[] nums, int target) {
        if (nums.length == 0) return false;

        int left=0, right=nums.length-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * COMPLEXITY:
     *      1. Time: O(log(n*m))
     *      2. Space: O(1)
     * 
     * Note: it only works in the case that all the columns lengths are equal.
     */
    public boolean _v2Solve(int[][] nums, int target) {
        if (nums.length == 0 || nums[0].length == 0) return false;
        
        int rows = nums.length;
        int columns = nums[0].length;
        int left = 0, right = (rows * columns) - 1;

        while(left <= right) {

            int mid = left + (right - left) / 2;
            int row = mid / columns;
            int column = mid % columns;
            int value = nums[row][column];

            if (value > target) {
                right = mid - 1;
            } else if (value < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}