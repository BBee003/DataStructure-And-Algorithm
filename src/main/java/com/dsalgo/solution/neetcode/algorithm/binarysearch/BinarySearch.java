package com.dsalgo.solution.neetcode.algorithm.binarysearch;

public class BinarySearch {

    public int _v1Solve(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int left=0, right=nums.length-1;
        while(left <= right) {
            int mid = (left+right)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
 
        return -1;
    }
}