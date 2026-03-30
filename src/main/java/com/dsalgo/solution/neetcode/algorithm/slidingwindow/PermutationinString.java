package com.dsalgo.solution.neetcode.algorithm.slidingwindow;

import java.util.*;

public class PermutationinString {

    /**
     * Intuition:
     *  1. Slide window for s2 with length of s1
     *  2. Track the chracters within the range
     *  3. Check s2 window substring is the permutation of s1
     */
    public boolean _v1Solve(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) return false;
        int l = 0, r = 0;
        while(r < s2.length()) {
            String subString = s2.substring(l, r+1);
            if ((r-l+1) == s1.length()) {
                if (isPermutation(s1, subString)) return true;
                l++;
            }
            r++;
        }
        return false;
    }

    private boolean isPermutation(String s1, String s2) {
        if (s2.length() != s1.length()) return false;

        HashMap<Character, Integer> s1Chars = new HashMap<>();
        HashMap<Character, Integer> s2Chars = new HashMap<>();
        for (int i=0; i<s1.length(); i++) {
            s1Chars.put(s1.charAt(i), s1Chars.getOrDefault(s1.charAt(i), 0) + 1);
            s2Chars.put(s2.charAt(i), s2Chars.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for (char key: s1Chars.keySet()) {
            if (s1Chars.get(key) != s2Chars.getOrDefault(key, 0)) return false;
        }

        for (char key: s2Chars.keySet()) {
            if (s2Chars.get(key) != s1Chars.getOrDefault(key, 0)) return false;
        }

        return true;
    }

    /**
     * Complexity:
     *  1. Time: O(26n) -> O(n)
     *  2. Space: O(1)
     */
    public boolean _v2Solve(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty() || s2.length() < s1.length()) return false;

        int[] s1F = new int[26];
        for (int i=0; i<s1.length(); i++) {
            s1F[s1.charAt(i) - 'a']++;
        }
        
        int l=0;
        int[] s2W = new int[26];
        for (int r=0; r<s2.length(); r++) {
            s2W[s2.charAt(r)-'a']++;
            if ((r-l+1) == s1.length()) {
                if (matches(s1F, s2W)) return true;
                s2W[s2.charAt(l)-'a']--;
                l++;
            }
        }

        return false;
    }

    private boolean matches(int[] s1, int[] s2) {
        for (int i=0; i<s1.length; i++) {
            if (s1[i] != s2[i]) return false;
        }
        return true;
    }

    /**
     * Complexity:
     *  1. Time: O(26 + n) -> O(n)
     *  2. Space: O(26) -> O(1)
     */
    public boolean _v3Solve(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty() || s2.length() < s1.length()) return false;

        int[] s1F = new int[26];
        int[] s2F = new int[26];
        for (int i=0; i<s1.length(); i++) {
            s1F[s1.charAt(i)-'a']++;
            s2F[s2.charAt(i)-'a']++;
        }

        int matches = 0;
        for (int i=0; i<26; i++) {
            if (s1F[i] == s2F[i]) matches++;
        }
        
        int l=0;
        for (int r=s1.length(); r<s2.length(); r++) {
            if (matches == 26) return true;
            int index = s2.charAt(r) - 'a';
            s2F[index]++;

            if (s1F[index] == s2F[index]) {
                matches++;
            } else if ((s1F[index]+1) == s2F[index]) {
                matches--;
            }

            index = s2.charAt(l)-'a';
            s2F[index]--;
            if (s1F[index] == s2F[index]) {
                matches++;
            } else if ((s1F[index]-1) == s2F[index]) {
                matches--;
            }
            l++;
        }

        return matches == 26;
    }
}
