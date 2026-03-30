package com.dsalgo.solution.neetcode.algorithm.slidingwindow;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 
     * Complexity:
     *  1. Time: O(n)
     *  2. Space: O(n)
     */
    public int _v1Solve(String s) {
        if (s.isEmpty()) return 0;

        int longest = 0;
        int left = 0, right = 0;
        HashSet<Character> reached = new HashSet<>();
        while(right < s.length()) {
            while (reached.contains(s.charAt(right))) {
                reached.remove(s.charAt(left));
                left++;
            }
            longest = Math.max(longest, right-left+1);
            reached.add(s.charAt(right));
            right++;
        }

        return longest;
    }
}