package com.dsalgo.solution.neetcode.algorithm.stack;

import com.dsalgo.solution.neetcode.datastructure.*;

public class DailyTemperatures {

    /*
     * STPES:
     *      1. First loop to get the individual termperature
     *      2. Second loop to calculate the number of days after current day before a warmer temperature appear on a future day
     *          1. Calculate the total number of days
     *          2. Add the total number of days to response array
     *      3. Return the final array
     * 
     * COMPLEXITY:
     *      1. Time: O(n^2)
     *      2. Space: O(1)
     */
    public int[] _v1Solve(int[] temperatures) {
        int[] results = new int[temperatures.length];
        for (int i=0; i<temperatures.length; i++) {
            for (int j=i+1; j<temperatures.length; j++) {   
                if (temperatures[i] < temperatures[j]) {
                    results[i] = j-i;
                    break;
                }
            }
        }
        return results;
    }

    /*
     * COMPLEXITY:
     * 1. Time: O(n)
     * 2. Space: O(n)
     * 
     * 💡 Key Idea: Use a Monotonic Stack
     *      Instead of re-scanning, we remember unresolved days and resolve them when we find a warmer temperature.
     * 
     * 🧠 Intuition
     *      1. Keep a stack of indices (not temperatures)
     *      2. The stack stores days waiting for a warmer temperature
     *      3. Maintain it in decreasing temperature order
     */
    public int[] _v2Solve(int[] temperatures) {
        int n = temperatures.length;
        int[] results  = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int previousIndex = stack.pop();
                results[previousIndex] = i - previousIndex;
            }
            stack.push(i);
        }

        return results;
    }
}
