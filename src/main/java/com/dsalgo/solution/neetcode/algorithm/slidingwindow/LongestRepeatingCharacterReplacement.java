package com.dsalgo.solution.neetcode.algorithm.slidingwindow;

import java.util.*;

public class LongestRepeatingCharacterReplacement {

    public int _v1Solve(String s, int k) {
        if (s.isEmpty()) return 0;
        HashMap<Character, Integer> counter = new HashMap<>();
        int longest = 0, maxF = 0, l = 0;
        for (int r = 0; r < s.length(); r++) {
            counter.put(s.charAt(r), counter.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, counter.get(s.charAt(r)));
            while ((r-l+1)-maxF > k) {
                counter.put(s.charAt(l), counter.get(s.charAt(l))-1);
                l++;
            }
            longest  = Math.max(longest, r-l+1);
        }
        return longest;
    }
}
