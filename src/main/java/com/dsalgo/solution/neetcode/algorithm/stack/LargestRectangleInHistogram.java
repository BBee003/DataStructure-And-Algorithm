package com.dsalgo.solution.neetcode.algorithm.stack;

import java.util.*;

public class LargestRectangleInHistogram {

    /**
     * 
     * Pop element from stack if current height is less than top height.
     * Pop element till current height is greater than top height.
     * Calculate the area of rectange by tracking max value by popping element.
     * Store the total poped element.
     * If current height is greater than top height, update the top height index by deducing number of popped element.
     * Add the current element to the stack.
     * Response the maximum area of rectangle.
     * 
     * Complexity:
     *      1. Time: O(n) every element is once pushed and popped
     *      2. Space: O(n) every element need to be stored in a stack
     */
    public int _v1Solve(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i=0; i<heights.length; i++) {
            int currentHeight = heights[i];
            int start = i;
            while(!stack.isEmpty() && currentHeight < stack.peek()[1]) {
                int[] popHeight = stack.pop();
                maxArea = getMaxArea(maxArea, popHeight[0], i, popHeight[1]);
                start = popHeight[0];
            }
            stack.push(new int[]{start, currentHeight});
        }
        while(!stack.isEmpty()) {
            int[] popHeight = stack.pop();
            maxArea = getMaxArea(maxArea, popHeight[0], heights.length, popHeight[1]);
        }
        return maxArea;
    }

    private int getMaxArea(int oldArea, int start, int end, int height) {
        return Math.max(oldArea, height*(end-start));
    }
}