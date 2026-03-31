package com.dsalgo.solution.neetcode.algorithm.slidingwindow;

import java.util.*;

public class MinimumWindowSubstring {

    /**
     * Intuition:
     * 1. substring.length() >= t.length()
     * 2. minimum t.length() and expand until it meets condition
     * 
     * 3. check condition: substring contains all the characters from t
     * 4. if violate condition: expand
     * 5. if meet condition: update min substring and shrink until
     * substring.charCount == t.charCount
     * 6. meet condition: substring.charCount >= t.charCount
     * 
     * Complexity:
     * 1. Time: O(n)
     * 2. Space: O(1)
     */
    public String _v1Solve(String s, String t) {
        if (s.isEmpty() || t.isEmpty() || t.length() > s.length())
            return "";

        Map<Character, Integer> tCounter = new HashMap<>();
        Map<Character, Integer> sCounter = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tCounter.put(t.charAt(i), tCounter.getOrDefault(t.charAt(i), 0) + 1);
            sCounter.put(s.charAt(i), sCounter.getOrDefault(s.charAt(i), 0) + 1);
        }

        String res = "";
        int l = 0, r = t.length();
        while (r <= s.length()) {
            // if meet condition, update minimum substring and shrink
            if (matches(tCounter, sCounter)) {
                String substring = s.substring(l, r);
                if (res.isEmpty() || res.length() > substring.length())
                    res = substring;
                sCounter.put(s.charAt(l), sCounter.get(s.charAt(l)) - 1);
                l++;
            } else {
                // if condition violate, grow
                if (r < s.length())
                    sCounter.put(s.charAt(r), sCounter.getOrDefault(s.charAt(r), 0) + 1);
                r++;
            }
        }

        return res;
    }

    private boolean matches(Map<Character, Integer> tCounter, Map<Character, Integer> sCounter) {
        for (char key : tCounter.keySet()) {
            if (sCounter.getOrDefault(key, 0) < tCounter.get(key))
                return false;
        }
        return true;
    }

    public String _v2Solve(String s, String t) {
        if (s.isEmpty() || t.isEmpty() || t.length() > s.length()) return "";

        Map<Character, Integer> tCounter = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tCounter.put(t.charAt(i), tCounter.getOrDefault(t.charAt(i), 0) + 1);
        }

        int[] res = null;
        int have = 0, need = tCounter.size(), l = 0;
        Map<Character, Integer> window = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char rChar = s.charAt(r);

            if (tCounter.containsKey(rChar)) {
                window.put(rChar, window.getOrDefault(rChar, 0) + 1);
                if (window.get(rChar) == tCounter.get(rChar)) {
                    have++;
                }
            }

            while (have == need) {
                if (res == null || (res[1] - res[0] + 1) > (r - l + 1)) {
                    if (res == null) res = new int[2];
                    res[0] = l;
                    res[1] = r;
                }
                if (tCounter.containsKey(s.charAt(l))) {
                    window.put(s.charAt(l), window.get(s.charAt(l)) - 1);
                    if (window.get(s.charAt(l)) < tCounter.get(s.charAt(l))) {
                        have--;
                    }
                }
                l++;
            }
        }

        return res == null ? "" : s.substring(res[0], res[1] + 1);
    }
}
