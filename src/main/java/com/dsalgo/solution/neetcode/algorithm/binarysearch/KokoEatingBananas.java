package com.dsalgo.solution.neetcode.algorithm.binarysearch;

public class KokoEatingBananas {

    public int _v1Solve(int[] piles, int h) {
        if (piles.length == 0) throw new IllegalArgumentException("Input piles is empty");

        int l = 1, r = getMax(piles);
        int minRate = r;

        while(l <= r) {
            int k = l + (r-l) / 2;
            int hours = 0;
            for (int pile: piles) {
                hours += (int) Math.ceil((double) pile / k);
            }
            if (hours > h) {
                l = k + 1;
            } else {
                r = k - 1;
                minRate = Math.min(minRate, k);
            }
        }

        return minRate;
    }

    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile: piles) {
            if (max < pile) max = pile;
        }
        return max;
    }
}
