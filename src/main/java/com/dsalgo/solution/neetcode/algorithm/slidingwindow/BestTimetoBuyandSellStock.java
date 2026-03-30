package com.dsalgo.solution.neetcode.algorithm.slidingwindow;

public class BestTimetoBuyandSellStock {

    /**
     * 
     * Intuition:
     *  1. Use sliding window technique
     *  2. If lose, shrink the window
     *  3. If profit, expand the window 
     * 
     * Complexity:
     *  1. Time: O(n)
     *  2. Space: O(1)
     */
    public int _v1Solve(int[] prices) {
        if (prices.length == 0) return 0;

        int maxProfit = 0;
        int buy = 0, sell = 0;
        while(sell < prices.length) {
            int profit = prices[sell] - prices[buy];
            if (profit < 0) {
                buy++;
            } else {
                maxProfit = Math.max(maxProfit, profit);
                sell++;
            }
        }

        return maxProfit;
    }

    public int _v2Solve(int[] prices) {
        if (prices.length == 0)
            return 0;

        int maxProfit = 0;
        int buy = 0;

        for (int sell = 1; sell < prices.length; sell++) {
            if (prices[sell] < prices[buy]) {
                buy = sell; // reset to new minimum
            } else {
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            }
        }

        return maxProfit;
    }
}