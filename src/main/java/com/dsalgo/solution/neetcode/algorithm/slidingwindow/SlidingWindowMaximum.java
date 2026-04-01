package com.dsalgo.solution.neetcode.algorithm.slidingwindow;

import java.util.*;

public class SlidingWindowMaximum {
    
    /**
     * Complexity:
     *  1. Time: O(nk)
     *  2. Space: O(k)
     */
    public int[] _v1Solve(int[] nums, int k) {
        if (nums.length == 0) return nums;

        List<Integer> res = new ArrayList<>();
        int l=0;
        for (int r=0; r<nums.length; r++) {
            if ((r-l+1) == k) {
                res.add(getMax(nums, l, r));
                l++;
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private int getMax(int[] nums, int l, int r) {
        int max = Integer.MIN_VALUE;
        for (int i=l; i<=r; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    /**
     * Intuition:
     *  1. Use array deque
     *  2. When right pointer move, add value in monotonically descreasing order
     *  3. When left pointer move, if preVal == popItem: remove from deque
     *  4. If left and right pointer in window size, add the max value from deque to result
     * 
     * Complexity:
     *  1. Time: O(n)
     *  2. Space: O(k)
     */
    public int[] _v2Solve(int[] nums, int k) {
        if (nums.length == 0 || k > nums.length) return new int[0];

        List<Integer> res = new ArrayList<>();
        Deque<Integer> deq = new ArrayDeque<>();

        int l=0;
        for (int r=0; r<nums.length; r++) {

            // remove smaller elements from back
            while(!deq.isEmpty() && nums[r] > nums[deq.peekLast()]) {
                deq.pollLast();
            }
            deq.offer(r);

            
            // window formed
            if ((r - l + 1) == k) {
                res.add(nums[deq.peekFirst()]);
                l++;
                if (deq.peekFirst() < l) deq.pollFirst();
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
