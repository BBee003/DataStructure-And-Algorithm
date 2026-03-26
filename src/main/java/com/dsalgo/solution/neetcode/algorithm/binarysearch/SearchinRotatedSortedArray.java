package com.dsalgo.solution.neetcode.algorithm.binarysearch;

public class SearchinRotatedSortedArray {

    public int _v1Solve(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int l=0, r=nums.length-1;
        while(l <= r) {
            // if (nums[l] < nums[r]) return _v1BinarySearch(l, r, nums, target);

            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] >= nums[l]) {
                // in left portion
                if (target < nums[mid] && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // in right portion
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

    // Unnecessary optimization
    // private int _v1BinarySearch(int start, int end, int[] nums, int target) {
    //     if (nums.length == 0) return -1;
    //     if (start < 0 || start >= nums.length) return -1;
    //     if (end < 0 || start >= nums.length) return -1;
    //     if (start > end) return -1;

    //     while(start <= end) {
    //         int mid = start + (end - start) / 2;
    //         if (nums[mid] > target) {
    //             end = mid - 1;
    //         } else if (nums[mid] < target) {
    //             start = mid + 1;
    //         } else {
    //             return mid;
    //         }
    //     }

    //     return -1;
    // }
}
