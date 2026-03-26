package com.dsalgo.solution.neetcode.algorithm.binarysearch;

public class MedianofTwoSortedArrays {

    /**
     * 
     * STEPS:
     *      1. Merge two inputs by using two pointers technique by maintaining ascending order.
     *      2. If the size of array is even, ((n / 2) + ((n/2)-1)) / 2 -> median
     *      3. If the size of array is odd, n / 2 -> median
     * COMPLEXITY:
     *      1. Time: O(n+m)
     *      2. Space: O(n+m)
     */
    public double _v1Solve(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) throw new IllegalArgumentException("Empty input nums1 and nums2");
        int[] merged = merge(nums1, nums2);
        if (merged.length%2 == 0) {
            return (double) (merged[merged.length/2] + merged[(merged.length/2)-1]) / 2;
        } else {
            return merged[merged.length/2];
        }
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int n1 = 0, n2 = 0;
        int r1 = 0;
        while(n1 < nums1.length || n2 < nums2.length) {
            int n1Val = n1 < nums1.length ? nums1[n1] : Integer.MAX_VALUE;
            int n2Val = n2 < nums2.length ? nums2[n2] : Integer.MAX_VALUE;

            if (n1Val < n2Val) {
                res[r1] = n1Val;
                n1++;
            } else if (n1Val > n2Val) {
                res[r1] = n2Val;
                n2++;
            } else {
                res[r1] = n1Val;
                r1++;
                res[r1] = n2Val;
                n1++;
                n2++;
            }

            r1++;
        }
        return res;
    }

    public double _v2Solve(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int mid = total / 2;

        int i = 0, j = 0;
        int prev = 0, curr = 0;

        for (int k = 0; k <= mid; k++) {
            prev = curr;

            if (i < nums1.length && (j >= nums2.length || nums1[i] < nums2[j])) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }
        }

        if (total % 2 == 0) {
            return (prev + curr) / 2.0;
        } else {
            return curr;
        }
    }

    public double _v3Solve(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) throw new IllegalArgumentException("Input arrays are empty");

        if (nums1.length > nums2.length) {
            return _v3Solve(nums2, nums1);
        }
        
        int total = nums1.length + nums2.length;
        int half = (total+1) / 2; // for odd
        int left = 0, right = nums1.length; // not nums1.length-1 because valid cut range is 0 to nums1.length

        while(left <= right) {
            int cut1 = left + (right - left) / 2;
            int cut2 = half - cut1;

            int rightMin1 = cut1 < nums1.length ? nums1[cut1] : Integer.MAX_VALUE;
            int leftMax1 = cut1 > 0 ? nums1[cut1-1] : Integer.MIN_VALUE;

            int rightMin2 = cut2 < nums2.length ? nums2[cut2] : Integer.MAX_VALUE;
            int leftMax2 = cut2 > 0 ? nums2[cut2-1] : Integer.MIN_VALUE;

            if (Math.max(leftMax1, leftMax2) <= Math.min(rightMin1, rightMin2)) {
                if (total % 2 == 0) {
                    return (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0;
                } else {
                    return Math.max(leftMax1, leftMax2);
                }
            } else if (leftMax1 > rightMin2) {
                right = cut1 - 1;
            } else {
                left = cut1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted in ascending.");
    }
}
