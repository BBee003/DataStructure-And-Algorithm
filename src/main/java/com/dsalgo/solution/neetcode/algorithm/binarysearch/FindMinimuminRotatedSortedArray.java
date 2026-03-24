package com.dsalgo.solution.neetcode.algorithm.binarysearch;

public class FindMinimuminRotatedSortedArray {

    public int _v1Solve(int[] nums) {
        if (nums.length == 0) throw new IllegalArgumentException("Input nums is empty");

        int l = 0, r = nums.length-1, min = nums[0];
        while(l <= r) {
            if (nums[l] < nums[r]) return Math.min(min, nums[l]);
            int mid = l + (r-l) / 2;
            min = Math.min(min, nums[mid]);
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return min;
    }
}
